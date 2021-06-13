package Client;

public class ClientHandler {
    private static ClientHandler outputHandler = null;

//    private final PrintStream output;
//    private final Client inputHandler;
//
//    public ClientHandler(Socket socket, Client inputHandler) throws IOException, AlreadyHaveAnOutputHandler {
//        if (outputHandler != null)
//            throw new AlreadyHaveAnOutputHandler();
//
//        output = new PrintStream(socket.getOutputStream());
//        this.inputHandler = inputHandler;
//        outputHandler = this;
//    }
//    public static ClientHandler getOutputHandler() throws NoOutPutHandler {
//        if (outputHandler == null)
//            throw new NoOutPutHandler();
//        return outputHandler;
//    }
//
//    @Override
//    public void run() { }
//    void sendStringToServer(String str){
//        output.println(str);
//    }
//    public synchronized void login(String username,String password) throws NoUserFound, PasswordIncorrect {
//        this.sendStringToServer("login " + username + " " + password);
//        String answer = inputHandler.readNextLine();
//        switch (answer){
//            case "loggedIn":
//                return;
//            case "noUserFound":
//                throw new NoUserFound();
//            case "passwordIncorrect":
//                throw new PasswordIncorrect();
//        }
//    }
//    public synchronized void signup(String name,String username,String password) throws PasswordNotLongEnoughException, PasswordInvalidCharacter, UserExists {
//        this.sendStringToServer("signup " + name + " " + username + " " + password);
//
//        switch (inputHandler.readNextLine()){
//            case "signedUp":
//                return;
//            case "passShort":
//                throw new PasswordNotLongEnoughException();
//            case "passCharsCorrect":
//                throw new PasswordInvalidCharacter();
//            case "userExists":
//                throw new UserExists();
//        }
//    }
//    public synchronized void logout() throws notLoggedIn {
//        this.sendStringToServer("logout");
//
//        String result = inputHandler.readNextLine();
//
//        switch (result){
//            case "loggedOut":
//                return;
//            case "notLoggedIn":
//                throw new notLoggedIn();
//        }
//
//    }
//    public synchronized String getMyProfile(){
//        this.sendStringToServer("getMyProfile");
//        String[] inputs = inputHandler.readNextLine().split(" ");
//
//        String result = "Name: " + inputs[0] + "\n" +
//                "Lastname: " + inputs[1] + "\n" +
//                "Followers: " + inputs[2] + "\n" +
//                "Following: " + inputs[3];
//
//        return result;
//
//    }
}
