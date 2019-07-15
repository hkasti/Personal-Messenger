import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6066);


        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            Socket s = server.accept();
            new Thread(new Chat(s)).start();

        }
    }
}

class Chat implements Runnable{
    Socket s;
    DataInputStream dis;
    DataOutputStream dos;
    public Chat(Socket s) throws IOException{
        this.s = s;
        dis = new DataInputStream(s.getInputStream());
        dos = new DataOutputStream(s.getOutputStream());

    }

    @Override
    public void run() {
        while(true)
        {
            try {
                System.out.println(dis.readUTF());
                dos.writeUTF("salam");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

