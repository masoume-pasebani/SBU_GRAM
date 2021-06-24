package Common.Model;

import Common.Help.Password;
import javafx.scene.image.Image;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = 161207394374102042L;
    private int followers = 0;
    private int following = 0;
    private int post=0;

    private String username;
    private String password;
    private String name;
    private String lastname;
    private String phonenumber;
    private String birth;
    private String address;
    private byte[] image;

    private ArrayList<Account> followers_list=new ArrayList<>();
    private ArrayList<Account> following_list=new ArrayList<>();
    private ArrayList<Account> blockedAccounts = new ArrayList<>();
    private ArrayList<Post> posts = new ArrayList<>();


    public Account(String username) {
        this.username = username;
    }
    public Account(String username, String password, String name, String lastname, String phonenumber, String birth,byte[] image) throws IOException {
        this.username = username;
        this.password = password;
        this.name=name;
        this.lastname=lastname;
        this.phonenumber=phonenumber;
        this.birth=birth;
        this.image=image;
        //this.address=address;
//        File f=new File(address);
//        FileInputStream fin=new FileInputStream(f);
//        image= fin.readAllBytes();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws IOException {
        this.address = address;
        File f=new File(this.address);
        FileInputStream fin=new FileInputStream(f);
        image=fin.readAllBytes();
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
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

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }


    public ArrayList<Account> getFollowing_list() {
        return following_list;
    }

    public void setFollowing_list(ArrayList<Account> following_list) {
        this.following_list = following_list;
    }

    public ArrayList<Account> getFollowers_list() {
        return followers_list;
    }

    public void setFollowers_list(ArrayList<Account> followers_list) {
        this.followers_list = followers_list;
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

    public Account authenticate(String username,String password){
        if(this.username.equals(username) && this.password.equals(password)) return this;
        return null;
    }
//    public Account authenticate1(String username,String phonenumber){
//        if(this.username.equals(username) && this.phonenumber.equals(phonenumber))return this;
//        return null;
//    }


}


