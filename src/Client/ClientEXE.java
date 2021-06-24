package Client;

import Common.Model.Account;
import Common.Model.Post;

public class ClientEXE {

    public static Account profile;
    public static Post post;

    public static Account getProfile(){
        return profile;
    }

    public static void setProfile(Account profile){
        ClientEXE.profile = profile;
    }
    public static Post getPost(){
        return post;
    }

    public static void setPost(Post post){
        ClientEXE.post=post;
    }

}
