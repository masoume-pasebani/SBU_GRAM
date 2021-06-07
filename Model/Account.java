package Model;

import Common.Help.Password;

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

    public int incrementFollowers(){
        return followers++;
    }
    public int incrementFollowing(){
        return following++;
    }
    public int decrementFollowers(){
        return followers--;
    }
    public int decrementFollowing(){
        return following--;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
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


