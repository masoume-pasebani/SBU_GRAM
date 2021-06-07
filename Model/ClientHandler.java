package Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ClientHandler {
    private Server server;
    private Account user;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.objectInputStream=new ObjectInputStream(socket.getInputStream());
            this.objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.err.println("Failed to start.");
            System.exit(0);
        }
        this.server = server;
    }


    public void run(){
        boolean isconnected=true;
        while (true){
            try {
                Command order= (Command) this.objectInputStream.readObject();
                order.handle(this);
            } catch (IOException | ClassNotFoundException e) {
                isconnected=false;
                try {
                    objectOutputStream.close();
                    objectOutputStream.close();
                } catch (IOException ioException) {
                }

            }
        }
    }
    public void setUser(Account user){
        this.user=user;
    }

}
