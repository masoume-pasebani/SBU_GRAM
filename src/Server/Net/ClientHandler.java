package Server.Net;

import Common.Command;
import Server.Net.API;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;


public class
ClientHandler implements Runnable {
    /**
     * the class of clienthandler in server side
     * @author Masoume Pasebani
     * @version 1.0
     * @since 2021
     */
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    public Boolean clienton=true;

    /**
     * the constructor of class that initialize socket
     * @param socket
     */
    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.ois = new ObjectInputStream(socket.getInputStream());
            this.oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void run() {

        while (clienton) {
            Map<String, Object> income = null;
            try {
                income = (Map<String, Object>) ois.readObject();
                Map<String, Object> answer = null;
                Command c = (Command) income.get("command");
                switch (c) {
                    case username_unique:
                        answer = API.isUserNameExists(income);
                        break;
                    case login:
                        answer = API.login(income);
                        break;
                    case signup:
                        answer = API.signUp(income);
                        break;
                    case logout:
                        answer = API.logout(income);
                        break;
                    case pass_recovery:
                        answer = API.update_pass(income);
                        break;
                    case update_profile:
                        answer = API.updateProfile(income);
                        break;
                    case publish_post:
                        answer = API.publish_post(income);
                        break;
                    case get_posts:
                        answer=API.get_Posts(income);
                        break;
                    case like:
                        answer=API.like(income);
                        break;
                    case dislike:
                        answer=API.dislike(income);
                        break;
                    case search:
                        answer=API.find_account(income);
                        break;


                }
                oos.writeObject(answer);
                oos.flush();

            }catch(ClassCastException | ClassNotFoundException e){
            }
            catch(EOFException e){
                break;
            }
            catch(IOException e){
                break;
            }
        }
        try {
            ois.close();
            oos.close();
            socket.close();
        } catch (IOException e) {

        }

    }
}


