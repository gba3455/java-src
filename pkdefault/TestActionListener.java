package pkdefault;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class TestActionListener implements ActionListener{
	JFrame frame = null;
	public TestActionListener(JFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		new Test().getDlg();
	}

}
