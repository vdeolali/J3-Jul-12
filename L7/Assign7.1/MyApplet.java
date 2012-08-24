// -------- Begin: MyApplet.java ------------------
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class MyApplet extends JApplet implements Runnable 
{
    Thread thr;
    JLabel lbl;
    String[] msgs = {"Apples", "Oranges", "Bananas", "Grapes", "Strawberries" };
    int[] xcoord = {50, 100, 150, 100, 50};
    int[] ycoord = {50, 75, 100,125,  150};
    int index = 0;

    public void init()
    {
        thr = null;

        lbl = new JLabel();

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());
        resultPanel.setSize(200, 50);

        resultPanel.add(lbl);

        // Add the result panel to the frame
        add( resultPanel );
    }

    public void start()
    {
        if ( thr == null )
        {
            thr = new Thread( this );
            thr.start();
        }
    }

    public void stop()
    {
        thr.interrupt();
        thr = null;
    }

    public void run()
    {
        while (true)
        {
            try
            {
                repaint();
                thr.sleep( 2000 );

                index++;

                if (index %5 == 0) { index = 0; }
            }
            catch ( InterruptedException e ) { break; }
        }
    }

    public void paint(Graphics g)
    {
	g.setColor (Color.blue);
        g.drawRect( 50, 50, 100, 100);
        g.setColor( Color.white );
	g.drawLine(50,50,50,150);
	if (index ==0){
	    //	    System.out.println ("Index :" + index);
	g.setColor(Color.white);
	g.drawOval(xcoord[4],ycoord[4], 10,10);
	g.fillOval(xcoord[4],ycoord[4], 10,10);
        g.setColor(Color.cyan);
	g.drawOval(xcoord[index],ycoord[index], 10,10);
	g.fillOval(xcoord[index],ycoord[index], 10,10);
		
	}else {
        g.setColor(Color.cyan);
	g.drawOval(xcoord[index],ycoord[index], 10,10);
	g.fillOval(xcoord[index],ycoord[index], 10,10);
	g.setColor(Color.white);
	g.drawOval(xcoord[index-1],ycoord[index-1], 10,10);
	g.fillOval(xcoord[index-1],ycoord[index-1], 10,10);
	}
	//        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
	//        g.drawString(msgs[index], 60, 70);
    }
}
// -------- End: MyApplet.java ------------------
