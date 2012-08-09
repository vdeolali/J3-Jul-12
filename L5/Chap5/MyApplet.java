import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyApplet extends JApplet implements ItemListener
{
    JTextField tfResult;
    JLabel lblResult;

    JCheckBox checkbox1, checkbox2, checkbox3;
    JRadioButton radioButton1, radioButton2, radioButton3;
    ButtonGroup bg;
    JComboBox comboBox;
    JList list;

    public void init()
    {
        GridLayout gl = new GridLayout(2,1,5,5);
        setLayout(gl);

        // Input Panel (to hold Check-boxes and Radio buttons)
        JPanel inputPanel = new JPanel();
        GridLayout ipgl = new GridLayout(1,3,5,5);
        inputPanel.setLayout(ipgl);
        inputPanel.setSize(200, 100);

        // Check-boxes
        checkbox1 = new JCheckBox("Joint Return");
        checkbox2 = new JCheckBox("Has Dependents");
        checkbox3 = new JCheckBox("Over 50");

        MyMouseAdapter ma = new MyMouseAdapter();

        checkbox1.addMouseListener(ma);
        checkbox2.addMouseListener(ma);
        checkbox3.addMouseListener(ma);

        JPanel checkboxPanel = new JPanel();
        GridLayout cbgl = new GridLayout(3,1,5,5);
        checkboxPanel.setLayout(cbgl);
        checkboxPanel.setSize(100, 100);

        checkboxPanel.add(checkbox1);
        checkboxPanel.add(checkbox2);
        checkboxPanel.add(checkbox3);

        // Radio buttons
        bg = new ButtonGroup();
        radioButton1 = new JRadioButton("Single", true);
        radioButton2 = new JRadioButton("Married, Joint", false);
        radioButton3 = new JRadioButton("Married, Separate", false);

        radioButton1.setActionCommand(radioButton1.getText());
        radioButton2.setActionCommand(radioButton2.getText());
        radioButton3.setActionCommand(radioButton3.getText());

        radioButton1.addMouseListener(ma);
        radioButton2.addMouseListener(ma);
        radioButton3.addMouseListener(ma);

        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);

        JPanel radioPanel = new JPanel();
        GridLayout gl4 = new GridLayout(3,1,5,5);
        radioPanel.setLayout(gl4);
        radioPanel.setSize(100, 100);

        radioPanel.add(radioButton1);
        radioPanel.add(radioButton2);
        radioPanel.add(radioButton3);

        // Drop-down Choice
        comboBox = new JComboBox();
        comboBox.addItem("Arizona");
        comboBox.addItem("California");
        comboBox.addItem("Nevada");

        comboBox.addItemListener(this);

        // List
        String[] listOptions = {"Std Dedn", "Itemized"};
        list = new JList(listOptions);

        list.setSelectedIndex(0);

        list.addMouseListener(ma);

        // Result text field
        tfResult = new JTextField(40);
        tfResult.setEditable(false);

        lblResult = new JLabel("Result: ");

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        resultPanel.setSize(200, 50);

        resultPanel.add(lblResult);
        resultPanel.add(tfResult);

        // Add all panels to frame
        inputPanel.add( checkboxPanel );
        inputPanel.add( radioPanel );

        JPanel inputPanelSub = new JPanel();
        GridLayout ipsgl = new GridLayout(2,1,5,5);
        inputPanelSub.setLayout(ipsgl);
        inputPanelSub.setSize(100, 100);

        inputPanelSub.add( comboBox );
        inputPanelSub.add( list );
        inputPanel.add( inputPanelSub );

        add( inputPanel );
        add( resultPanel );
    }

    public void itemStateChanged(ItemEvent e)
    {
        updateResult();
    }

    class MyMouseAdapter extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            updateResult();
        }
    }

    private void updateResult()
    {
        String result = "";

        if (checkbox1.isSelected()) result += " " + checkbox1.getText();
        if (checkbox2.isSelected()) result += " " + checkbox2.getText();
        if (checkbox3.isSelected()) result += " " + checkbox3.getText();

        result += " " + bg.getSelection().getActionCommand();

        result += " " + comboBox.getSelectedItem();

        result += " " + list.getSelectedValue();

        tfResult.setText(result);
    }
}