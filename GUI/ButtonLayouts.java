import javax.swing.*;
import java.awt.*;

public class ButtonLayouts extends JPanel {

    private JButton[][] buttons = new JButton[4][4];

    public ButtonLayouts() {
        createUI();
    }

    private void createUI() {
        createButtons();

        setLayout(new GridLayout(4, 4));

        for(JButton[] btnRow : buttons) {
            for (JButton btn : btnRow) {
                add(btn);
            }
        }
    }

    private void createButtons() {
        String[][] buttonSigns = {
                {"9", "8", "1", "+"},
                {"6", "5", "4", "-"},
                {"3", "2", "1", "/"},
                {"0", "c", "=", "*"},
        };

        for (int i = 0; i < buttonSigns.length; ++i) {
            for (int j = 0; j < buttonSigns[i].length; ++j) {
                buttons[i][j] = new JButton(buttonSigns[i][j]);
            }
        }
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    public void setButtons(JButton[][] buttons) {
        this.buttons = buttons;
    }
}
