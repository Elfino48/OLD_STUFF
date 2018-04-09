import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JButton;

public class RoundButton extends JButton {
	 
    public RoundButton(Icon icon){
        super(icon);
        setUI(new RoundButtonUI());
        setOpaque(false);
        setBorder(null);
        setBackground(new Color(0, 0, 0, 0));
        setContentAreaFilled(false);
    }
}