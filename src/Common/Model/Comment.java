package Common.Model;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    /**
     * the class of comments
     * @author Masoume Pasebani
     * @version 1.0
     * @since 2021
     */
    private String comment;
    private String publisher;
    private String commentid;
    private Date date=new Date();

    /**
     * the constructor of the class that initialize the text of the comment,the username of the publisher and commentID
     * @param comment
     * @param publisher
     * @param commentid
     */
    public Comment(String comment, String publisher, String commentid) {
        this.comment = comment;
        this.publisher = publisher;
        this.commentid = commentid;
    }

    /**
     * another constructor of the class that initialize just the username of the commenter
     * @param commenter
     */
    public Comment(String commenter) {
        this.publisher=commenter;
    }

    /**
     * the other methods are just getter and setter
     * @return
     */
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }
}
