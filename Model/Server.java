package Model;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server implements Serializable {

    @Serial
    private static final long serialVersionUID = -4364658997972352533L;
    private int port;
    private transient ServerSocket serverSocket;
    // private transient Map<String, ClientHandler> clients = new ConcurrentHashMap<>();
    //private final RadixTree<User> usersTree = new RadixTree<>();
    private final Map<String, Account> users = new ConcurrentHashMap<>();
    private String objectFilePath;

    public Server(int port,String objectFilePath) {
        this.port=port;
        this.objectFilePath=objectFilePath;

    }
    private void startClientListener() {
    }
}
