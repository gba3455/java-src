package pkgImageUpDown.pkglistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import pkgImageUpDown.pkgdialog.PicDialog;
import pkgImageUpDown.pkgdialog.PosDialog;
import pkgImageUpDown.pkgframe.MainFrame;
import pkgImageUpDown.pkgtools.StaticTools;
import pkgImageUpDown.pkgtools.UploadImage;

public class PicDialogListener implements ActionListener{
	private PicDialog picDialog = null;
	private MainFrame mainFrame = null;
	private PosDialog posDialog = null;
	public PicDialogListener(PicDialog picDialog,PosDialog posDialog,MainFrame mainFrame) {
		this.picDialog = picDialog;
		this.posDialog = posDialog;
		this.mainFrame = mainFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == picDialog.getButtonN()){
			StaticTools.isFirstPoint = true;
			File f = new File(StaticTools.imagePath);
			File f1 = new File(StaticTools.imageMap.get(StaticTools.serialNum));
			f.delete();
			f1.delete();
			StaticTools.imageMap.remove(StaticTools.serialNum);
//			new PicDialog(mainFrame);
//			posDialog.setVisible(false);
//			posDialog.dispose();
			picDialog.setVisible(false);
//			picDialog.dispose();
		}
		if(e.getSource() == picDialog.getButtonY()){
			mainFrame.setVisible(true);
			posDialog.setVisible(false);
//			posDialog.dispose();
			picDialog.setVisible(false);
//			picDialog.dispose();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					UploadImage uploadImage = new UploadImage(mainFrame);
					String subName = StaticTools.imageMap.get(StaticTools.serialNum);
					uploadImage.uploadImageByCommonFtpSe(new File(StaticTools.imageMap.get(StaticTools.serialNum)),"/image/" + subName.substring(subName.lastIndexOf("/")));
					}
			}).start();
			}
	}

}
