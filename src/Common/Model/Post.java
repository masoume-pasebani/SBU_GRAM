package Common.Model;

import java.io.Serial;
import java.io.Serializable;
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
    private ArrayList<Comment>comments=new ArrayList<>();
    private ArrayList<Account> commenters=new ArrayList<>();

    public Post() {
    }

    public Post(String title, String desc, String writername) {
        this.title=title;
        this.desc=desc;
        this.writername = writername;
        likes=0;

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


    public void comment(Account commenter){
        Comment c = new Comment(commenter);
        commenters.add(commenter);
        comments.add(c);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return title;
    }
}
