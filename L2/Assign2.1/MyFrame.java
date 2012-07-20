import java.awt.*;
import java.awt.event.*;

public class MyFrame extends Frame
{
    TextField tfPhoneNumber, tfDialing;
    Button    dialButton, cancelButton;
    Button[]    dialPad = new Button[12];

    public MyFrame()
    {
        super("My Dialer");

	GridLayout gl = new GridLayout(7,1,2,2);
	setLayout(gl);

        Panel displayPanel = new Panel();
	Panel padPanel = new Panel();
	Panel padPanel1 = new Panel();
	Panel padPanel2 = new Panel();
	Panel padPanel3 = new Panel();
	Panel padPanel4 = new Panel();
	Panel butPanel = new Panel();
        Panel dialingPanel = new Panel();

        tfPhoneNumber = new TextField(20);
	displayPanel.add(tfPhoneNumber);
	//        padPanel.setLayout(new GridLayout(4,3,2,2));
	
	int i; 
	for (i=0; i < 9; i++){
	    dialPad[i] = new Button (Integer.toString(i+1));
	}
	dialPad[9] = new Button("*");
	dialPad[10] = new Button("0");
	dialPad[11] = new Button("#");

	MyMouseAdapter ma = new MyMouseAdapter();
	for (i = 0; i < 12; i++){
	    dialPad[i].setForeground(Color.blue);
	    dialPad[i].addMouseListener(ma);
	    dialPad[i].setPreferredSize (new Dimension(25,25));
	    //	    dialPad[i].setSize(35,35);
	    //	    padPanel.add(dialPad[i]);
	}
	
	//Try flow layout as grid layout does not give set button size.
	for (i = 0 ; i < 3; i++){
	    padPanel1.add(dialPad[i]);
	}

	for (i=3; i< 6; i++){
	    padPanel2.add(dialPad[i]);
	}
	
	for (i=6; i< 9; i++){
	    padPanel3.add(dialPad[i]);
	}
	for (i=9; i< 12; i++){
	    padPanel4.add(dialPad[i]);
	}	
	

        tfDialing = new TextField(20);
	dialingPanel.add(tfDialing);
        dialButton = new Button("Dial");
        cancelButton = new Button("Cancel/Erase");
        tfDialing.setEditable(false);
	dialButton.setSize(40,20);
	cancelButton.setSize(40,20);
	dialButton.addMouseListener(ma);
	dialButton.setForeground(Color.blue);
	cancelButton.setForeground(Color.blue);
	cancelButton.addMouseListener(ma);
	butPanel.add(dialButton);
	butPanel.add(cancelButton);


        displayPanel.setSize(250, 40);
        padPanel1.setSize(250, 40);
	padPanel2.setSize(180,40);
	padPanel3.setSize(180,40);
	padPanel4.setSize(180,40);
        butPanel.setSize(250, 25);
        dialingPanel.setSize(250, 20);

        // Add Panels to Frame
        add( displayPanel );
	//add(padPanel);
	add(padPanel1);
	add(padPanel2);
	add(padPanel3);
	add(padPanel4);
	add(butPanel);
	add(dialingPanel);

	//        MyMouseAdapter ma = new MyMouseAdapter();
	//        button.addMouseListener(ma);

        setSize(250, 250);
        setVisible(true);
    }

    class MyMouseAdapter extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {

            if (e.getSource() == dialButton)
            {
                tfDialing.setText("Dialing.." + tfPhoneNumber.getText());
            }

	     if (e.getSource() == cancelButton)
            {
                tfPhoneNumber.setText("");
		tfDialing.setText ("");
            }
	     if (e.getSource() == dialPad[0]){
		 tfPhoneNumber.setText(tfPhoneNumber.getText()+"1");
	     }

     	     if (e.getSource() == dialPad[1]){
		 tfPhoneNumber.setText(tfPhoneNumber.getText()+"2");
	     }

	      if (e.getSource() == dialPad[2]){
		 tfPhoneNumber.setText(tfPhoneNumber.getText()+"3");
	     }
     	     if (e.getSource() == dialPad[3]){
		 tfPhoneNumber.setText(tfPhoneNumber.getText()+"4");
	     }
     	     if (e.getSource() == dialPad[4]){
		 tfPhoneNumber.setText(tfPhoneNumber.getText()+"5");
	     }
     	     if (e.getSource() == dialPad[5]){
		 tfPhoneNumber.setText(tfPhoneNumber.getText()+"6");
	     }

     	     if (e.getSource() == dialPad[6]){
		 tfPhoneNumber.setText(tfPhoneNumber.getText()+"7");
	     }
	     
     	     if (e.getSource() == dialPad[7]){
		 tfPhoneNumber.setText(tfPhoneNumber.getText()+"8");
	     }
	     
       	     if (e.getSource() == dialPad[8]){
		 tfPhoneNumber.setText(tfPhoneNumber.getText()+"9");
	     }
	     
     	     if (e.getSource() == dialPad[9]){
		 tfPhoneNumber.setText(tfPhoneNumber.getText()+"*");
	     }
     	     if (e.getSource() == dialPad[10]){
		 tfPhoneNumber.setText(tfPhoneNumber.getText()+"0");
	     }
     	     if (e.getSource() == dialPad[11]){
		 tfPhoneNumber.setText(tfPhoneNumber.getText()+"#");
	     }	     
        }
    }
}
