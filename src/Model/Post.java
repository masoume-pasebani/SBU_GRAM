package Model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Post implements Serializable {
    @Serial
    private static final long serialVersionUID = -369490364546270410L;
    private Account writername;
    private String title;
    private String desc;
    private Privacy privacy;
    private int likes;
    private int reposts;
    private String address;

    public Post(String title, String desc, Account writername) {
        this.title=title;
        this.desc=desc;
        this.writername = writername;
        likes=0;

    }

    public Account getWritername() {
        return writername;
    }

    public void setWritername(Account writername) {
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

    public Privacy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
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
