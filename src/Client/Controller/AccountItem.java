package Client.Controller;

import Common.Model.Account;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class AccountItem extends ListCell<Account> {

    @Override
    public void updateItem(Account account, boolean empty) {
        super.updateItem(account, empty);
        if (account != null) {
            try {
                setGraphic(new Account_controller(account).init());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}