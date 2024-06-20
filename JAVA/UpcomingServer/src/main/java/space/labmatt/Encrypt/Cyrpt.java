package space.labmatt.Encrypt;

import space.labmatt.Tools.ProjectPath;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class Cyrpt {

    public SecretKey secretKey = null;

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
            secretKey = new SecretKeySpec(decode, 0, decode.length, "AES");

            //String data = dataDecrypt();
            String data = "";

            if(data.equals("The quick brown fox jumped over tha lazy dog.")) {

                System.out.println("Key Verified Successfully.");
                correctKey = true;
            } else {

                System.out.println("Incorrect Key.");
                System.out.println("Enter Encryption Key: ");
                secretKey = null;
            }
        }
    }


    public String dataDecrypt(String data) {


        return null;
    }


    // CheckAuthFile looks to see if the file that we will check the key aginst exists.
    // If it does not then we should gen a new key. Then make a "authenticate.file" encypted with this new key.
    // Print out the new key for user to copy.
    private void checkAuthFile(String authFile) {

        File file = new File(authFile);
        if(!file.isFile()) {

            System.out.println("\"authenticate.file\" Does not exist.");
            System.out.println("Assuming First time start and no Encryption key has been chosen.");
            System.out.println("Would you like to Generate a key and the \"authenticate.file\"? (y,n):");

            boolean genNewKey = true;
            boolean validAnswer = false;
            while (!validAnswer) {

                Scanner myObj = new Scanner(System.in);
                String answer = myObj.nextLine();

                if(answer.equals("y")) {

                    validAnswer = true;
                } else if(answer.equals("n")) {

                    genNewKey = false;
                    validAnswer = true;
                } else {

                    System.out.println("Invalid answer. y = yes, n = no.");
                }
            }

            if(genNewKey) {

                try {
                    SecretKey newKey = KeyGenerator.getInstance("AES").generateKey();
                    String base64Newkey = Base64.getEncoder().encodeToString(newKey.getEncoded());

                    System.out.println("Generating new key.");
                    System.out.println("COPY KEY NOW AND KEEP SAFE!!! YOU WILL REQUIRE IT TO ENCRYPT AND DECRYPT FILES ON FIRST PROGRAM START. KEY:");
                    System.out.println(" ");
                    System.out.println(base64Newkey);
                    System.out.println(" ");

                    boolean newAuthFile = file.createNewFile();

                    if(newAuthFile) {

                        String verifyString = "The quick brown fox jumped over tha lazy dog.";
                        //verifyString = dataEncrypt(verifyString);
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
    }
}
