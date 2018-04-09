import javax.swing.JFrame;

public class MainStart {
  
	static JFrame fr;
	static Menu tst;
    
    public static void main(String[] args) {
        tst = new Menu();
        tst.setVisible(true);
    }
    
    public static void gamestart(JFrame d, int z){
    	fr = d;
    	tst = null;
    	new Gamestarting(fr,z);
    }
}
