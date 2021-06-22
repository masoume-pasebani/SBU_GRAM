package Server.Net;

import Common.Command;
import Common.Model.Post;
import Common.Time;
import Common.Model.Account;
import Server.Net.Server;

import java.util.HashMap;
import java.util.Map;

public class API {
    public static Map<String,Object> login(Map<String,Object> income){

        String username = (String) income.get("username");
        String password = (String) income.get("password");

        Boolean isNullProfile = (Server.accountMap.get(username) == null);
        Map<String,Object> ans = new HashMap<>();
        ans.put("command", Command.login);
        ans.put("exists",!isNullProfile);
        if(isNullProfile){
            return ans;
        }
        Account profile = Server.accountMap.get(username).authenticate(username, password);
        ans.put("answer",profile);

        if(profile != null){
            System.out.println(profile.getUsername() + " login");
            System.out.println("time : "+ Time.getTime());
        }
        return ans;
    }

    public static Map<String,Object> logout(Map<String,Object> income){
        Map<String,Object> ans = new HashMap<>();
        ans.put("command",Command.logout);
        ans.put("answer",new  Boolean(true));
        return ans;
    }

    public static Map<String,Object> block(Map<String,Object>income){
        Map<String,Object>ans=new HashMap<>();
        ans.put("command",Command.block);
        return ans;
    }

    public static Map<String,Object> signUp(Map<String,Object> income){
        Account newProfile = (Account) income.get("profile");
        String username = newProfile.getUsername();
        Server.accountMap.put(username,newProfile);
        //DBManager.getInstance().updateDataBase(); // save to local file
        Map<String,Object> ans = new HashMap<>();
        ans.put("command",Command.signup);
        ans.put("answer",new Boolean(true));

        System.out.println(newProfile.getUsername() + " register" /* + TODO */); //add image address
        System.out.println("time : "+Time.getTime());
        System.out.println(newProfile.getUsername() + " signin");
        System.out.println("time : "+Time.getTime());

        return ans;
    }

    public static Map<String,Object> isUserNameExists(Map<String,Object> income){

        String usernametocheck = (String) income.get("username");
        Account profile = Server.accountMap.get(usernametocheck);
        Boolean exists = (profile != null);

        Map<String,Object> ans = new HashMap<>();
        ans.put("answer",exists);
        ans.put("command",Command.username_unique);

        return ans;
    }

    public static Map<String,Object> pass_recovery(Map<String,Object> income){
        String username=(String)income.get("username");
        String new_pass=(String) income.get("new password");
        Server.accountMap.get(username).setPassword(new_pass);
        DataBase.getInstance().updateDataBase();
        Map<String,Object> ans = new HashMap<>();
        ans.put("command",Command.pass_recovery);
        ans.put("username",username);
        ans.put("new password",new_pass);
        ans.put("answer",new Boolean(true));

        System.out.println("an account with this username "+username+"changed her/his password at "+Time.getTime());
        return ans;
    }

    public static Map<String,Object> updateProfile(Map<String,Object> income){
        Account newProfile = (Account) income.get("profile");
        String username = newProfile.getUsername();
        Server.accountMap.replace(username,newProfile);
        DataBase.getInstance().updateDataBase(); // save to local file
        Map<String,Object> ans = new HashMap<>();
        ans.put("command",Command.update_profile);
        ans.put("answer",new Boolean(true));
        return ans;
    }

    public static Map<String,Object>publish_post(Map<String,Object>income){
        Post post=(Post) income.get("post");
        String username=(String) income.get("username");
        Account account=new Account(username);
        Server.postSet.add(post);
        Server.accountMap.get(username).setPost(account.getPost()+1);
        DataBase.getInstance().updateDataBase();
        Map<String,Object>ans=new HashMap<>();
        ans.put("command",Command.publish_post);
        ans.put("username",username);
        ans.put("answer",new Boolean(true));
        System.out.println("an account with this username "+post.getWritername()+" published a post at "+Time.getTime());

        return ans;

    }


}