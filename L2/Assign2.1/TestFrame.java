class TestFrame
{
    public static void main(String args[])
    {
        MyFrame test = new MyFrame();
        test.addWindowListener(new MyWindowHandler());
    }
}
