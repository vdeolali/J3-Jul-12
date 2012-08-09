// -------- Begin: MyFrame.java ------------------
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame
{
    JTextField tfResult;
    JLabel lblResult;

    public MyFrame()
    {
        super("Swing Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyFileMenu fileMenu = new MyFileMenu();
        MyHelpMenu helpMenu = new MyHelpMenu();
        JMenuBar mb = new JMenuBar();
        mb.add(fileMenu);
        mb.add(helpMenu);
        setJMenuBar(mb);

        // Result text field
        tfResult = new JTextField(40);
        tfResult.setEditable(false);

        lblResult = new JLabel("Result: ");

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        resultPanel.setSize(200, 50);

        resultPanel.add(lblResult);
        resultPanel.add(tfResult);

        // Add the result panel to the frame
        add( resultPanel );

        setSize(350, 200);
        setVisible(true);
    }

    class MyFileMenu extends JMenu implements ActionListener
    {
        public MyFileMenu()
        {
            super("File");

            JMenuItem menuItem1 = new JMenuItem("Open");
            JMenuItem menuItem2 = new JMenuItem("Close");
            JMenuItem menuItem3 = new JMenuItem("Exit");

            add(menuItem1);
            add(menuItem2);
            add(menuItem3);

            menuItem1.addActionListener(this);
            menuItem2.addActionListener(this);
            menuItem3.addActionListener(this);
        }

        public void actionPerformed(ActionEvent e)
        {
            String item = e.getActionCommand();

            if (item.equals("Exit")) System.exit(0);
            else tfResult.setText("Selected FileMenu " + item);
        }
    }

    class MyHelpMenu extends JMenu implements ActionListener
    {
        public MyHelpMenu()
        {
            super("Help");

            JMenuItem menuItem1 = new JMenuItem("Basics");
            JMenuItem menuItem2 = new JMenuItem("Advanced");
            JMenuItem menuItem3 = new JCheckBoxMenuItem("Manual");

            menuItem1.addActionListener(this);
            menuItem2.addActionListener(this);
            menuItem3.addActionListener(this);

            add(menuItem1);
            add(menuItem2);
            addSeparator();

            add(menuItem3);

            JMenu subMenu = new JMenu("Miscellaneous");

            JMenuItem menuItem4 = new JMenuItem("Help");
            JMenuItem menuItem5 = new JMenuItem("Other Option");

            menuItem4.addActionListener(this);
            menuItem5.addActionListener(this);

            subMenu.add(menuItem4);
            subMenu.add(menuItem5);

            add(subMenu);
        }

        public void actionPerformed(ActionEvent e)
        {
            tfResult.setText("Selected HelpMenu " + e.getActionCommand());
        }
    }
}
// -------- End: MyFrame.java ------------------