package Client;

import Common.Command;
import Common.Model.Account;
import Common.Model.Post;

import java.util.HashMap;
import java.util.List;
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
    public static Account pass_recovery(String username,String new_pass){
        Map<String,Object> tosend=new HashMap<>();
        tosend.put("command",Command.true_phonenumber);
        tosend.put("username",username);
        tosend.put("password",new_pass);
        Map<String,Object> recieved=Client.serve(tosend);
        if (recieved.get("answer")==null)return null;
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


    public static boolean publish_post(String username,Post post){
        Map<String,Object> tosend =new HashMap<>();
        tosend.put("command",Command.publish_post);
        tosend.put("username",username);
        tosend.put("new post",post);
        Map<String,Object> recieved =Client.serve(tosend);
        return (Boolean) recieved.get("answer");
    }

    public static List<Post> show_list_post(String postwritername){
        Map<String,Object> tosend=new HashMap<>();
        tosend.put("command",Command.show_list_posts);
        tosend.put("username",postwritername);
        Map<String,Object> recieved=Client.serve(tosend);
        return (List<Post>) recieved.get("answer");
    }

    public static boolean like(String username,Post post){
        Map<String,Object> tosend=new HashMap<>();
        tosend.put("command",Command.like);
        tosend.put("username",username);
        tosend.put("post",post);
        Map<String,Object> recieved=Client.serve(tosend);
        return (Boolean) recieved.get("answer");
    }

    public static boolean dislike(String username,Post post) {
       Map<String, Object> tosend = new HashMap<>();
       tosend.put("command", Command.like);
       tosend.put("username", username);
       tosend.put("post", post);
       Map<String, Object> recieved = Client.serve(tosend);
       return (Boolean) recieved.get("answer");
   }

}
