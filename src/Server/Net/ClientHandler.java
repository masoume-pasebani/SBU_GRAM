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
    public void run() {
        String command;
        while (true) {
            Map<String, Object> incom = null;
            try {
                incom = (Map<String, Object>) ois.readObject();
                Map<String, Object> answer = null;
                Command c = (Command) incom.get("command");
                switch (c) {
                    case login:
                        API.login(incom);
                        break;
                    case signup:
                        API.signUp(incom);
                        break;
                    case logout:
                        API.logout(incom);
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


//    private void login() {
//        String username, password;
//        username = input.next();
//        password = input.next();
//
//        try {
//            Account account = DataBase.getAccount(username, password);
//            this.account = account;
//            //DataBase.addOnlineAccount(account);
//            account.setClientInputHandler(this);
//            account.setClientOutputHandler(clientOutputHandler);
//            clientOutputHandler.sendStringToClient("loggedIn");
//        } catch (UserDoesntExistException e) {
//            clientOutputHandler.sendStringToClient("noUserFound");
//        } catch (PasswordsDoNotMatchException e) {
//            clientOutputHandler.sendStringToClient("passwordIncorrect");
//        }
//    }
//    private void changePassword() {
//        String currentPass, newPass;
//        currentPass = input.next();
//        newPass = input.next();
//        try {
//            account.changePassword(currentPass,newPass);
//            clientOutputHandler.sendStringToClient("passChanged");
//        } catch (PasswordsDoNotMatchException e) {
//            clientOutputHandler.sendStringToClient("passwordNotCorrect");
//        }
//    }

//    private void block() {
//        String accountUsername = input.next();
//        try {
//
//            account.blockAccount(
//                    DataBase.getAccountForOtherUses(accountUsername)
//            );
//            clientOutputHandler.sendStringToClient("blocked");
//        } catch (NullPointerException e){
//            clientOutputHandler.sendStringToClient("noAccountWithThisUsername");
//        }
//
//    }
//    private void logout() {
//        if (account == null) {
//            clientOutputHandler.sendStringToClient("notLoggedIn");
//            return;
//        }
//
//        DataBase.removeAccountFromOnlineAccounts(account);
//        account.userLoggedOut();
//        account = null;
//        clientOutputHandler.sendStringToClient("loggedOut");
//
//    }
}


