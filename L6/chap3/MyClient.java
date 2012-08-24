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

            // Scanner to read server's questions
            Scanner questionScanner = new Scanner(socket.getInputStream());

            // Scanner to read client's responses
            Scanner answerScanner = new Scanner(System.in);

            // PrintWriter to write client's responses for the server to read
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String questionStr = "", answerStr = "";

            while (questionScanner.hasNextLine())
            {
                // Read question from server:
                questionStr = questionScanner.nextLine();
                System.out.println(questionStr);

                // Get response from client:
                answerStr = answerScanner.nextLine();

                // Send response to socket, for server to pick up:
                out.println(answerStr);
            }
            questionScanner.close();
            answerScanner.close();
            socket.close();
        }
        catch (IOException e)
        {
            System.out.println("Exception: " + e.getMessage());
            System.exit(1);
        }
    }
}