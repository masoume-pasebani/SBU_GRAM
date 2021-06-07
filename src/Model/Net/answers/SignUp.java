package Model.Net.answers;

import Model.Account;

import java.io.Serial;

public class SignUp implements Answers{

    @Serial
    private static final long serialVersionUID = 1337357768406662428L;
    public Account user;
    public boolean successful;

    public SignUp(boolean successful){
        this.successful=successful;
    }
    public SignUp(boolean successful,Account user){
        this(successful);
        this.user=user;
    }
}
