import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket= new ServerSocket(12345);
            Socket socket=serverSocket.accept();
            System.out.println("A client is added");

            //asking the input from user
            BufferedReader userinput= new BufferedReader(new InputStreamReader(System.in));

            //taking the input from socket
            BufferedReader socketInput= new BufferedReader(new InputStreamReader((socket.getInputStream())));

            //to send the message i need a pen
            OutputStream outputStream=socket.getOutputStream();

            PrintWriter out=new PrintWriter(outputStream);


            String sendingMessage,receiveMessage;

            while (true){
                sendingMessage=userinput.readLine();
                out.println(sendingMessage);
                out.flush();
                receiveMessage=socketInput.readLine();
                System.out.println("Message from client" + receiveMessage);

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
