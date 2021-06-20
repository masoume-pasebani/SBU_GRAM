package Client.Controller;

import Common.Model.Post;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class PostItem extends ListCell<Post> {

    @Override
    public void updateItem(Post post, boolean empty) {
        super.updateItem(post, empty);
        if (post != null) {
            try {
                setGraphic(new Postitem_Controller(post).init());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
