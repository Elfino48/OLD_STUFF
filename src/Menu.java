import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Menu extends JFrame {
JPanel cp;
JPanel nt;
JPanel suza;
JLayeredPane lp;
Main m;
Main m1;
JFrame fr;
int z;
RoundButton button;

    public Menu(){
        super("Round button test");
        fr = this;
        lp = new JLayeredPane();
        lp.setLayout(null);
        setUndecorated(true);
        setSize(800, 600);
        m = new Main(0,0,800,600);
        m.setBounds(0, 0, 800, 600);
      
        mnSet(); 
        ntSet();
        suzaSet();  
        
        setContentPane(lp);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);;
        setLocationRelativeTo(null);

    }



    public void mnSet(){
        cp = new JPanel(new FlowLayout());
        cp.setLayout(null);
        cp.setBounds(0,0,1920,1080);
        Button(742,5, 50, 50, "/img/Menu/Exit.png", "/img/Menu/Exit.png", "/img/Menu/Exit.png", new ext(), cp);
        Button(15,225, 250, 240, "/img/Menu/Plan.png", "/img/Menu/Plan.png", "/img/Menu/Planprs.png", new starti(0), cp );
        Button(50, 475, 185, 40, "/img/Menu/PlanTX.png", "/img/Menu/PlanTX.png", "/img/Menu/PlanTXprs.png", null, cp);
        button = Button(276, 225, 250, 240, "/img/Menu/Suz.png", "/img/Menu/Suz.png", "/img/Menu/Suzprs.png", new suza(), cp);
        Button(345, 475, 120 , 40, "/img/Menu/SuzTX.png", "/img/Menu/SuzTX.png", "/img/Menu/SuzTXprs.png", new suza(), cp);
        Button(537, 225, 250, 240, "/img/Menu/Zagtem.png", "/img/Menu/Zagtem.png", "/img/Menu/Zagtemprs.png", new starti(3), cp);
        Button(565, 475, 200, 40, "/img/Menu/ZagTX.png", "/img/Menu/ZagTX.png", "/img/Menu/ZagtemTXprs.png", new starti(3), cp);
        Button(10,10, 40,40, "/img/Menu/prop.png", "/img/Menu/prop.png", "/img/Menu/prop.png", new ext(), cp);
        cp.add(m);
        lp.add(cp);
    }
    
    public void suzaSet(){
    	suza = new JPanel();
    	suza.setLayout(null);
    	suza.setBounds(276, 225, 250, 240);
    	suza.setOpaque(false);
    	
        Button(80,40, 98,25, "/img/Menu/lgk.png", "/img/Menu/lgkss.png", "/img/Menu/lgk.png", new starti(1), suza);
       // Button(65,100, 125,35, "/img/Menu/srdn.png", "/img/Menu/srdnss.png", "/img/Menu/srdn.png", ); 
        Button(60, 160, 135,35, "/img/Menu/skld.png", "/img/Menu/skldss.png", "/img/Menu/skld.png", new starti(2), suza);


    }
    
    public void ntSet(){
    	/*nt = new JPanel();
    	nt.setLayout(null);
        Button(1650, 760, 200,200, "/images/back.png",  "/images/back.png",  "/images/back.png", new backbutt(), nt );
    	nt.add(n);
        Button(325, 400, 262, 55, "/images/START.png", "/images/START.png", "/images/START.png", null, nt);
        Button(250, 500, 398, 55, "/images/Настройки1.png", "/images/Настройки1.png", "/images/Настройки1.png", null, nt);
        Button(350, 600, 214, 55, "/images/ВЫХОД.png", "/images/ВЫХОД.png", "/images/ВЫХОД.png", null, nt);
        Button(900,250,500,500, "/images/Cosmo.gif", "/images/Cosmo.gif", "/images/Cosmo.gif", null, nt);
        nt.add(m1);*/
  
    }
    
  
    public void suzON(){
    	lp.add(suza, JLayeredPane.MODAL_LAYER );

    }
    
    public void gpON(int i){
    	z = i;
    	cp.setVisible(false);
    	MainStart.gamestart(fr, z);
    	
    }
    
    public void ntON(){
       	nt.setVisible(true);
    	cp.setVisible(false);
    	setContentPane(nt);
    }
    
    public void mnON(){
    	nt.setVisible(false);
    	cp.setVisible(true);
    	setContentPane(cp);
    	repaint();
    }
    
    
    
    
    
    
    
    
    
    
class starti implements ActionListener{
    int j;
	public starti(int i){
		j = i;
    }
	public void actionPerformed(ActionEvent event) {
    	gpON(j);
	}
}

class nastr implements ActionListener{
    public void actionPerformed(ActionEvent event) {
    	ntON();
	}
}

class ext implements ActionListener{
    public void actionPerformed(ActionEvent event) {
    	System.exit(1);
	}
}

class backbutt implements ActionListener{
    public void actionPerformed(ActionEvent event) {
    	mnON();
	}
}


class suza implements ActionListener{
    public void actionPerformed(ActionEvent event) {

    	suzON();
    	button.setEnabled(false);
    	button.setDisabledIcon(new ImageIcon(getClass().getResource("/img/Menu/Suz.png")));
 
	}
}






    
    public RoundButton Button(int x, int y, int WD, int HG, String a, String b, String c, Object obj, JPanel panel){
        RoundButton rb2 = new RoundButton(new ImageIcon(getClass().getResource(a)));
        rb2.setRolloverEnabled(true);
        rb2.setRolloverIcon(new ImageIcon(getClass().getResource(b)));
        rb2.setPressedIcon(new ImageIcon(getClass().getResource(c)));
        rb2.setLocation(x,y);
        rb2.setSize(WD,HG);
        rb2.addActionListener((ActionListener) obj);
        rb2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(rb2);
        return rb2;
    }

	
    
    
    
    
    
    
    
    
    public class Main extends JPanel{
		int x,y,hd,wg;
		
		public Main(int x1, int y1, int hd1, int wg1){
			x = x1;
			y = y1;
			hd = hd1;
			wg = wg1;
		}
		Image img = new ImageIcon("src/img/Fon/Fon.png").getImage();
		Image img2 = new ImageIcon("src/img/Menu/ObertemTX.png").getImage();
		
		public void paintComponent(Graphics g){
			g.drawImage(img, x, y, hd, wg, null);
			g.drawImage(img2,210,70,null);
		}
		
		
	}

    	
}