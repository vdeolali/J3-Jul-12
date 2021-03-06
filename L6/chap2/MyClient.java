import java.io.*;
import java.net.*;
import java.util.*;

public class MyClient
{
    public static void main(String[] args)
    {
        Socket socket = null;
        try 
        {
            socket = new Socket("localhost", 1234);
            Scanner s = new Scanner(socket.getInputStream());
            String serverStr = "";

            while (s.hasNextLine())
            {
                serverStr = s.nextLine();
                System.out.println(serverStr);
            }
            s.close();
            socket.close();
        }
        catch (IOException e)
        {
            System.out.println("Exception: " + e.getMessage());
            System.exit(1);
        }
    }
}
