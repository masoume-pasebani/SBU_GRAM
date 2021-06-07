package Model;

public class Message {

    private Account sender;
    private String message;

    public Message(Account sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public Account getSender() {
        return this.sender;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.sender.getUsername() + ": " + this.message;
    }

}
