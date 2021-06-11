package Model.Net;

import Model.Account;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ClientOutputHandler implements Runnable {

    private PrintStream output;

    public ClientOutputHandler(Socket socket) throws IOException {
        output = new PrintStream(socket.getOutputStream());
    }

    @Override
    public void run() {
    }

    void sendStringToClient(String string) {
        synchronized (output) {
            output.println(string);
        }
    }
}