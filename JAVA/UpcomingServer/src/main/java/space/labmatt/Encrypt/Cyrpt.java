package space.labmatt.Encrypt;

import space.labmatt.Tools.ProjectPath;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

public class Cyrpt {

    private SecretKey secretKey = null;
    private String algorithm = "AES";
    private boolean enableEncypt = false;

    public Cyrpt(ProjectPath path) {

        String testFilePath = path.getPath() + File.separator + "upcomingServer" + File.separator + "authenticate.file";

        // Check if key has been generated. If no then ask if we want to.
        checkAuthFile(testFilePath);

        System.out.println("Enter Encryption Key: ");

        String testKey = "";

        // decode a preexisting file to see if the key is correct. If so then continue if not then wait for new key.
        boolean correctKey = false;
        while (!correctKey) {

            Scanner myObj = new Scanner(System.in);
            testKey = myObj.nextLine();

            byte[] decode = Base64.getDecoder().decode(testKey);
            secretKey = new SecretKeySpec(decode, 0, decode.length, algorithm);

            String testfile = readAuthenticateFile(testFilePath);
            String data = dataDecrypt(testfile);

            System.out.println("Data was: " + data);

            if(data == null) {

                System.out.println("Error verifying key. Try again.");

            } else if (data.equals("The quick brown fox jumped over tha lazy dog.")) {

                System.out.println("Key Verified Successfully.");
                correctKey = true;
            } else {

                System.out.println("Incorrect Key.");
                System.out.println("Enter Encryption Key: ");
                secretKey = null;
            }
        }
    }


    // take plain text in and decript it.
    public String dataDecrypt(String dataString) {

        if(!enableEncypt) {

            return dataString;
        }

        String returnData = null;

        try {

            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] ciphertext = cipher.doFinal(dataString.getBytes());
            returnData = Arrays.toString(ciphertext);

        } catch (Exception e) {

            System.out.println("Error Decrypting." + e.getMessage());
        }

        return returnData;
    }


    // String input gets incrupted and then returned. Null if failure
    public String dataEncrypt(String dataString) {

        if(!enableEncypt) {

            return dataString;
        }

         String dataEnc = null;

        try {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            //byte[] base64encodedString = Base64.getEncoder().encode(dataString.getBytes(StandardCharsets.UTF_8));
            byte[] cipherBytes = cipher.doFinal(dataString.getBytes());
            dataEnc = Arrays.toString(cipherBytes);

        } catch (Exception e) {

            System.out.println("Encrytion error: " + e.getMessage());
        }

        return dataEnc;
    }


    // CheckAuthFile looks to see if the file that we will check the key against exists.
    // If it does not then we should gen a new key. Then make a "authenticate.file" encrypted with this new key.
    // Print out the new key for user to copy.
    private void checkAuthFile(String authFile) {

        File file = new File(authFile);
        if (!file.isFile()) {

            System.out.println("\"authenticate.file\" Does not exist.");
            System.out.println("Assuming First time start and no Encryption key has been chosen.");
            System.out.println("Would you like to Generate a key and the \"authenticate.file\"? (y,n):");

            boolean genNewKey = true;
            boolean validAnswer = false;
            while (!validAnswer) {

                Scanner myObj = new Scanner(System.in);
                String answer = myObj.nextLine();

                if (answer.equals("y")) {

                    validAnswer = true;
                } else if (answer.equals("n")) {

                    genNewKey = false;
                    validAnswer = true;
                } else {

                    System.out.println("Invalid answer. y = yes, n = no.");
                }
            }

            if (genNewKey) {

                try {
                    KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
                    //keyGenerator.init(256);
                    SecretKey newKey = keyGenerator.generateKey();
                    String base64Newkey = Base64.getEncoder().encodeToString(newKey.getEncoded());

                    System.out.println("Generating new key.");
                    System.out.println("COPY KEY NOW AND KEEP SAFE!!! YOU WILL REQUIRE IT TO ENCRYPT AND DECRYPT FILES ON FIRST PROGRAM START. KEY:");
                    System.out.println(" ");
                    System.out.println(base64Newkey);
                    System.out.println(" ");
                    secretKey = newKey;

                    boolean newAuthFile = file.createNewFile();

                    if (newAuthFile) {

                        String verifyString = "The quick brown fox jumped over tha lazy dog.";
                        verifyString = dataEncrypt(verifyString);
                        System.out.println("Encypted String: " + verifyString);
                        System.out.println("DecriptedFileDataWilLBe: " + dataDecrypt(verifyString));

                        FileWriter fileWriter = new FileWriter(authFile);
                        fileWriter.write(verifyString);
                        fileWriter.close();

                        System.out.println("Created \"authenticate.file\".");
                    } else {

                        System.out.println("Failed to create \"authenticate.file\".");
                    }

                } catch (Exception e) {

                    System.out.println("Failed to generate key... " + e.getMessage());
                }

                System.out.println("Press any key to continue...");
                Scanner myObj = new Scanner(System.in);
                myObj.nextLine();
            }

            System.out.println("Exiting key gen.");
        }

        secretKey = null;
    }


    // Reads authenticate.file files data.
    private String readAuthenticateFile(String path) {

        String returnAuthFileContent = null;

        try {

            StringBuilder stringBuilder = new StringBuilder();

            FileReader fileReader = new FileReader(path);
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine();
            while ((line != null)) {

                stringBuilder.append(line);
                line = br.readLine();
            }

            returnAuthFileContent = stringBuilder.toString();

        } catch (Exception e) {

            System.out.println("Error getting Authenticate file.");
        }

        return returnAuthFileContent;
    }
}
