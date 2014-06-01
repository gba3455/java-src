package pkgImageUpDown.pkglistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import pkgImageUpDown.pkgdialog.PicDialog;
import pkgImageUpDown.pkgdialog.PosDialog;
import pkgImageUpDown.pkgframe.MainFrame;
import pkgImageUpDown.pkgtools.Cam;
import pkgImageUpDown.pkgtools.StaticTools;

public class ButtonListener implements ActionListener{
	private MainFrame mainFrame;
	public ButtonListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mainFrame.getjButton()){
			mainFrame.setVisible(false);
			new PicDialog(mainFrame);
		}
		if(e.getSource() == mainFrame.getjButton_Open()){
			StaticTools.downloadFlag = true;
			mainFrame.setVisible(false);
			new PicDialog(mainFrame);
		}
	}

}
