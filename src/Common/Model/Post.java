package Common.Model;

import Common.Time;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Post implements Serializable {
    @Serial
    private static final long serialVersionUID = -369490364546270410L;
    private String writername;
    private String title;
    private String desc;
    private int likes;
    private int reposts;
    private String address;
    private ArrayList<Account> likes_list=new ArrayList<>();
    private ArrayList<String> likers=new ArrayList<>();
    private ArrayList<Comment>comments=new ArrayList<>();
    private ArrayList<String> commenters=new ArrayList<String>();
    private Long createdTime;
    private String timeString;
    private Comment comment;
    byte[] image;
    private Account publisher;
    public Post() {
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Post(String title, String desc, String writername, String address) throws IOException {
        this.title = title;
        this.desc = desc;
        this.writername = writername;
        this.address=address;
        likes = 0;
        createdTime = Time.getMilli();
        timeString = Time.getTime();
        File f=new File(address);
        FileInputStream fin=new FileInputStream(f);
        image=fin.readAllBytes();
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWritername() {
        return writername;
    }

    public void setWritername(String writername) {
        this.writername = writername;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setReposts(int reposts) {
        this.reposts = reposts;
    }
    public int getReposts() {
        return reposts;
    }
    public void increment_likes(){
        this.likes++;
    }
    public void decrement_likes(){
        this.likes--;
    }

    public void comment(String commenter){
        Comment c = new Comment(commenter);
        commenters.add(commenter);
        comments.add(c);
    }
    public void like(String liker){
        Account a=new Account(liker);
        likes_list.add(a);
        likers.add(liker);
    }

    public ArrayList<Account> getLikes_list() {
        return likes_list;
    }

    public void setLikes_list(ArrayList<Account> likes_list) {
        this.likes_list = likes_list;
    }

    public ArrayList<String> getLikers() {
        return likers;
    }

    public void setLikers(ArrayList<String> likers) {
        this.likers = likers;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<String> getCommenters() {
        return commenters;
    }

    public void setCommenters(ArrayList<String> commenters) {
        this.commenters = commenters;
    }

    public Account getPublisher() {
        return publisher;
    }

    public void setPublisher(Account publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) && Objects.equals(createdTime, post.createdTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, createdTime);
    }

    @Override
    public String toString() {
        return title;
    }

    public String getTimeString() {
        return timeString;
    }
    public long getTimeLong() {
        return createdTime;
    }
}
