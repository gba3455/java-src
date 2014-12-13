package pkgmine.timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pkgmine.frame.MainFrame;
import pkgmine.tools.StaticTools;

public class TimerActionListener implements ActionListener{
	MainFrame mainFrame;
	
	public TimerActionListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StaticTools.timeCount++;
		//Over 999
		if(StaticTools.timeCount > 999){
			StaticTools.timeCount = 999;
		}
		mainFrame.getFaceJpanel().setTime(StaticTools.timeCount);
	}

}
