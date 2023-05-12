import java.io.*;
import java.net.Socket;

public class Client3 {
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("localhost",12345);

            //asking user input with buffer
            BufferedReader userInputBuffer=new BufferedReader(new InputStreamReader(System.in));


            //taking data from socket buffer
            BufferedReader socketbuffer=new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //to send the message i need a pen
            OutputStream outputStream=socket.getOutputStream();

            PrintWriter out=new PrintWriter(outputStream);

            String sendingMessage,receiveMessage;

            while (true){

                receiveMessage=socketbuffer.readLine();
                System.out.println("Message from client" + receiveMessage);

                sendingMessage=userInputBuffer.readLine();
                out.println(sendingMessage);
                out.flush();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
