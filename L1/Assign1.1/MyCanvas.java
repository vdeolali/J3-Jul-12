// ----------- Begin: MyCanvas.java --------
import java.awt.*;

public class MyCanvas extends Canvas
{
    public MyCanvas() { }

    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 18));
        g.drawString("My Chess Game", 120, 20);
	g.setColor(Color.blue);
	g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
	g.drawString("Computer(Black Pieces)", 110,35);

	
	//        g.setColor(Color.green);
        // g.drawLine(30, 40, 300, 250);

        g.setColor(Color.black);
        g.drawRect(80, 60, 240, 240);
	int origx = 80, origy = 60;

	for (int i = 0; i < 8; i++){
	    for (int j = 0; j < 4; j++){
		if ((i % 2) == 0){
		g.drawRect(origx, origy, 30,30);
		g.fillRect(origx+30, origy, 30,30);
		origx = origx + 60;
		}else {
		g.fillRect(origx, origy, 30,30);
		g.drawRect(origx+30, origy, 30,30);

		origx = origx + 60;
		}
	    }
	    origy = origy + 30;
	    origx = 80;
	}
	    

	//        g.setColor(Color.cyan);
	// g.fillOval(300, 60, 80, 80);

        //g.setColor(Color.blue);
	// g.drawOval(300, 60, 80, 80);
	g.setColor(Color.blue);
	g.drawString("You (White Pieces)", 110,240+60+35);

    }
}
// ----------- End: MyCanvas.java --------