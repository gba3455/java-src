package pkgImageUpDown.pkgdialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pkgImageUpDown.pkgframe.MainFrame;
import pkgImageUpDown.pkglistener.PicDialogListener;
import pkgImageUpDown.pkgtools.Cam;
import pkgImageUpDown.pkgtools.StaticTools;


public class PicDialog extends JDialog{
	private JLabel jImageLabel;
	private JPanel mainPanel;
	private JButton buttonY;
	private JButton buttonN;
	private ImageIcon image;
	private ImageIcon subImage;
	private Point start;
	private Point end;
	PicDialogListener pl = null;
	Cam cam ;
	Graphics g;
	MainFrame mainFrame = null;
	PosDialog posDialog = new PosDialog(mainFrame);
	public PicDialog(final MainFrame mainFrame){
		this.mainFrame = mainFrame;
		init();
		rePaint();
		this.setTitle("キャプチャー");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		if(StaticTools.isFirstPoint){
			this.pack();
			this.addMouseMotionListener(new MouseMotionListener() {
				@Override
				public void mouseMoved(MouseEvent e) {
//					repaint();
				}
				@Override
				public void mouseDragged(MouseEvent e) {
					if(StaticTools.isFirstPoint){
						start.x = e.getX();
						StaticTools.x1 = e.getX();
						posDialog.getLabel_x1().setText("x1:" + start.x + "");
						start.y = e.getY();
						StaticTools.y1 = e.getY();
						posDialog.getLabel_y1().setText("y1:" + start.y + "");
						System.out.println(start.x + "." + start.y);
						repaint();
						StaticTools.isFirstPoint = false;
					}else{
						end.x = e.getX();
						StaticTools.x2 = e.getX();
						posDialog.getLabel_x2().setText("x2:" + end.x + "");
						end.y = e.getY();
						StaticTools.y2 = e.getY();
						posDialog.getLabel_y2().setText("y2:" + end.y + "");
						System.out.println(end.x + "." + end.y);
						repaint();
					}
				}
			});
			this.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {
//					cam.snapShot();
//					rePaint();
					start.x = 0;
					start.y = 0;
					end.x = 0;
					end.y = 0;
		        	repaint();
					new PicDialog(mainFrame);
				}
				@Override
				public void mousePressed(MouseEvent e) {
//					repaint();
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
			});
		}else{
			this.setTitle("これでよろしいですか？");
			BufferedImage bufI = null;
			try {
				bufI = ImageIO.read(new FileInputStream(new File(StaticTools.imageMap.get(StaticTools.serialNum))));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
			System.out.println(bufI.getWidth() + "宽高" + bufI.getHeight());
			this.setSize(new Dimension(bufI.getWidth(), bufI.getHeight() + 40));
		}
//		if(StaticTools.isFirstPoint){
//			
//		}
		this.setVisible(true);
//		posDialog = new PosDialog(mainFrame);
	}
	public void paint(Graphics g) {
		super.paint(g);
//		int x = Math.min(StaticTools.x1, StaticTools.x2);
//		int y = Math.min(StaticTools.y1, StaticTools.y2);
//		int width = Math.abs(StaticTools.x2 - StaticTools.x1) + 1;
//		int height = Math.abs(StaticTools.y2 - StaticTools.y1) + 1;
		int x = Math.min(start.x, end.x);
		int y = Math.min(start.y, end.y);
		int width = Math.abs(end.x - start.x) + 1;
		int height = Math.abs(end.y - start.y) + 1;
		g.setColor(Color.BLUE);
		g.drawRect(x - 1, y - 1, width + 1, height + 1);
//		g.drawRect(start.x, start.y, Math.abs(start.x - end.x), Math.abs(start.y - end.y));
	}
	private void init() {
		start = new Point();
		end = new Point();
		jImageLabel = new JLabel();
		mainPanel = new JPanel();
		if(!StaticTools.isFirstPoint){
			mainPanel = new JPanel(new BorderLayout());
			pl = new PicDialogListener(this,posDialog,mainFrame);
			buttonY = new JButton("はい");
			buttonY.addActionListener(pl);
			buttonN = new JButton("いいえ");
			buttonN.addActionListener(pl);
			Box box = Box.createHorizontalBox();
			box.add(buttonY);
			box.add(Box.createHorizontalGlue());
			box.add(buttonN);
			mainPanel.add(box,BorderLayout.SOUTH);
		}
		mainPanel.add(jImageLabel);
		this.add(mainPanel);
	}
	public JButton getButtonY() {
		return buttonY;
	}

	public JButton getButtonN() {
		return buttonN;
	}

	private void rePaint(){
		cam = new Cam();
		cam.snapShot();
		if(StaticTools.isFirstPoint){
			if(StaticTools.downloadFlag){
				System.out.println(StaticTools.Path + StaticTools.tubeDownloadMap.get(0));
				image = new ImageIcon(StaticTools.Path + StaticTools.tubeDownloadMap.get(0));
			}else{
				image = new ImageIcon(StaticTools.imagePath);
			}
			jImageLabel.setIcon(image);
		}else{
			System.out.println(StaticTools.serialNum);
			subImage = new ImageIcon(StaticTools.imageMap.get(StaticTools.serialNum));
			jImageLabel.setIcon(subImage);
			System.out.println("子图片:" + StaticTools.imageMap.get(StaticTools.serialNum));
		}
	}
	
	public static void main(String[] args) {
		new PicDialog(null);
	}
}
