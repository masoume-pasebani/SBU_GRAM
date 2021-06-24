package Client.Controller;

import Common.Model.PageLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Comment_Controller {
    AnchorPane root;
    Comment comment;

    public Comment_Controller(Comment comment) throws IOException {
        new PageLoader().load("comment",this);
        this.comment=comment;
    }

    public AnchorPane init(){

        return root;
    }
}
