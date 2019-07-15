import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost" , 6066);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(dis.readUTF());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        while(true)
        {
            dos.writeUTF(scanner.nextLine());

        }
    }
}