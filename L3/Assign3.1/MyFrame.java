import java.util.List;
import java.util.Iterator;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends Frame implements ItemListener
{
    TextField tfResult, tfPhoneNumber, tfDialing;
    Button    dialButton, cancelButton;
    Label lblResult;

    Checkbox checkbox1, checkbox2, checkbox3;
    Checkbox radioButton1, radioButton2, radioButton3;
    CheckboxGroup cg;
    Choice choice;
    java.awt.List list;

    public MyFrame()
    {
        super("My Dialer");

        GridLayout gl = new GridLayout(4,1,5,5);
        setLayout(gl);
	// Panel to display PhoneNumber
	Panel displayPanel = new Panel();
	Panel butPanel = new Panel();
	Panel dialingPanel = new Panel();

	tfPhoneNumber = new TextField(20);
	tfDialing = new TextField(20);
	tfDialing.setEditable(false);
	MyMouseAdapter ma = new MyMouseAdapter();
	
	dialButton = new Button("Dial");
	cancelButton = new Button("Cancel/Erase");
	dialButton.setSize(40,20);
	cancelButton.setSize(40,20);
	dialButton.addMouseListener(ma);
	cancelButton.addMouseListener(ma);
	displayPanel.add(tfPhoneNumber);
	dialingPanel.add(tfDialing);
	butPanel.add(dialButton);
	butPanel.add(cancelButton);
	
        Panel inputPanel = new Panel();
        GridLayout ipgl = new GridLayout(1,1,5,5);
        inputPanel.setLayout(ipgl);
        inputPanel.setSize(100, 100);

        // List

	List<PhoneNum> pnList = PhoneUtil.readPhoneList("phone.txt");
	Iterator <PhoneNum> it = pnList.iterator();
        list = new java.awt.List(5, false);

	while (it.hasNext()){
	    PhoneNum pn = it.next();
	    list.add(pn.getPhoneNum());
       }
        list.select(0);
        list.addItemListener(this);
	inputPanel.add(list);

	add(displayPanel);
        add( inputPanel );
	add(butPanel);
	add(dialingPanel);

	displayPanel.setSize(250,40);
	butPanel.setSize(250,30);
        setSize(300, 300);
        setVisible(true);
    }

    public void itemStateChanged(ItemEvent e)
    {
	//        updateResult();
	//	System.out.println (list.getSelectedItem());
	tfPhoneNumber.setText(list.getSelectedItem());
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
	     
	     //            updateResult();
        }
    }

    private void updateResult()
    {
        String result = "";

        if (checkbox1.getState()) result += " " + checkbox1.getLabel();
        if (checkbox2.getState()) result += " " + checkbox2.getLabel();
        if (checkbox3.getState()) result += " " + checkbox3.getLabel();

        result += " " + cg.getSelectedCheckbox().getLabel();

        result += " " + choice.getSelectedItem();

        result += " " + list.getSelectedItem();

        tfResult.setText(result);
    }
}
