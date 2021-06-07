package Model.Net.commands;

import java.io.Serializable;
import Model.Net.ClientHandler;
public interface Command extends Serializable {

    public void handle(ClientHandler clientHandler);
}
