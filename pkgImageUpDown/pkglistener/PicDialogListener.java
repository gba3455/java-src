package pkgImageUpDown.pkglistener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import pkgImageUpDown.pkgdialog.PicDialog;
import pkgImageUpDown.pkgdialog.PosDialog;
import pkgImageUpDown.pkgframe.MainFrame;
import pkgImageUpDown.pkgtools.StaticTools;
import pkgImageUpDown.pkgtools.UploadImage;

public class PicDialogListener implements ActionListener{
	private MainFrame mainFrame;
	private PicDialog picDialog;
	private PosDialog posDialog;
	
	private JButton buttonRed = null;
	private JButton buttonYellow = null;
	private JButton buttonBlue = null;
	private JButton buttonGreen = null;
	private JButton buttonBlack = null;
	private JButton buttonWhite = null;
	
	private JButton buttonLine = null;
	private JButton buttonRect = null;
	private JButton buttonCircle = null;
	private JButton buttonText = null;
	
	private static Map<String,Color> colorMap;
	
	public PicDialogListener(MainFrame mainFrame,PicDialog picDialog,PosDialog posDialog) {
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
		if(e.getSource() == picDialog.getButtonEdit()){
			picDialog.getBoxEdit().remove(picDialog.getButtonEdit());
			
			Map<String,JButton> buttonColorMap = new HashMap<String,JButton>();
			buttonColorMap.put("red",buttonRed);
			buttonColorMap.put("yellow",buttonYellow);
			buttonColorMap.put("blue",buttonBlue);
			buttonColorMap.put("green",buttonGreen);
			buttonColorMap.put("black",buttonBlack);
			buttonColorMap.put("white",buttonWhite);
			
			colorMap = new HashMap<String, Color>();
			colorMap.put("red",Color.red);
			colorMap.put("yellow",Color.yellow);
			colorMap.put("blue",Color.blue);
			colorMap.put("green",Color.green);
			colorMap.put("black",Color.black);
			colorMap.put("white",Color.white);
			
			Map<String,JButton> buttonLineTypeMap = new HashMap<String, JButton>();
			buttonLineTypeMap.put("line", buttonLine);
			buttonLineTypeMap.put("rect", buttonRect);
			buttonLineTypeMap.put("crcl", buttonCircle);
			buttonLineTypeMap.put("text", buttonText);
			
			for(final Entry<String, JButton> bcm : buttonColorMap.entrySet()){
				JButton jb = bcm.getValue();
				jb = new JButton();
				jb.setPreferredSize(new Dimension(20,20));
				ImageIcon iconColor = new ImageIcon("src/pkgImageUpDown/image/" + bcm.getKey() + ".png");
				jb.setIcon(iconColor);
				jb.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						StaticTools.lineColor = colorMap.get(bcm.getKey());
						System.out.println(StaticTools.lineColor);
					}
				});
				bcm.setValue(jb);
			}
			
			for(final Entry<String,JButton> bltm : buttonLineTypeMap.entrySet()){
				JButton jb = bltm.getValue();
				jb = new JButton(bltm.getKey());
				jb.setPreferredSize(new Dimension(40,20));
				jb.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						StaticTools.lineType = bltm.getKey();
					}
				});
				bltm.setValue(jb);
			}
			Box box = Box.createVerticalBox();
			box.add(Box.createHorizontalStrut(50));
			
			Box boxColor = Box.createHorizontalBox();
			for(Entry<String, JButton> bcm : buttonColorMap.entrySet()){
				boxColor.add(bcm.getValue());
			}
			
			box.add(boxColor);
			
			Box boxType = Box.createHorizontalBox();
			for(Entry<String, JButton> bltm : buttonLineTypeMap.entrySet()){
				boxType.add(bltm.getValue());
			}
			
			box.add(boxType);
			
			picDialog.getBoxEdit().add(box);
			
			picDialog.setVisible(true);
		}
	}

}
