package Model.Net.answers;

import Model.Account;

import java.io.Serial;

public class Login implements Answers{
    @Serial
    private static final long serialVersionUID = 1337357768406662428L;
    public Account user;
    public boolean successful;

    public Login(boolean successful){
        this.successful=successful;
    }
    public Login(boolean successful,Account user){
        this(successful);
        this.user=user;
    }
}
