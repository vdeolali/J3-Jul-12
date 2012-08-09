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

    JRadioButton[] radioButtons = new JRadioButton[4]; 
    ButtonGroup bg;

    public MyFrame()
    {
        super("My Dialer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container content = getContentPane();
	
        GridLayout gl = new GridLayout(4,1,5,5);
        content.setLayout(gl);

        JPanel displayPanel = new JPanel();
	//        GridLayout dpgl = new GridLayout(1,1,5,5);
        displayPanel.setLayout(new GridLayout());
	//	displayPanel.setLayout(new FlowLayout());
	//        displayPanel.setSize(100, 30);
	//	displayPanel.setMaximumSize (new Dimension(80,20));
        tfPhoneNumber = new JTextField(40);
	tfPhoneNumber.setEditable(false);

	displayPanel.add(tfPhoneNumber);

        MyMouseAdapter ma = new MyMouseAdapter();


        JPanel radioPanel = new JPanel();
        GridLayout rbgl = new GridLayout(4,1,5,5);
	radioPanel.setLayout(rbgl);
	//        radioPanel.setSize(150, 200);
	radioPanel.setPreferredSize (new Dimension(150, 200));
	content.add(radioPanel);



        // Radio buttons
        bg = new ButtonGroup();
	List<PhoneNum> pnList = PhoneUtil.readPhoneList("phone.txt");
	Iterator<PhoneNum> it = pnList.iterator();

	int i = 0 ; 
	while (it.hasNext()){
	    PhoneNum pn = it.next();
	    radioButtons[i] = new JRadioButton(pn.getPhoneNum(), true);
	    radioButtons[i].setActionCommand(radioButtons[i].getText());
	    radioButtons[i].addMouseListener(ma);
	    bg.add(radioButtons[i]);
	    radioPanel.add(radioButtons[i]);
	    i++;
	}

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
	//	butPanel.setSize (150,30);
	
        // Dialing text field
        tfDialing = new JTextField(40);
        tfDialing.setEditable(false);

	//        lblResult = new JLabel("Result: ");

        JPanel dialingPanel = new JPanel();
        dialingPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        dialingPanel.setSize(200, 50);
        dialingPanel.add(tfDialing);

        content.add( displayPanel , BorderLayout.NORTH);
        content.add( radioPanel );
        content.add( butPanel );
	content.add (dialingPanel);
        setSize(300, 450);
	//	pack();
        setVisible(true);
	tfPhoneNumber.setText(bg.getSelection().getActionCommand());
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
	    tfPhoneNumber.setText(bg.getSelection().getActionCommand());
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


        result += " " + bg.getSelection().getActionCommand();

        tfDialing.setText(result);
    }
}
