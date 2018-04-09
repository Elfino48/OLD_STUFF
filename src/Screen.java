import java.awt.Dimension;
import java.awt.Toolkit;

public class Screen {
	static Dimension sSize = Toolkit.getDefaultToolkit ().getScreenSize ();
	static int H =(int) sSize.getHeight();
 	static int W =(int) sSize.getWidth();
	static double qq;
	
public static int szs(int x, int xx){
	if ( x == 0 ){
		qq = 1920 - xx;
		qq = qq/1920;
		qq = W*qq;
		qq = W - qq;
	} else {
		qq = 1080 - xx;
		qq = qq/1080;
		qq = H*qq;
		qq = H - qq;
	}
		
		
		


return (int) qq;

}


}
