
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Questio {
	
	ImageIcon pravv, npravv, pods, cc1, imerz, imerq, imer, imer1, imer2;
	
	drawing dr;
	
	Scanner sc,sc1,sc2,sc3,sc4, sc5;
	
	JLabel lbq, lbp;
	
	String ms;
	
	JPanel pnm, imj;
	
	int Sel = 0, vbr;
	
	RoundButton[] rbz = new RoundButton[4];
	
	RoundButton next, otvet;
	
	JLayeredPane lp;
	
	ArrayList<String> imahuO = new ArrayList<String>();
	
	ArrayList<String> imahu = new ArrayList<String>();
	
	ArrayList<String> fules = new ArrayList<String>();
	
	ArrayList<String> facts = new ArrayList<String>();
	
	ArrayList<String> cc = new ArrayList<String>();
	
	String[] choose = new String[4];

	ArrayList<String> answ = new ArrayList<String>();
	
	int mainnum, Vuub, rs, rs1 ;
	
	JFrame fr;



public Questio(JFrame fz, JLayeredPane lz, int k){
	vbr = k;
	FileReader();
	
	fr = fz;
	pnm = new JPanel();
	lp = lz;
	pnm.setLayout(null);
	pnm.setBounds(0, 0, Screen.W, Screen.H);
	pnm.setOpaque(false);
	otvet = Button(Screen.szs(0, 1100), Screen.szs(1, 700), Screen.szs(0, 348), Screen.szs(1, 103), "img/Game/Otvet1.png", "img/Game/Otvet1.png", "img/Game/Otvet2.png", pnm, 0, new otv());
	next = 	Button(Screen.szs(0, 1600), Screen.szs(1, 900), Screen.szs(0, 230), Screen.szs(1, 110), "img/Game/Next.png", "img/Game/Next.png", "img/Game/Next.png", pnm, 0, new nxt());
	next.setEnabled(false);
	
		chooser();Filler(); imahi();
		lp.add(pnm, JLayeredPane.PALETTE_LAYER );
		
}


public void FileReader(){
String kart = null, chh = null, hhc = null, otvpr = "src/img/Game/ImagiO.txt", filesi = null;
	 System.out.println(otvpr);
if ( vbr == 0 ){
	kart = "src/img/Game/Imagi.txt";
	chh = "src/Chooser'sTX";
	hhc = "src/img/Game/cc.txt";
} else if ( vbr == 1 ){
	kart = "src/img/Game/Imagi1";
	chh = "src/Chooser'sTXSuz";
	hhc = "src/img/Game/cc1.txt";
	filesi = "src/img/Game/Filesi1.txt";
} else if ( vbr == 2 ){
	kart = "src/img/Game/Imagi2.txt";
	chh = "src/Chooser'sTXSuz";
	hhc = "src/img/Game/cc1.txt";
	filesi = "src/img/Game/Filesi1.txt";
} else if ( vbr == 3 ){
	kart = "src/img/Game/Imagi3.txt";
	chh = "src/Chooser'sTXZag";
	hhc = "src/img/Game/cc2.txt";
	filesi = "src/img/Game/Filesi2.txt";
}






	try {
		sc = new Scanner(new File(kart));
	} catch (FileNotFoundException e) {JOptionPane.showMessageDialog(null, "File not Found");}
	while(sc.hasNext()){
		for(int i = 0; ; ){
			String za = sc.next();
			System.out.println(za);
			if (za.equals("!")){break;}
			imahu.add(za);
			
		}
	}
	
	
	try {
		sc1 = new Scanner(new File(chh));
	} catch (FileNotFoundException e) {JOptionPane.showMessageDialog(null, "File not Found");}
	
	while(sc1.hasNext()){
		for(int i = 0; ; ){
			String za1 = sc1.next();
			if (za1.equals("!")){break;}
			answ.add(za1);
			
		}
	}	
	
		for ( int i = 0; i < answ.size(); i++ ){
			String vvr = answ.get(i);
			char[] chv = vvr.toCharArray();
			String zzr = null;
			for ( int j = 0; j < chv.length ; j++ ){
				if ( chv[j] == '_'){
					chv[j] = ' ';
				}
				zzr = zzr + chv[j];
			}
			zzr = zzr.substring(4);
			System.out.println(" OPA = " + zzr);
			answ.set(i, zzr); 
		}
	
	
		
	mainnum = (int) (Math.random()*answ.size());
	
	
	if (vbr == 0){
				try {
					sc2 = new Scanner(new File("src/img/Game/Filesi.txt"));
				} catch (FileNotFoundException e) {JOptionPane.showMessageDialog(null, "File not Found");}
				
				while(sc2.hasNext()){
					for(int i = 0; ; ){
						String za2 = sc2.next();
						if (za2.equals("!")){break;}
						fules.add(za2);
					
					}
				}		
				try {
					sc3 = new Scanner(new File(fules.get(mainnum)));
				} catch (FileNotFoundException e) {JOptionPane.showMessageDialog(null, "File not Found1");}
				System.out.println(fules.get(mainnum) + " " + mainnum);
				while(sc3.hasNext()){
					for(int i = 0; ; ){
						String za3 = sc3.next();
						if (za3.equals("!")){break;}
						facts.add(za3);	
					}
				}	
	} else if ( vbr == 1 || vbr == 2 || vbr == 3){
		
		
		
		try {
			sc2 = new Scanner(new File(filesi));
		} catch (FileNotFoundException e) {JOptionPane.showMessageDialog(null, "File not Found");}
		
		while(sc2.hasNext()){
			for(int i = 0; ; ){
				String za2 = sc2.next();
				if (za2.equals("!")){break;}
				facts.add(za2);
			
			}
		}	
		
		
		
	}
	
	try {
		sc4 = new Scanner(new File(hhc));
	} catch (FileNotFoundException e) {JOptionPane.showMessageDialog(null, "File not Found2");}
	
	while(sc4.hasNext()){
		for(int i = 0; ; ){
			String za4 = sc4.next();
			if (za4.equals("!")){break;}
			cc.add(za4);	
		}
	}	
	
	
	try {
		sc5 = new Scanner(new File(otvpr));
	} catch (FileNotFoundException e) {JOptionPane.showMessageDialog(null, "File not Found4");}
	
	while(sc5.hasNext()){
		for(int i = 0; ; ){
			String za5 = sc5.next();
			if (za5.equals("!")){break;}
			imahuO.add(za5);	
		}
	}		

	
	
	
	
	
	
	
	
	
	
	
	
}






public void chooser(){
int p;
	ms = answ.get(mainnum);
	System.out.println(mainnum);
	rs = (int) (Math.random()*4);
	switch(rs){
	case 0:
		choose[0] = answ.get(mainnum);
		answ.remove(mainnum);

		p = (int) (Math.random()*answ.size());
		choose[1] = answ.get(p);
		answ.remove(p);
		
		p = (int)(Math.random()*answ.size());
		choose[2] = answ.get(p);
		answ.remove(p);
		
		p = (int)(Math.random()*answ.size());
		choose[3] = answ.get(p);
		answ.remove(p);
		break;
	case 1:
		choose[1] = answ.get(mainnum);
		answ.remove(mainnum);

		p = (int) (Math.random()*answ.size());
		choose[0] = answ.get(p);
		answ.remove(p);
		
		p = (int)(Math.random()*answ.size());
		choose[2] = answ.get(p);
		answ.remove(p);
		
		p = (int)(Math.random()*answ.size());
		choose[3] = answ.get(p);
		answ.remove(p);
		break;
	case 2:
		choose[2] = answ.get(mainnum);
		answ.remove(mainnum);

		p = (int)(Math.random()*answ.size());
		choose[1] = answ.get(p);
		answ.remove(p);
		  
		p = (int)(Math.random()*answ.size());
		choose[0] = answ.get(p);
		answ.remove(p);
		
		p = (int)(Math.random()*answ.size());
		choose[3] = answ.get(p);
		answ.remove(p);
		break;
	case 3:
		choose[3] = answ.get(mainnum);
		answ.remove(mainnum);

		p = (int)(Math.random()*answ.size());
		choose[1] = answ.get(p);
		answ.remove(p);
		
		p = (int)(Math.random()*answ.size());
		choose[0] = answ.get(p);
		answ.remove(p);
		
		p = (int)(Math.random()*answ.size());
		choose[2] = answ.get(p);
		answ.remove(p);
		break;
	}
}







public void Filler(){
	rbz[0] = Button(Screen.szs(0, 1000), Screen.szs(1, 210), Screen.szs(0, 100), Screen.szs(1, 80), "img/Game/RBoff.png", "img/Game/RBoff.png", "img/Game/RBon.png", pnm, 0, new ch(0));
	rbz[1] = Button(Screen.szs(0, 1000), Screen.szs(1, 330), Screen.szs(0, 100), Screen.szs(1, 80), "img/Game/RBoff.png", "img/Game/RBoff.png", "img/Game/RBon.png", pnm, 1, new ch(1));
	rbz[2] = Button(Screen.szs(0, 1000), Screen.szs(1, 450), Screen.szs(0, 100), Screen.szs(1, 80), "img/Game/RBoff.png", "img/Game/RBoff.png", "img/Game/RBon.png", pnm, 2, new ch(2));
	rbz[3] = Button(Screen.szs(0, 1000), Screen.szs(1, 570), Screen.szs(0, 100), Screen.szs(1, 80), "img/Game/RBoff.png", "img/Game/RBoff.png", "img/Game/RBon.png", pnm, 3, new ch(3));
}












public void drawUse(int l){
	dr = new drawing(l);
	dr.setBounds(0, 0, Screen.szs(0, 815), Screen.szs(1, 700));
	System.out.println("Rabotaem, vivodim na ekran izobrazhenie ");
	imj.add(dr);
	imj.repaint();
}




public void imahi(){
	imj = new JPanel();
	imj.setLayout(null);
	imj.setBounds(Screen.szs(0, 80), Screen.szs(1, 100), Screen.szs(0, 815), Screen.szs(1, 700));
	imj.setBackground(Color.BLACK);
	drawUse(0);

	lp.add(imj, JLayeredPane.MODAL_LAYER );
}


class drawing extends JPanel{
Image imgz;
	
	public drawing(int i){
		if ( i == 1 ){
			imgz = new ImageIcon(imahuO.get(mainnum)).getImage();
		} else { imgz = new ImageIcon(imahu.get(mainnum)).getImage();}
	}

	public void paintComponent(Graphics g){
		System.out.println(imahu.get(mainnum));
		g.drawImage(imgz, 0, 0, Screen.szs(0, 815), Screen.szs(1, 700), null);
	}
}


















	
	public RoundButton Button(int x, int y, int WD, int HG, String a, String b, String c, JPanel panel, int i, Object obj){
	    
		imer = new ImageIcon(getClass().getResource(a));
		imer = new ImageIcon(imer.getImage().getScaledInstance(WD, HG, Image.SCALE_SMOOTH));
		
		imer1 = new ImageIcon(getClass().getResource(b));
		imer1 = new ImageIcon(imer1.getImage().getScaledInstance(WD, HG, Image.SCALE_SMOOTH));
		
		imer2 = new ImageIcon(getClass().getResource(c));
		imer2 = new ImageIcon(imer2.getImage().getScaledInstance(WD, HG, Image.SCALE_SMOOTH));
		
		RoundButton rb2 = new RoundButton(imer);
	    rb2.setRolloverEnabled(true);
	    rb2.setRolloverIcon(imer1);
	    rb2.setPressedIcon(imer2);
	    rb2.setLocation(x,y);
	    rb2.setSize(WD,HG);
	    rb2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    rb2.addActionListener((ActionListener) obj);
	    
	    JLabel lb = new JLabel(choose[i]);
	    Font f = new Font("Courier New", Font.BOLD, Screen.szs(1, 67));
	    lb.setFont(f);
	    lb.setForeground(Color.GREEN);
	    lb.setBounds(x+ Screen.szs(0, 120), y - 160, Screen.szs(0, 800), Screen.szs(1, 400));
	    
	    panel.add(rb2);
	    panel.add(lb);
		return rb2;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
class ch implements ActionListener{
int c;
	public ch(int i){
	c = i;
	}
	
	public void actionPerformed(ActionEvent e) {
			for(int qr = 0; qr < 4; qr++){
				if(qr == c){
					imerz = new ImageIcon(getClass().getResource("img/Game/RBon.png"));
					imerz = new ImageIcon(imerz.getImage().getScaledInstance(Screen.szs(0, 100), Screen.szs(1, 80), Image.SCALE_SMOOTH));
					
					rbz[qr].setIcon(imerz);
					rbz[qr].setRolloverIcon(imerz);
					Vuub = qr;
				} else {
					imerq = new ImageIcon(getClass().getResource("img/Game/RBoff.png"));
					imerq = new ImageIcon(imerq.getImage().getScaledInstance(Screen.szs(0, 100), Screen.szs(1, 80), Image.SCALE_SMOOTH));
					
					rbz[qr].setIcon(imerq); rbz[qr].setRolloverIcon(imerq);}
			}
			
		}
		
}

	
	
	
	

class otv implements ActionListener{

public void actionPerformed(ActionEvent e) {	

	pnm.setBackground(Color.BLACK);
	if ( rs == Vuub ){fcpr(0);} else {fcpr(1);}	
		next.setEnabled(true);
			rbz[0].setEnabled(false);
			rbz[1].setEnabled(false);
			rbz[2].setEnabled(false);
			rbz[3].setEnabled(false);
			otvet.setEnabled(false);

	}
	
}
	

public void fcpr(int bc){

	pravv = new ImageIcon(getClass().getResource("img/Game/Prav.png"));
	pravv = new ImageIcon(pravv.getImage().getScaledInstance(Screen.szs(0, 312), Screen.szs(1, 58), Image.SCALE_SMOOTH));
	
	npravv = new ImageIcon(getClass().getResource("img/Game/nPrav.png"));
	npravv = new ImageIcon(npravv.getImage().getScaledInstance(Screen.szs(0, 312), Screen.szs(1, 58), Image.SCALE_SMOOTH));
	
	if (vbr == 0){
		rs1 = (int) (Math.random()*facts.size());
	} else if ( vbr == 1 || vbr == 2 || vbr == 3){
		rs1 = mainnum;
	}
	
	System.out.println("OPAOOAPAPPA " + facts.get(rs1));
	pods = new ImageIcon(getClass().getResource(facts.get(rs1)));
	pods = new ImageIcon(pods.getImage().getScaledInstance(Screen.szs(0, 803), Screen.szs(1, 184), Image.SCALE_SMOOTH));
	
	cc1 = new ImageIcon(getClass().getResource(cc.get(mainnum)));
	cc1 = new ImageIcon(cc1.getImage().getScaledInstance(Screen.szs(0, 803), Screen.szs(1, 184), Image.SCALE_SMOOTH));
	
	
	
	
lbq = new JLabel();	
lbp = new JLabel();
	
	if (bc == 0){
	lbq.setIcon(pravv); lbq.setBounds(Screen.szs(0, 1500), Screen.szs(1, 721), Screen.szs(0, 312), Screen.szs(1, 58));	
	lbp.setIcon(pods); lbp.setBounds(Screen.szs(0, 85), Screen.szs(1, 830), Screen.szs(0, 803), Screen.szs(1, 184));}


	
	if (bc == 1){
	lbq.setIcon(npravv);  lbq.setBounds(Screen.szs(0, 1500), Screen.szs(1, 721), Screen.szs(0, 312), Screen.szs(1, 58));	
	lbp.setIcon(cc1); lbp.setBounds(Screen.szs(0, 85), Screen.szs(1, 830), Screen.szs(0, 803), Screen.szs(1, 184));
				}
	if ( vbr == 1 || vbr == 2){
	imj.remove(dr);
	drawUse(1);
	fr.repaint();}
	
pnm.add(lbq);
pnm.add(lbp);
}










   




class nxt implements ActionListener{

public void actionPerformed(ActionEvent e) {	
		lp.remove(pnm);
		lp.remove(imj);
		Gamestarting.strt();
	
	
	}
	
}
	
	
	
	
	
	
	
	
	


}
