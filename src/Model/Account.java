package Model;

import Common.Help.Password;
import Model.Exeptions.PasswordsDoNotMatchException;
import Model.Net.ClientInputHandler;
import Model.Net.ClientOutputHandler;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = 161207394374102042L;
    private int followers = 0;
    private int following = 0;

    private String username;
    private String password;
    private String name;
    private String lastname;
    private String phonenumber;
    private String birth;

    private ArrayList<Account> followers_list=new ArrayList<>();
    private ArrayList<Account> following_list=new ArrayList<>();
    private ArrayList<Account> blockedAccounts = new ArrayList<>();
    private ClientOutputHandler clientOutputHandler;
    private ClientInputHandler clientInputHandler;
    public Account(String username, String password,String name,String lastname,String phonenumber,String birth) {
        this.username = username;
        this.password = password;
        this.name=name;
        this.lastname=lastname;
        this.phonenumber=phonenumber;
        this.birth=birth;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean checkPassword(String passwordHash) {
        return this.password.equals(Password.generateHash(passwordHash));
    }

    public void incrementFollowers(){
        this.followers++;
    }
    public void incrementFollowing(){
        this.following++;
    }
    public void decrementFollowers(){
        this.followers--;
    }
    public void decrementFollowing(){
        this.following--;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }
    public void changePassword(String currentPassword,String newPassword) throws PasswordsDoNotMatchException {
        if (!checkPassword(currentPassword))
            throw new PasswordsDoNotMatchException();

        this.password = Password.generateHash(newPassword);
    }
    public ClientOutputHandler getClientOutputHandler() {
        return clientOutputHandler;
    }

    public void setClientOutputHandler(ClientOutputHandler clientOutputHandler) {
        this.clientOutputHandler = clientOutputHandler;
    }

    public ClientInputHandler getClientInputHandler() {
        return clientInputHandler;
    }

    public void setClientInputHandler(ClientInputHandler clientInputHandler) {
        this.clientInputHandler = clientInputHandler;
    }
    public void userLoggedOut(){
        clientInputHandler = null;
        clientOutputHandler = null;

    }
    public class PasswordNotLongEnoughException extends Exception {
    }

    public class PasswordShouldntContainNonDigitsOrLatinLettersException extends Throwable {
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Account)) {
            return false;
        }
        return ((Account) o).getUsername().equals(this.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    public void blockAccount(Account account){
        Objects.requireNonNull(account);
        blockedAccounts.add(account);
    }

    public boolean isBlocked(Account account){
        Objects.requireNonNull(account);
        return blockedAccounts.contains(account);
    }



}


