import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mainframe extends JFrame implements ActionListener {
    private ButtonLayouts buttonLayouts;
    private JTextField textField;

    // this is where all our UI code will run, always inside the constructor
    public Mainframe() {
        super("Java Swing Calculator"); // window title

        buttonLayouts = new ButtonLayouts(); // the buttons we created

        textField = new JTextField(30); // set the no. of cols in JTextField
        textField.setHorizontalAlignment(SwingConstants.RIGHT); // align the text to the right

        setLayout(new BorderLayout()); // set a border layout
        add(textField, BorderLayout.NORTH); // mount the component to the north
        add(buttonLayouts, BorderLayout.CENTER); // center the button layouts

        addActionListeners(); // add all the action listeners

        setVisible(true); // set visible to true
        setLocation(200,200); // render from 200x200 pixel location
        setSize(400,500); // set a width and height of 400x500 pixels
        setDefaultCloseOperation(EXIT_ON_CLOSE); // on close, exit from the program
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("=")) {

            /**
             * Check for any illegal expressions
             */
            if (illegalExpression()) { // check for any trailing or leading operators
                textField.setText("Wrong Expression");
                return;
            }

            // BO-DMAS rule
            if (textField.getText().contains("/")) {
                divide();
            }

            if (textField.getText().contains("*")) {
                multiply();
            }

            if (textField.getText().contains("+")) {
                add();
            }

            if (textField.getText().contains("-")) {
                subtract();
            }

        } else if(e.getActionCommand().equals("c")){ // if we get a clear button press, clear the text field
            textField.setText("");
        } else {
            textField.setText(textField.getText() + e.getActionCommand()); // else keep adding stuff to the text field
        }
    }

    /**
     * A function to bind all the action listeners to this frame
     */
    private void addActionListeners() {
        for (JButton[] btnRow : buttonLayouts.getButtons()) {
            for (JButton btn : btnRow) {
                btn.addActionListener(this);
            }
        }
    }

    /**
     * Add logic
     */
    private void add() {
        String[] numbers = textField.getText().split("[+]");
        int sum = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
        appendResult(sum);
    }


    /**
     * Multiply logic
     */
    private void multiply() {
        String[] numbers = textField.getText().split("[*]");
        int mult = Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
        appendResult(mult);
    }


    /**
     * Divide logic
     */
    private void divide() {
        String[] numbers = textField.getText().split("[/]");
        int div = Integer.parseInt(numbers[0]) / Integer.parseInt(numbers[1]);
        appendResult(div);
    }


    /**
     * Subtract logic
     */
    private void subtract() {
        String[] numbers = textField.getText().split("[-]");
        int sub = Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]);
        appendResult(sub);
    }

    /**
     * Append the results
     */
    private void appendResult(int value){
        textField.setText(String.valueOf(value));
    }


    private boolean illegalExpression() {
        return textField.getText().charAt(textField.getText().length()-1) == '+' ||
                textField.getText().charAt(textField.getText().length()-1) == '-' ||
                textField.getText().charAt(textField.getText().length()-1) == '/' ||
                textField.getText().charAt(textField.getText().length()-1) == '*';
    }


}
