import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Gamestarting {
	static JFrame fr;
	JPanel panel;
	static int k;
	static JLayeredPane lp;
	fonpnt fn;
	Image img;
	
	Image imgz = new ImageIcon("src/img/Game/Plan/TXpit.png").getImage();
	
	public Gamestarting(JFrame frame, int h){
		fr = frame;
		lp = new JLayeredPane();
		lp.setLayout(null);
		lp.setBounds(0,0,Screen.W,Screen.H);
		fn = new fonpnt();
		k = h;
		chan();
		fn.setBounds(0, 0, Screen.W,Screen.H);
		fr.setBounds(0,0, Screen.W,Screen.H);
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, Screen.W,Screen.H);
		panel.setBackground(Color.BLACK);
		panel.add(fn);
		lp.add(panel, JLayeredPane.DEFAULT_LAYER);
		fr.setContentPane(lp);
		strt();
	}
	
	public void chan(){
		if ( k == 0 ){
			img = new ImageIcon("src/img/Fon/FonPlan.png").getImage();
		} else if ( k == 1 || k == 2){
			img = new ImageIcon("src/img/Fon/“ест—уз.png").getImage();
		} else if ( k == 3 ){
			img = new ImageIcon("src/img/Fon/FonZag.jpg").getImage();
		}
		
	
	}

	public static void strt(){
		new Questio(fr,lp, k);
	}

	
	
	public class fonpnt extends JPanel{
		public void paintComponent(Graphics g){
			g.drawImage(img, 0, 0, Screen.W,Screen.H, null);
			g.drawImage(imgz, Screen.szs(0, 1000),  Screen.szs(1, 100),  Screen.szs(0, 557),  Screen.szs(0, 46), null);
		}
	}

}
