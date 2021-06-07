package Model.Net.commands;

import Model.Net.ClientHandler;

import java.io.Serial;

public class SignupCommand implements Command{

    @Serial
    private static final long serialVersionUID = 6626279622229087392L;
    private String username;
    private String password;

    public SignupCommand(String username,String password) {
        this.username = username;
        this.password=password;
    }

    @Override
    public void handle(ClientHandler clientHandler){

    }
}
