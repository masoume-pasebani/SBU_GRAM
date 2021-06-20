package Client;

import Common.Model.Account;

public class ClientEXE {

    public static Account profile;

    public static Account getProfile(){
        return profile;
    }

    public static void setProfile(Account profile){
        ClientEXE.profile = profile;
    }

}
