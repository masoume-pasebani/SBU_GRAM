//package Server;
//
//import AccountsManagar.Account;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.PrintStream;
//import java.net.Socket;
//
//public class ClientOutputHandler implements Runnable{
//
//    private PrintStream output;
//
//    public ClientOutputHandler(Socket socket) throws IOException {
//        output = new PrintStream(socket.getOutputStream());
//    }
//
//    @Override
//    public void run() { }
//
//    void sendStringToClient(String string){
//        synchronized (output) {
//            output.println(string);
//        }
//    }
//
//    public void sendRequest(Account account){
//        sendStringToClient("requestSentBy" + account.getUsername() + " " +
//                account.getNumberOfWins() + " " + account.getNumberOfLooses());
//    }
//
//    public void sendGameAccepted(){
//        sendStringToClient("gameAccepted");
//    }
//
//    public void sendGameRejected(){
//        sendStringToClient("gameRejected");
//    }
//
//    public void sendMove(int fromX,int fromY,int toX,int toY){
//        sendStringToClient(
//                "move " + fromX + " " + fromY + " " + toX + " "  + toY
//        );
//    }
//}
//
