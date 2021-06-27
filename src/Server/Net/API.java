package Server.Net;

import Common.Command;
import Common.Model.Post;
import Common.Time;
import Common.Model.Account;
import Server.Net.Server;
import javafx.geometry.Pos;

import java.util.*;
import java.util.stream.Collectors;

public class API {
    /**
     * the class of API in sever side
     * @author Masoume Pasebani
     * @version 1.0
     * @since 2021
     */


    public static Map<String, Object> login(Map<String, Object> income) {

        String username = (String) income.get("username");
        String password = (String) income.get("password");

        Boolean isNullProfile = (Server.accountMap.get(username) == null);
        Map<String, Object> ans = new HashMap<>();
        ans.put("command", Command.login);
        ans.put("exists", !isNullProfile);
        if (isNullProfile) {
            return ans;
        }

        Account profile = Server.accountMap.get(username).authenticate(username, password);
        ans.put("answer", profile);

        if (profile != null) {
            System.out.println(profile.getUsername() + " login");
            System.out.println("time : " + Time.getTime());
        }
        return ans;
    }

    public static Map<String, Object> logout(Map<String, Object> income) {
        Map<String, Object> ans = new HashMap<>();
        ans.put("command", Command.logout);
        ans.put("answer", new Boolean(true));
        return ans;
    }

    public static Map<String, Object> block(Map<String, Object> income) {
        Map<String, Object> ans = new HashMap<>();
        ans.put("command", Command.block);
        return ans;
    }

    public static Map<String, Object> signUp(Map<String, Object> income) {
        Account newProfile = (Account) income.get("profile");
        String username = newProfile.getUsername();
        Server.accountMap.put(username, newProfile);
        //DBManager.getInstance().updateDataBase(); // save to local file
        Map<String, Object> ans = new HashMap<>();
        ans.put("command", Command.signup);
        ans.put("answer", new Boolean(true));

        System.out.println(newProfile.getUsername() + " register" /* + TODO */); //add image address
        System.out.println("time : " + Time.getTime());
        System.out.println(newProfile.getUsername() + " signin");
        System.out.println("time : " + Time.getTime());

        return ans;
    }

    public static Map<String, Object> isUserNameExists(Map<String, Object> income) {

        String usernametocheck = (String) income.get("username");
        Account profile = Server.accountMap.get(usernametocheck);
        Boolean exists = (profile != null);

        Map<String, Object> ans = new HashMap<>();
        ans.put("answer", exists);
        ans.put("command", Command.username_unique);

        return ans;
    }

    //    public static Map<String,Object> pass_recovery(Map<String,Object> income){
//
//        String username = (String) income.get("username");
//        String phonenumber = (String) income.get("phonenumber");
//
//        Boolean isNullProfile = (Server.accountMap.get(username) == null);
//        Map<String,Object> ans = new HashMap<>();
//        ans.put("command", Command.login);
//        ans.put("exists",!isNullProfile);
//        if(isNullProfile){
//            return ans;
//        }
//         Account profile= Server.accountMap.get(username).authenticate1(username, phonenumber);
//        ans.put("answer",profile);
//
//        if(profile != null){
//            System.out.println(profile.getUsername() + " wants to change password at "+ Time.getTime());
//        }
//        return ans;
//    }
    public static Map<String, Object> update_pass(Map<String, Object> income) {
        String username = (String) income.get("username");
        String new_pass = (String) income.get("new password");
        Server.accountMap.get(username).setPassword(new_pass);
        DataBase.getInstance().updateDataBase();
        Map<String, Object> ans = new HashMap<>();
        ans.put("command", Command.pass_recovery);
        ans.put("username", username);
        ans.put("new password", new_pass);
        ans.put("answer", new Boolean(true));

        System.out.println("an account with this username<<" + username + ">>changed her/his password at " + Time.getTime());
        return ans;
    }

    public static Map<String, Object> updateProfile(Map<String, Object> income) {
        Account newProfile = (Account) income.get("profile");
        String username = newProfile.getUsername();
        Server.accountMap.replace(username, newProfile);
        DataBase.getInstance().updateDataBase(); // save to local file
        Map<String, Object> ans = new HashMap<>();
        ans.put("command", Command.update_profile);
        ans.put("answer", new Boolean(true));
        System.out.println("an account with this username<<" + username + ">>edited her/his information at " + Time.getTime());
        return ans;
    }

    public static Map<String, Object> publish_post(Map<String, Object> income) {
        try {

            Map<String, Object> ans = new HashMap<>();
            Post post = (Post) income.get("post");
            //Server.postSet.add(post);
            DataBase.getInstance().updateDataBase();
            ans.put("command", Command.publish_post);
            ans.put("answer", new Boolean(true));
            System.out.println("an account published a post at " + Time.getTime());

            return ans;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return null;

    }

    public static Map<String,Object> get_Posts(Map<String,Object>income){
        Map<String,Object> ans=new HashMap<>();
        ans.put("command",Command.get_posts);
        ans.put("answer",Server.postSet);
//        Set<Post>postArrayList=new HashSet<>(Server.postSet);
//        ans.put("post",postArrayList);
        return ans;

    }
//    public static Map<String, Object> show_list_post(Map<String, Object> income) {
//        Account account = Server.accountMap
//                .get(String.valueOf(income.get("username")).trim());
//        ArrayList<Post> posts=account.getPosts();
//        Map<String, Object> ans = new HashMap<>();
//        ans.put("command", Command.show_list_posts);
//        posts = (ArrayList<Post>) Server.postSet.stream()
//                .sorted((x,y)->-1*(Long.compare(x.getTimeLong(),y.getTimeLong()))).collect(Collectors.toList());
//        ans.put("postlist", posts);
//        ans.put("answer", new Boolean(true));
//        DataBase.getInstance().updateDataBase();
//        return ans;
//    }

    public static Map<String, Object> like(Map<String, Object> income) {
        Post post = (Post) income.get("post");
        String postwriter = (String) income.get("postwriter");
        String username = (String) income.get("username");
        post.increment_likes();
        Map<String, Object> ans = new HashMap<>();
        ans.put("username", username);
        ans.put("postwriter", postwriter);
        ans.put("post", post);
        ans.put("answer", new Boolean(true));
        System.out.println("an account with this username <<" + username + ">> liked a post of a this username <<" + postwriter + ">> at " + Time.getTime());
        return ans;
    }

    public static Map<String, Object> dislike(Map<String, Object> income) {
        Post post = (Post) income.get("post");
        String postwriter = (String) income.get("postwriter");
        String username = (String) income.get("username");
        post.decrement_likes();
        Map<String, Object> ans = new HashMap<>();
        ans.put("username", username);
        ans.put("postwriter", postwriter);
        ans.put("post", post);
        ans.put("answer", new Boolean(true));
        System.out.println("an account with this username <<" + username + ">> disliked a post of a this username <<" + postwriter + ">> at " + Time.getTime());
        return ans;
    }

    public static Map<String,Object> find_account(Map<String,Object>income){
        Account account=Server.accountMap.get(String.valueOf(income.get("username")).trim());
        ArrayList<Account> accounts=new ArrayList<>();
        accounts.add(account);
        Map<String,Object>ans=new HashMap<>();
        ans.put("command",Command.search);
        ans.put("username",account.getUsername());
        ans.put("answer",new Boolean(true));
        System.out.println("someone searched for <<"+account.getUsername()+">> at "+Time.getTime());
        return ans;
    }

}




