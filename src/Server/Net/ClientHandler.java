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
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    public Boolean clienton=true;


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
//                    case show_list_posts:
//                        answer=API.show_list_post(income);
//                      break;
                    case like:
                        answer=API.like(income);
                        break;
                    case dislike:
                        answer=API.dislike(income);
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


