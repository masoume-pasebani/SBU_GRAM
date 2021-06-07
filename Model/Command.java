package Model;

import java.io.Serializable;
import Model.ClientHandler;
public interface Command extends Serializable {

    public void handle(ClientHandler clientHandler);
}
