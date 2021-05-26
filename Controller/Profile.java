package Controller;

import javax.swing.text.html.ImageView;

public class Profile {
    private final String username;
    private String password;
    private String name;
    private String lastname;
    private String birthYear;
    private String phoneNumber;
    private ImageView profileimage;

    public Profile(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }


    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLastname() {
        return lastname;
    }


    public void setBirthYear(String birthYear){
        this.birthYear=birthYear;
    }
    public int getBirthYear(){
        return Integer.parseInt(birthYear);
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setProfileimage(ImageView profileimage){
        this.profileimage=profileimage;
    }
    public Profile check(String username,String password){
        if(this.username.equals(username) && this.password.equals(password)) return this;
        return null;
    }


}
