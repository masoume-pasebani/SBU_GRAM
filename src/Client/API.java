package Client;

import Common.Command;
import Common.Model.Account;

import java.util.HashMap;
import java.util.Map;

public class API {

    public static boolean IsUserNameExists(String usernametocheck){
        Map<String,Object> toSend = new HashMap<>();
        toSend.put("command", Command.username_unique);
        toSend.put("username",usernametocheck);
        Map<String,Object> recieved = Client.serve(toSend);
        return (boolean) recieved.get("answer");
    }

    public static Account login(String username, String password){
        Map<String,Object> toSend = new HashMap<>();
        toSend.put("command", Command.login);
        toSend.put("username",username);
        toSend.put("password",password);
        Map<String,Object> recieved = Client.serve(toSend);
        if ( recieved.get("answer") == null ) return null;
        return (Account) recieved.get("answer");
    }

    public static Boolean signUp(Account profile){
        Map<String,Object> toSend = new HashMap<>();
        toSend.put("command", Command.signup);
        toSend.put("profile", profile);
        Map<String,Object> recieved = Client.serve(toSend);
        if ( recieved.get("answer") == null ) return null;
        return (Boolean) recieved.get("answer");
    }

    public static Boolean updateProfile(Account profile){
        Map<String,Object> toSend = new HashMap<>();
        toSend.put("command", Command.update_profile);
        toSend.put("profile", profile);
        Map<String,Object> recieved = Client.serve(toSend);
        if ( recieved.get("answer") == null ) return false;
        return (Boolean) recieved.get("answer");
    }

    public static Boolean logout(){
        Map<String,Object> toSend = new HashMap<>();
        toSend.put("command", Command.logout);
        Map<String,Object> recieved = Client.serve(toSend);
        if ( recieved.get("answer") == null ) return false;
        return (Boolean) recieved.get("answer");
    }

    public static Boolean pass_recovery(){
        Map<String,Object> toSend = new HashMap<>();
        toSend.put("command",Command.pass_recovery);
        Map<String, Object> recieved=Client.serve(toSend);
        return (boolean)recieved.get("answer");
    }

}
