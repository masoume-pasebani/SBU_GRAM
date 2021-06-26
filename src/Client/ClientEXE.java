package Client;

import Common.Model.Account;
import Common.Model.Post;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class ClientEXE {

    public static Account profile;
    public static ArrayList<Post> publisehd= new ArrayList<Post>();
    public static Post post=null;
    public static Post newpost;

    public static Account getProfile(){
        return profile;
    }

    public static void setProfile(Account profile){
        ClientEXE.profile = profile;
    }


    public static Post getNewpost() {
        return newpost;
    }

    public static void setNewpost(Post newpost) {
        ClientEXE.newpost = newpost;
    }
}
