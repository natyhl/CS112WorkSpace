
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class MyActions implements ActionListener {
	JPanel jp;
	JPanel jp2;
	boolean isPressed;
	Timer stopwatch;
	int r = 255;
	int g = 255;
	int b = 255;
	int x = 0;
	int y = 0;
	double colorChange;
	double positionChange;
	
	public MyActions(JPanel jpanel, boolean myIsPressed, JPanel jpanel2) {
		stopwatch = new Timer(100, this);
		stopwatch.setActionCommand("timer1");
		this.jp=jpanel;
		isPressed=myIsPressed;
		this.jp2=jpanel2;
	}
	public int randomRangeRandom(int start, int end) {
	    Random random = new Random();
	    int number = random.nextInt((end - start) + 1) + start; // see explanation below
	    return number;
	}


	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getActionCommand().equals("button1")) {
			if(isPressed) {
				stopwatch.stop();
				System.out.println(r+","+g+","+b+",");
				isPressed=false;
			}else{
				stopwatch.start();
				isPressed = true;
			}
		}
		if(e.getActionCommand().equals("timer1"))
			colorChange = Math.random();
			positionChange = Math.random();
		
			if(r>=235||g>=235||b>=235) {
				r -= randomRangeRandom(0,10);
				g -= randomRangeRandom(0,10);
				b -= randomRangeRandom(0,10); //random color change from: https://sentry.io/answers/random-ints/
			}else{
				if(colorChange<0.5&&!(r>=235||g>=235||b>=235)) {
					r += randomRangeRandom(0,10);
					g += randomRangeRandom(0,10);
					b += randomRangeRandom(0,10);
				}else if(!(r<=11||g<=11||b<=11)){
					r -= randomRangeRandom(0,10);
					g -= randomRangeRandom(0,10);
					b -= randomRangeRandom(0,10);	
				}
			}
			if(x>=680||y>=490) {
				x-=randomRangeRandom(0,20);
				y-=randomRangeRandom(0,10);
			}else {
				if(positionChange<0.5&&!(x>=680||y>=490)) {
					x+=randomRangeRandom(0,20);
					y+=randomRangeRandom(0,10);
				}else if(!(x<=21||y<=11)) {
					x-=randomRangeRandom(0,20);
					y-=randomRangeRandom(0,10);
				}
			}
			Color myColor = new Color(r, g, b);
			jp2.setBackground(myColor);
			Point p = new Point(x, y);
			jp2.setLocation(p);
	}
}
	
public class LavaLamp2 {

	static public void main(String[] args) {
		JFrame jf = new JFrame("LavaLamp2");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel jp = new JPanel();
		jp.setPreferredSize(new Dimension(700, 500));
		jp.setBackground(new Color(102, 204, 204));
		
		JPanel jp2 = new JPanel();
		jp2.setSize(new Dimension(300, 200));
		jp.setBackground(new Color(255, 255, 255));
		
		jp.setLayout(null);
		Point p = new Point(0, 0);
		jp2.setLocation(p); 
		jp.add(jp2);
		
		MyActions handler = new MyActions(jp, false, jp2);
		
		JButton jb = new JButton("Press me");
		jb.setActionCommand("button1");
		jp2.add(jb);
		jb.addActionListener(handler);


		jf.add(jp); // insert JPanel into JFrame
		jf.pack(); // set size of top-level window
		jf.setVisible(true);
	}
}

