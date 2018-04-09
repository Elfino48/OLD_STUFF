import javax.swing.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
 
/**
 * RoundButtonUI
 *
 * @author Eugene Matyushkin aka Skipy
 * @since 04.07.13
 */
public class RoundButtonUI extends MetalButtonUI {
 
    private static final int FOCUS_GAP = 2;
 
    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton b) {
 
    }
 
    @Override
    protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
        Graphics2D g2d = (Graphics2D) g;
        
        /*Rectangle2D.Double focus = new Rectangle2D.Double(iconRect.getX() - FOCUS_GAP, iconRect.getY() - FOCUS_GAP,
        		iconRect.getWidth() + FOCUS_GAP * 2 - 1, iconRect.getHeight() + FOCUS_GAP * 2 - 1);
        Stroke s = g2d.getStroke();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1, new float[]{2, 2}, 0));
        g2d.draw(focus);
        g2d.setStroke(s);*/
    }
 
 
    @Override
    public Dimension getPreferredSize(JComponent c) {
        if (!(c instanceof RoundButton))
            return new Dimension(0,0);
        RoundButton rb = (RoundButton)c;
        Icon i = rb.getIcon();
        int w = (i == null) ? FOCUS_GAP*2 : i.getIconWidth()+FOCUS_GAP*2+2;
        int h = (i == null) ? FOCUS_GAP*2 : i.getIconHeight()+FOCUS_GAP*2+2;
        return new Dimension(w, h);
    }
 
    @Override
    public Dimension getMaximumSize(JComponent c) {
        return getPreferredSize(c);
    }
 
    @Override
    public Dimension getMinimumSize(JComponent c) {
        return getPreferredSize(c);
    }
 
    public static ComponentUI createUI(JComponent c){
        return (c instanceof RoundButton) ? new RoundButtonUI() : null;
    }
}


