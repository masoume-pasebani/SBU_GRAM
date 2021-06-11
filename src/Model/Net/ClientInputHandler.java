package Model.Net;

import Model.Account;
import Model.DB.DataBase;
import Model.Exeptions.*;

import java.net.Socket;
import java.util.Scanner;

public class ClientInputHandler implements Runnable {
    private Socket socket;
    private Scanner input;
    private Account account;
    private ClientOutputHandler clientOutputHandler;

    public ClientInputHandler(Socket socket, ClientOutputHandler clientOutputHandler) {
        try {
            this.socket = socket;
            input = new Scanner(socket.getInputStream());
            this.clientOutputHandler = clientOutputHandler;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String command;
        while (true) {
            try {

                command = input.next();
                if (command.equals("Exit")) {
                    System.out.println("Client " + this.socket + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.socket.close();
                    System.out.println("Connection closed");
                    break;
                }
                switch (command) {
                    case "login":
                        login();
                        break;
                    case "signup":
                        signup();
                        break;
                    case "changePassword":
                        changePassword();
                        break;
                    case "logout":
                        logout();
                        break;
                    case "block":
                        block();
                        break;


                }

            }catch (Exception ex){
                DataBase.removeAccountFromOnlineAccounts(account);
            }
        }
    }

    private void login() {
        String username, password;
        username = input.next();
        password = input.next();

        try {
            Account account = DataBase.getAccount(username, password);
            this.account = account;
            //DataBase.addOnlineAccount(account);
            account.setClientInputHandler(this);
            account.setClientOutputHandler(clientOutputHandler);
            clientOutputHandler.sendStringToClient("loggedIn");
        } catch (UserDoesntExistException e) {
            clientOutputHandler.sendStringToClient("noUserFound");
        } catch (PasswordsDoNotMatchException e) {
            clientOutputHandler.sendStringToClient("passwordIncorrect");
        }
    }
    private void changePassword() {
        String currentPass, newPass;
        currentPass = input.next();
        newPass = input.next();
        try {
            account.changePassword(currentPass,newPass);
            clientOutputHandler.sendStringToClient("passChanged");
        } catch (PasswordsDoNotMatchException e) {
            clientOutputHandler.sendStringToClient("passwordNotCorrect");
        }
    }
    private void signup() {
        String name, username, password,lastname,phonenumber,birth;
        username = input.next();
        password = input.next();
        name = input.next();
       lastname=input.next();
       phonenumber=input.next();
       birth=input.next();
        Account account = new Account(username, password,name,lastname,phonenumber,birth);
        DataBase.addAccount(account);
        clientOutputHandler.sendStringToClient("signedUp");

    }
    private void block() {
        String accountUsername = input.next();
        try {
            account.blockAccount(
                    DataBase.getAccountForOtherUses(accountUsername)
            );
            clientOutputHandler.sendStringToClient("blocked");
        } catch (NullPointerException e){
            clientOutputHandler.sendStringToClient("noAccountWithThisUsername");
        }

    }
    private void logout() {
        if (account == null) {
            clientOutputHandler.sendStringToClient("notLoggedIn");
            return;
        }

        DataBase.removeAccountFromOnlineAccounts(account);
        account.userLoggedOut();
        account = null;
        clientOutputHandler.sendStringToClient("loggedOut");

    }
}


