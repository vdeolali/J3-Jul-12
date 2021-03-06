import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class MyApplet extends Applet implements ItemListener
{
    TextField tfResult;
    Label lblResult;

    Checkbox checkbox1, checkbox2, checkbox3;
    Checkbox radioButton1, radioButton2, radioButton3;
    CheckboxGroup cg;
    Choice choice;
    List list;

    public void init()
    {
        GridLayout gl = new GridLayout(2,1,5,5);
        setLayout(gl);

        // Input Panel (to hold Check-boxes and Radio buttons)
        Panel inputPanel = new Panel();
        GridLayout ipgl = new GridLayout(1,3,5,5);
        inputPanel.setLayout(ipgl);
        inputPanel.setSize(200, 100);

        // Check-boxes
        checkbox1 = new Checkbox("Joint Return");
        checkbox2 = new Checkbox("Has Dependents");
        checkbox3 = new Checkbox("Over 50");

        MyMouseAdapter ma = new MyMouseAdapter();

        checkbox1.addMouseListener(ma);
        checkbox2.addMouseListener(ma);
        checkbox3.addMouseListener(ma);

        Panel checkboxPanel = new Panel();
        GridLayout cbgl = new GridLayout(3,1,5,5);
        checkboxPanel.setLayout(cbgl);
        checkboxPanel.setSize(100, 100);

        checkboxPanel.add(checkbox1);
        checkboxPanel.add(checkbox2);
        checkboxPanel.add(checkbox3);

        // Radio buttons
        cg = new CheckboxGroup();
        radioButton1 = new Checkbox("Single", cg, true);
        radioButton2 = new Checkbox("Married, Joint", cg, false);
        radioButton3 = new Checkbox("Married, Separate", cg, false);

        radioButton1.addMouseListener(ma);
        radioButton2.addMouseListener(ma);
        radioButton3.addMouseListener(ma);

        Panel radioPanel = new Panel();
        GridLayout gl4 = new GridLayout(3,1,5,5);
        radioPanel.setLayout(gl4);
        radioPanel.setSize(100, 100);

        radioPanel.add(radioButton1);
        radioPanel.add(radioButton2);
        radioPanel.add(radioButton3);

        // Drop-down Choice
        choice = new Choice();
        choice.add("Arizona");
        choice.add("California");
        choice.add("Nevada");

        choice.addItemListener(this);

        // List
        list = new List(2, false);

        list.add("Std Dedn");
        list.add("Itemized");
        list.select(0);

        list.addItemListener(this);

        // Result text field
        tfResult = new TextField(40);
        tfResult.setEditable(false);

        lblResult = new Label("Result: ");

        Panel resultPanel = new Panel();
        resultPanel.setLayout(new FlowLayout());
        resultPanel.setSize(200, 50);

        resultPanel.add(lblResult);
        resultPanel.add(tfResult);

        // Add all panels to frame
        inputPanel.add( checkboxPanel );
        inputPanel.add( radioPanel );

        Panel inputPanelSub = new Panel();
        GridLayout ipsgl = new GridLayout(2,1,5,5);
        inputPanelSub.setLayout(ipsgl);
        inputPanelSub.setSize(100, 100);

        inputPanelSub.add( choice );
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
        if (checkbox1.getState()) result += " " + checkbox1.getLabel();
        if (checkbox2.getState()) result += " " + checkbox2.getLabel();
        if (checkbox3.getState()) result += " " + checkbox3.getLabel();
        result += " " + cg.getSelectedCheckbox().getLabel();
        result += " " + choice.getSelectedItem();
        result += " " + list.getSelectedItem();
        tfResult.setText(result);
    }
}