// -------- Begin: MyFrame.java ------------------
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame
{
    ImageIcon image;
    JLabel lbl;

    public MyFrame()
    {
        super("Swing Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbl = new JLabel();

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());
        resultPanel.setSize(200, 50);

        resultPanel.add(lbl);

        // Add the result panel to the frame
        add( resultPanel );

        setSize(350, 200);
        setVisible(true);

        while(true) imageAnimator();
    }

    public void imageAnimator()
    {
        try
        {
            for (int i = 1; i <= 5; i++)
            {
                image = new ImageIcon("img" + i + ".gif");
                lbl.setIcon(image);
                Thread.sleep(1500);
            }
        }
        catch(InterruptedException e) {}
    }
}
// -------- End: MyFrame.java ------------------