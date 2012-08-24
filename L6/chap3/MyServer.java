import java.io.*;
import java.net.*;
import java.util.*;

class MyServer
{
    public static void main(String[] args)
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Waiting for client to connect...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            // Create a stream to write to the client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Scanner to read questions from a text file
            Scanner questionScanner = new Scanner(new File("questions.txt"));
            String strQuestion = "", strAnswer = "";

            // Scanner to read client's responses
            Scanner responseScanner = new Scanner(clientSocket.getInputStream());

            while (questionScanner.hasNextLine())
            {
                strQuestion = questionScanner.nextLine();

                // Send a question from input file to the client 
                out.println(strQuestion);
                System.out.println("Question sent: " + strQuestion );

                // Read response from client, dump onto console
                strAnswer = responseScanner.nextLine();
                System.out.println("Answer received: " + strAnswer );
            }

            out.close();
            questionScanner.close();
            responseScanner.close();
            serverSocket.close();
        }
        catch (IOException e)
        {
            System.out.println(e);
            System.exit(1);
        }
    }
}
