// ----------- Begin: MyWindowHandler.java --------
import java.awt.*;
import java.awt.event.*;

class MyWindowHandler extends WindowAdapter
{
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
}
// ----------- End: MyWindowHandler.java --------