//package Server;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class Server implements Runnable {
//
//    @Override
//    public void run() {
//        ServerSocket serverSocket = null;
//        try {
//            serverSocket = new ServerSocket(9080);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        while (true) {
//            try {
//                Socket socket = serverSocket.accept();
//                ClientOutputHandler clientOutputHandler = new ClientOutputHandler(socket);
//                //ClientInputHandler clientInputHandler = new ClientInputHandler(socket,clientOutputHandler);
//                Thread outThread = new Thread(clientOutputHandler);
//                //Thread inThread = new Thread(clientInputHandler);
//                outThread.start();
//                //inThread.start();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
