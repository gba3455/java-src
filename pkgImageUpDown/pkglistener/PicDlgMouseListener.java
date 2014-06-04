package pkgImageUpDown.pkglistener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import pkgImageUpDown.pkgdialog.PicDialog;
import pkgImageUpDown.pkgdialog.PosDialog;
import pkgImageUpDown.pkgframe.MainFrame;

public class PicDlgMouseListener implements MouseListener{
	private MainFrame mainFrame;
	private PicDialog picDialog;
	private PosDialog posDialog;
	public PicDlgMouseListener(MainFrame mainFrame,PicDialog picDialog,PosDialog posDialog) {
		this.mainFrame = mainFrame;
		this.picDialog = picDialog;
		this.posDialog = posDialog;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
//		cam.snapShot();
//		rePaint();
		picDialog.getStart().x = 0;
		picDialog.getStart().y = 0;
		picDialog.getEnd().x = 0;
		picDialog.getEnd().y = 0;
		picDialog.repaint();
		new PicDialog(mainFrame);
	}
	@Override
	public void mousePressed(MouseEvent e) {
//		repaint();
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
}
