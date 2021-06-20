package Client.Controller;

import Client.Client;
import javafx.scene.control.*;


public class Controller {


    public void showFillRequiredFieldsDialog(){
        String title = "Incomplete information";
        String contentText = "Please fill all of the required fields";
        makeAndShowInformationDialog( title, contentText );
    }


    public boolean connectionToServerCheck(){
        if ( Client.isConnected() ) return true;
        String title = "you are not connected to server";
        String contentText = "please connect to server";
        this.makeAndShowInformationDialog( title, contentText );
        return false;
    }
    public boolean isValidPassword(String pass1,String pass2){
        if ( ! pass1.equals( pass2 ) ) {
            String title = "Error in sign up";
            String contentText = "Passwords don't match";
            makeAndShowInformationDialog( title, contentText );
            return false;
        }

        char[] toCheck = pass1.toCharArray();

        boolean goodLength = toCheck.length >= 8 ; //check password length
        boolean hasDigit = false;
        boolean hasUppercase = false;
        boolean hasLowercase = false;

        for(Character c : toCheck){
            if(Character.isUpperCase(c)) hasUppercase = true;
        }
        for(Character c : toCheck){
            if(Character.isDigit(c)) hasDigit = true;
        }
        for(Character c : toCheck){
            if(Character.isLowerCase(c)) hasLowercase = true;
        }

        boolean isValid = goodLength && hasDigit && hasLowercase && hasLowercase ;
        if (! isValid ){
            String title = "invalid passwrod!";
            String contentText = "password should be strong!";
            makeAndShowInformationDialog( title, contentText );
            return false;
        }
        return isValid;
    }

    public void makeAndShowInformationDialog( String title, String contentText ) {
        Alert alert = new Alert( Alert.AlertType.INFORMATION );
        alert.setTitle( title );
        alert.setHeaderText( null );
        alert.setContentText( contentText );
        alert.showAndWait();
    }
}
