import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

class MyActions implements ActionListener {
	int count = 0;
	Timer timer;
	JPanel jp;
	boolean isPressed;
	Timer stopwatch;
	
	public MyActions(JPanel jpanel, boolean myIsPressed) {
		stopwatch = new Timer(100, this);
		stopwatch.setActionCommand("timer1");
		this.jp=jpanel;
		isPressed=myIsPressed;
	}

	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("button1")) {
			if(isPressed) {
				jp.setBackground(Color.GREEN);
				stopwatch.stop();
				isPressed=false;
			}else{
				jp.setBackground(Color.RED);
				stopwatch.start();
				isPressed = true;
			}
		}
		if(e.getActionCommand().equals("timer1"))
			System.out.println(++count);
	}
}
	
public class LavaLamp {

	static public void main(String[] args) {
		JFrame jf = new JFrame("LavaLamp");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel jp = new JPanel();
		jp.setPreferredSize(new Dimension(700, 500));
		jp.setBackground(new Color(240, 200, 40));
		
		
		MyActions handler = new MyActions(jp, false);
		
		JButton jb = new JButton("Press me");
		jb.setActionCommand("button1");
		jp.add(jb);
		jb.addActionListener(handler);


		jf.add(jp); // insert JPanel into JFrame
		jf.pack(); // set size of top-level window
		jf.setVisible(true);
	}
}
