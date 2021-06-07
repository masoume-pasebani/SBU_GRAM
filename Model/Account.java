package Model;

import Common.Help.Password;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Account implements Serializable {
    private int followers = 0;
    private int following = 0;

    private final String username;
    private String password;
    private String name;
    private String lastname;
    private String phonenumber;
    private String birth;

//    private ClientOutputHandler clientOutputHandler;
//    private ClientInputHandler clientInputHandler;
    private ArrayList<Account> blockedAccounts = new ArrayList<>();

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(Password.generateHash(password));
    }

//    public void changePassword(String currentPassword, String newPassword) {
//        if (!checkPassword(currentPassword))
//            throw new PasswordsDoNotMatchException();
//
//        this.password = Password.generateHash(newPassword);
//    }

    public void changeName(String name){
        this.name=name;
    }
    public void changeLastname(String lastname){
        this.lastname=lastname;
    }
    public void changePhoneNumber(String phonenumber){
        this.phonenumber=phonenumber;
    }
    public void changeBirthYear(String birth){
        this.birth=birth;
    }
    public int incrementFollwers(){
        return followers++;
    }
    public int incrementFollowing(){
        return following++;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

//    public ClientOutputHandler getClientOutputHandler() {
//        return clientOutputHandler;
//    }
//
//    public void setClientOutputHandler(ClientOutputHandler clientOutputHandler) {
//        this.clientOutputHandler = clientOutputHandler;
//    }
//
//    public ClientInputHandler getClientInputHandler() {
//        return clientInputHandler;
//    }
//
//    public void setClientInputHandler(ClientInputHandler clientInputHandler) {
//        this.clientInputHandler = clientInputHandler;
//    }

//    public void userLoggedOut(){
//        clientInputHandler = null;
//        clientOutputHandler = null;
//        currentOpponentOrRequestedAccount = null;
//    }
    //    public class PasswordNotLongEnoughException extends Exception {
//    }
//    public class PasswordShouldntContainNonDigitsOrLatinLettersException extends Throwable {
//    }

    public void blockAccount(Account account){
        Objects.requireNonNull(account);
        blockedAccounts.add(account);
    }

    public boolean isBlocked(Account account){
        Objects.requireNonNull(account);
        return blockedAccounts.contains(account);
    }

}


