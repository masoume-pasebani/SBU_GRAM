package Server.Net;


import Common.Model.Account;
import Common.Model.Post;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class Server{
    public static final int port=2222;
    private static boolean isServerUp = true;

    public static Map<String, Account> accountMap=null;
    public static Set<Post> postSet=null;
    public static Vector<Account> accounts=new Vector<>();

    public static void main(String[] args) {
        DataBase.getInstance().initializeServer();

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);

        } catch (IOException e) {
            System.exit(0);
        }

        while ( isServerUp() ){
            Socket currentUserSocket = null;
            try {
                currentUserSocket = serverSocket.accept();
                ClientHandler clientHandler=new ClientHandler(currentUserSocket);
                new Thread( clientHandler ).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isServerUp() {
        return isServerUp;
    }
}
