package space.labmatt.Tools;

import java.util.ArrayList;
import java.util.List;

public class GetCommand {

    // These allow you to get the command and message from this object after its been passed into the constructor;
    public List<String> errors = new ArrayList<>();
    public String message = "";
    public String command = "";

    // Example json command and message:
    // A whole string has to be longer than 30 chars in order to have this data in it.
    /*

    {
    "command": "newInput",
    "message": {...more jason data...}
    }

     */


    // When fed the json message.
    // Check its json format.
    // CHeck if it has a valid first command.
    // Grab that command
    // then set the clipped message as leftoveres.
    public GetCommand(String message) {

        // Check if length is valid.
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
    }


    // Get the command message from the substring.
    private String getCommandSubString(String message) {

        // check for the opening qoute mark.
        if(message.charAt(12) != '\"') {

            errors.add("Json syntax error. Missing command qoute.");
            return "";
        }


        // Get the location of the commer between the command and message stage.
        // if the commer did not exist then return.
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

            return message.substring(13, commerPostion-1);
        }
    }
}
