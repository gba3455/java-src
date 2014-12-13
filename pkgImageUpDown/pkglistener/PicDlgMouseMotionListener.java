package pkgImageUpDown.pkglistener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import pkgImageUpDown.pkgdialog.PicDialog;
import pkgImageUpDown.pkgdialog.PosDialog;
import pkgImageUpDown.pkgframe.MainFrame;
import pkgImageUpDown.pkgtools.StaticTools;

public class PicDlgMouseMotionListener implements MouseMotionListener{
	private MainFrame mainFrame;
	private PicDialog picDialog;
	private PosDialog posDialog;
	public PicDlgMouseMotionListener(MainFrame mainFrame,PicDialog picDialog,PosDialog posDialog) {
		this.mainFrame = mainFrame;
		this.picDialog = picDialog;
		this.posDialog = posDialog;
	}
	@Override
	public void mouseMoved(MouseEvent e) {
//		repaint();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		if(StaticTools.isFirstPoint){
			picDialog.getStart().x = e.getX();
			StaticTools.x1 = e.getX();
			posDialog.getLabel_x1().setText("x1:" + picDialog.getStart().x + "");
			picDialog.getStart().y = e.getY();
			StaticTools.y1 = e.getY();
			posDialog.getLabel_y1().setText("y1:" + picDialog.getStart().y + "");
			System.out.println(picDialog.getStart().x + "." + picDialog.getStart().y);
			picDialog.repaint();
			StaticTools.isFirstPoint = false;
		}else{
			picDialog.getEnd().x = e.getX();
			StaticTools.x2 = e.getX();
			posDialog.getLabel_x2().setText("x2:" + picDialog.getEnd().x + "");
			picDialog.getEnd().y = e.getY();
			StaticTools.y2 = e.getY();
			posDialog.getLabel_y2().setText("y2:" + picDialog.getEnd().y + "");
			System.out.println(picDialog.getEnd().x + "." + picDialog.getEnd().y);
			picDialog.repaint();
		}
	}
}

