package Client;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map;

public class Client {
    public static String serverAddress="localhost";
    public static final int port=2222;
    public static boolean isconnected=false;
    public static Socket socket;
    public static ObjectInputStream ois;
    public static ObjectOutputStream oos;


    public static boolean isConnected(){
        return isconnected;
    }


    public static Boolean connectToServer(){
        if(socket != null) return false;
        try{
            System.out.println("server ip : " + serverAddress);
            socket = new Socket( serverAddress, port);
            oos = new ObjectOutputStream( socket.getOutputStream() );
            ois = new ObjectInputStream( socket.getInputStream() );
            isconnected = true;
            return true;

        }catch (ConnectException e){
        }
        catch (IOException e) {
        }
        return false;
    }

    public static Boolean disconnectFromServer(){
        try{
            ois.close();
            oos.close();
            socket.close();
            isconnected = false;

            socket = null;
            ois = null;
            oos = null;

            return true;
        }
        catch (SocketException | NullPointerException e ){
        }
        catch( Exception e){
            e.printStackTrace();
        }
        socket = null;
        ois = null;
        oos = null;
        return false;
    }
    @SuppressWarnings("unchecked")
    public static Map<String,Object> serve(Map<String,Object> toSend){
        Map<String,Object> recieved = null;
        try{
            oos.writeObject(toSend);
            oos.flush();
            oos.reset();
            recieved = (Map<String,Object>) ois.readObject();
            return recieved;

        } catch (ClassNotFoundException e){
        } catch( IOException e){
            e.printStackTrace();
        }
        return recieved;
    }


}
