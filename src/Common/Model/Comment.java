package Common.Model;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private String comment;
    private Account publisher;
    private String commentid;
    private Date date=new Date();


    public Comment(String comment, Account publisher, String commentid) {
        this.comment = comment;
        this.publisher = publisher;
        this.commentid = commentid;
    }

    public Comment(Account commenter) {
        this.publisher=commenter;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Account getPublisher() {
        return publisher;
    }

    public void setPublisher(Account publisher) {
        this.publisher = publisher;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }
}
