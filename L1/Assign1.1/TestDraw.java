import java.awt.*;

public class TestDraw
{
    public static void main(String[] args)
    {
        Frame f = new Frame("Assign1.1");
        f.addWindowListener(new MyWindowHandler());
        f.setSize(400, 400);
        MyCanvas canvas = new MyCanvas();
        f.add(canvas);
        f.setVisible(true);
    }
}
