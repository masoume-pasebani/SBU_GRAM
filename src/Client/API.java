package Client;

import Common.Command;
import Common.Model.Account;
import Common.Model.Post;
import Server.Net.Server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class API {
    /**
     * this class is the API of the client side
     * @param usernametocheck
     * @return
     */
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
        System.out.println("this account logged out.");
        return (Boolean) recieved.get("answer");
    }


    public static boolean publish_post(Post post){
        Map<String,Object> tosend =new HashMap<>();
        tosend.put("command",Command.publish_post);
        //tosend.put("username",username);
        tosend.put("post",post);
        Map<String,Object> recieved =Client.serve(tosend);
        if(recieved==null){
            return false;
        }
        return (boolean) recieved.get("answer");
    }

    public static Set<Post> get_Posts(){
        Map<String ,Object> tosend=new HashMap<>();
        tosend.put("command",Command.get_posts);
        Map<String,Object>recieved =Client.serve(tosend);
        return (Set<Post>) recieved.get("answer");


    }
//    public static ArrayList<Post> show_list_post(Account account){
//        Map<String,Object> tosend=new HashMap<>();
//        tosend.put("command",Command.show_list_posts);
//        tosend.put("username",account.getUsername());
//        tosend.put("post",account.getPosts());
//        Map<String,Object> recieved=Client.serve(tosend);
//        return (ArrayList<Post>) recieved.get("post");
//    }


    public static ArrayList<Post> allPosts(Account account){
        Map<String ,Object>tosend=new HashMap<>();
        tosend= (Map<String, Object>) get_Posts();
        tosend.put("command",Command.allPosts);
       return (ArrayList<Post>) tosend.get("post");

    }
    public static Account find_account(Account account){
        Map<String,Object>tosend=new HashMap<>();
        tosend.put("command",Command.search);
        tosend.put("username",account.getUsername());
        if(account==null)
            return null;
        return account;
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

