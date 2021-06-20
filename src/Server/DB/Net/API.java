package Server.DB.Net;

import Common.Command;
import Common.Time;
import Common.Model.Account;

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
            System.out.println(profile.getUsername() + " signin");
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
}