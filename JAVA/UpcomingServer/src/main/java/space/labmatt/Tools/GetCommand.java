package space.labmatt.Tools;

import java.util.ArrayList;
import java.util.List;

public class GetCommand {

     /*
    Example json command and message:
    A whole string has to be longer than 30 chars in order to have this data in it.

    {
    "command": "newInput",
    "message": {...more jason data...}
    }

     */

    public List<String> errors = new ArrayList<>();
    public String message = "";
    public String command = "";
    private int commerLocation = 0;


    public GetCommand(String message) {

        /*
        Break Down String into command and message:
        - Receive Json string
        - Check the that the json format is valid by locating chars and substrings.
        - Locate the , between command and message. Use this to verify message start and end.

         */

        if(message.length() < 30) {

            errors.add("String is to short to contain command and message.");
            return;
        }

        // Makes sure first and last chars are { or }
        if ((message.charAt(0) != '{') || (message.charAt(message.length() -1) != '}')) {

            errors.add("Json syntax error. Missing { or } .");
            return;
        }

        // Make sure command is set up
        if(!message.substring(1,12).equalsIgnoreCase("\"command\": ")) {

            errors.add("Json syntax error. Missing command.");
            return;
        }

        String removeKeysToCheck = message.replace("\"command\":", "").replace("\"message\":", "");

        if (message.length() - removeKeysToCheck.length() > 20) {

            errors.add("Multiple Instances of command and message tag.");
            return;
        }


        // Get the message of the command
        this.command = getCommandSubString(message);

        if(this.command.isEmpty() || commerLocation == 0) {

            return;
        }

        // Get the message
        this.message = getMessageSubString(message);
    }


    private String getCommandSubString(String message) {
        // Get the command message from the substring.

        if(message.charAt(12) != '\"') {

            errors.add("Json syntax error. Missing command quote.");
            return "";
        }


        // Get the location of the comer between the command and message stage.
        // if the comer did not exist then return.
        int commerPostion = 12;
        while(commerPostion != message.length()) {

            if(message.charAt(commerPostion) == ',' && message.charAt(commerPostion -1) == '\"') {

                break;
            }
            commerPostion++;
        }

        if (commerPostion == message.length() || commerPostion < 12) {

            errors.add("Json syntax error. Missing opening , between command and message.");
            return "";
        }


        // Make sure the commer does not have any illigle " before the start of command char(13)
        int testValid = commerPostion - 2;
        boolean valid = true;
        while(testValid > 13) {

            if(message.charAt(testValid) == '\"') {

                System.out.println("FaileValid pos: " + testValid + " char: " + message.charAt(testValid));
                valid = false;
            }

            testValid--;
        }

        if(!valid) {

            errors.add("Json syntax error. illigle Chars in command filed.");
            return "";
        }


        // make sure the following part is the message.
        // return the substring witch should be the commaned.
        if(!message.substring(commerPostion + 2, commerPostion+12).equalsIgnoreCase("\"message\":")) {

            errors.add("Json syntax error. Missing message filed.");
            return "";
        } else {

            commerLocation = commerPostion;
            return message.substring(13, commerPostion-1);
        }
    }


    private String getMessageSubString(String message) {
        // Using the end and the commer position from the last function. get the contenets of the message.

        System.out.println(message.charAt(message.length()-2));
        if(message.charAt(message.length()-2) != '\"') {

            errors.add("Syntax error. Unable to find message end.");
            return "";
        }

        if(message.charAt(commerLocation+13) != '\"') {

            errors.add("Syntax error. Unable to find message start \".");
            return "";
        }

        return message.substring(commerLocation+14, message.length()-2);
    }
}
