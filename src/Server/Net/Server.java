package Server.Net;


import Client.Controller.Signup_Controller;
import Common.Model.Account;
import Common.Model.Post;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server{
    /**
     * the main class of server side
     * @author Roozbe Sharifnasab
     * @version ?
     * @since 2019
     */
    public static final int port=2222;
    public static Vector<Account> accounts=new Vector<>();
    private static boolean isServerUp = true;
    static Post p1=new Post();
    public static Map<String, Account> accountMap=null;
    public static Set<Post> postSet=new HashSet<>();

    public static void main(String[] args) {

        DataBase.getInstance().initializeServer();

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);

        } catch (IOException e) {
            System.exit(1);
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
