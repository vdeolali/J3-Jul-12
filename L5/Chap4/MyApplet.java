
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class MyApplet extends Applet
{
    TextField tfResult;
    Label lblResult;

    public void init()
    {
        // Result text field
        tfResult = new TextField(40);
        tfResult.setEditable(false);

        lblResult = new Label("Result: ");

        Panel resultPanel = new Panel();
        resultPanel.setLayout(new FlowLayout());
        resultPanel.setSize(200, 50);

        resultPanel.add(lblResult);
        resultPanel.add(tfResult);

        // Add Result Panel to the Applet
        add( resultPanel );

        // Get age from applet param tag, and display it back
        int age = 0;
        String strAge = getParameter("age");
        if (strAge != null) age = Integer.parseInt(strAge);

        tfResult.setText("Age is: " + age);
    }
}