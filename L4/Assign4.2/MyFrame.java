import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;
import java.util.Iterator;

public class MyFrame extends JFrame implements ItemListener
{
    JTextField tfPhoneNumber, tfDialing;
    JButton  dialButton, cancelButton;
    //    JLabel lblResult;

    //    JRadioButton[] radioButtons = new JRadioButton[4]; 
    //  ButtonGroup bg;

    public MyFrame()
    {
        super("My Dialer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout gl = new GridLayout(4,1,5,5);
        setLayout(gl);

        JPanel displayPanel = new JPanel();
        GridLayout dpgl = new GridLayout(1,1,5,5);
        displayPanel.setLayout(dpgl);
	//	displayPanel.setLayout(new FlowLayout());
        displayPanel.setSize(100, 30);
        tfPhoneNumber = new JTextField(40);
	tfPhoneNumber.setEditable(false);

	displayPanel.add(tfPhoneNumber);

        MyMouseAdapter ma = new MyMouseAdapter();

	//Menu
	List<PhoneNum> pnList = PhoneUtil.readPhoneList("phone.txt");

	MyMenu menu = new MyMenu(pnList);
	JMenuBar mb = new JMenuBar();
	
	mb.add(menu);
	setJMenuBar(mb);

        // Buttons
	JPanel butPanel = new JPanel();
	dialButton = new JButton("Dial");
	cancelButton = new JButton("Cancel/Erase");

	dialButton.setSize(40,20);
	cancelButton.setSize(40,20);
	dialButton.addMouseListener(ma);
	cancelButton.addMouseListener(ma);
	butPanel.add(dialButton);
	butPanel.add(cancelButton);
	butPanel.setSize (150,30);
	
        // Dialing text field
        tfDialing = new JTextField(40);
        tfDialing.setEditable(false);

	//        lblResult = new JLabel("Result: ");

        JPanel dialingPanel = new JPanel();
        dialingPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        dialingPanel.setSize(200, 50);
        dialingPanel.add(tfDialing);

        add( displayPanel );
        add( butPanel );
	add (dialingPanel);

        setSize(300, 350);
        setVisible(true);
	//	tfPhoneNumber.setText(bg.getSelection().getActionCommand());
    }

    public void itemStateChanged(ItemEvent e)
    {
	        updateResult();
    }

    class MyMouseAdapter extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
	    String result = "";
	    //	    tfPhoneNumber.setText(bg.getSelection().getActionCommand());
	    if (e.getSource() == dialButton) 
            {
		
                tfDialing.setText("Dialing.." + tfPhoneNumber.getText()); 
            } 

	    if (e.getSource() == cancelButton) 
            { 
                tfPhoneNumber.setText(""); 
		tfDialing.setText (""); 
            } 
     
	    //            updateResult();
        }
    }

    private void updateResult()
    {
        String result = "";


	//        result += " " + bg.getSelection().getActionCommand();

        tfDialing.setText(result);
    }


    public class MyMenu extends JMenu implements ActionListener{

	public MyMenu(java.util.List pnList){
	    super("File");

	    JMenu nmbrs = new JMenu ("Dialed Nmbrs");

	    //	    System.out.println ("Iam here");
	    JMenuItem[] menus = new JMenuItem[10];
	    Iterator<PhoneNum> it = pnList.iterator();
	    int i = 0 ; 
	    while (it.hasNext()){
		PhoneNum pn = it.next();
		menus[i] = new JMenuItem(pn.getPhoneNum());
		menus[i].addActionListener(this);
		nmbrs.add(menus[i]);
		i++;
	    }
	    add (nmbrs);
	    JMenuItem AskNum = new  JMenuItem("Enter New Nbr");
	    AskNum.addActionListener(this);
	    add (AskNum);
    	    JMenuItem Exit = new JMenuItem("Exit");
    	    Exit.addActionListener(this);
	    add (AskNum);
	    add (Exit);
	}

	public void actionPerformed(ActionEvent e){
	    String item = e.getActionCommand();
	    //	System.out.println (item);
	    if (item.equals("Exit")) {
		System.exit(0);
	    } else if (item.contains ("Enter")){
		String savepn = tfPhoneNumber.getText();
		tfDialing.setText ("");
		String pn = JOptionPane.showInputDialog(this,"Please Enter Number");
		int confirm = JOptionPane.showConfirmDialog(this,"You Entered " + pn + " Is this correct?");
		switch (confirm){
		case JOptionPane.YES_OPTION:
		    tfPhoneNumber.setText(pn);
		    break;
		case JOptionPane.NO_OPTION:
		    tfPhoneNumber.setText("");
		    break;
		case JOptionPane.CANCEL_OPTION:
		    tfPhoneNumber.setText(savepn);
		    break;
		}
	    } else {
		tfPhoneNumber.setText(item);
	    }
	}
    }
}

