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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import pkgImageUpDown.pkglistener.PicDlgMouseListener;
import pkgImageUpDown.pkglistener.PicDlgMouseMotionListener;
import pkgImageUpDown.pkgtools.Cam;
import pkgImageUpDown.pkgtools.StaticTools;

public class PicDialog extends JDialog {
	private JLabel jImageLabel;
	private JPanel mainPanel;
	private JButton buttonY;
	private JButton buttonN;
	private JButton buttonEdit;
	private Box boxEdit;
	private ImageIcon image;
	private ImageIcon subImage;
	private Point start;
	private Point end;
	
	Cam cam;
	Graphics g;
	MainFrame mainFrame = null;
	PosDialog posDialog = new PosDialog(mainFrame);

	public JLabel getjImageLabel() {
		return jImageLabel;
	}

	public void setjImageLabel(JLabel jImageLabel) {
		this.jImageLabel = jImageLabel;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public ImageIcon getSubImage() {
		return subImage;
	}

	public void setSubImage(ImageIcon subImage) {
		this.subImage = subImage;
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public Cam getCam() {
		return cam;
	}

	public void setCam(Cam cam) {
		this.cam = cam;
	}

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public PosDialog getPosDialog() {
		return posDialog;
	}

	public void setPosDialog(PosDialog posDialog) {
		this.posDialog = posDialog;
	}

	public void setButtonY(JButton buttonY) {
		this.buttonY = buttonY;
	}

	public void setButtonN(JButton buttonN) {
		this.buttonN = buttonN;
	}

	public void setButtonEdit(JButton buttonEdit) {
		this.buttonEdit = buttonEdit;
	}

	public void setBoxEdit(Box boxEdit) {
		this.boxEdit = boxEdit;
	}

	public PicDialog(final MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		init();
		rePaint();
		this.setTitle("キャプチャー");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		if (StaticTools.isFirstPoint) {
//			if (StaticTools.downloadFlag == false) {
				 this.addMouseMotionListener(new PicDlgMouseMotionListener(this.mainFrame,
							this, posDialog));
				 this.addMouseListener(new PicDlgMouseListener(this.mainFrame, this,
							posDialog));
//			} 
//			else {
//				this.addMouseMotionListener(new MouseMotionListener() {
//					@Override
//					public void mouseMoved(MouseEvent e) {
//						// repaint();
//					}
//					@Override
//					public void mouseDragged(MouseEvent e) {
//						if (StaticTools.isFirstPoint) {
//							start.x = e.getX();
//							StaticTools.x1 = e.getX();
//							posDialog.getLabel_x1().setText(
//									"x1:" + start.x + "");
//							start.y = e.getY();
//							StaticTools.y1 = e.getY();
//							posDialog.getLabel_y1().setText(
//									"y1:" + start.y + "");
//							System.out.println(start.x + "." + start.y);
//							repaint();
//							StaticTools.isFirstPoint = false;
//						} else {
//							end.x = e.getX();
//							StaticTools.x2 = e.getX();
//							posDialog.getLabel_x2().setText("x2:" + end.x + "");
//							end.y = e.getY();
//							StaticTools.y2 = e.getY();
//							posDialog.getLabel_y2().setText("y2:" + end.y + "");
//							System.out.println(end.x + "." + end.y);
//							repaint();
//						}
//					}
//				});
//				this.addMouseListener(new MouseListener() {
//					@Override
//					public void mouseReleased(MouseEvent e) {
//						// cam.snapShot();
//						// rePaint();
//						start.x = 0;
//						start.y = 0;
//						end.x = 0;
//						end.y = 0;
//						repaint();
//						StaticTools.isFirstPoint = true;
////						new PicDialog(mainFrame);
//					}
//
//					@Override
//					public void mousePressed(MouseEvent e) {
//						// repaint();
//					}
//
//					@Override
//					public void mouseExited(MouseEvent e) {
//					}
//
//					@Override
//					public void mouseEntered(MouseEvent e) {
//					}
//
//					@Override
//					public void mouseClicked(MouseEvent e) {
//					}
//				});
//			}
		} else {
			this.setTitle("これでよろしいですか？");
			BufferedImage bufI = null;
			try {
				bufI = ImageIO.read(new FileInputStream(new File(
						StaticTools.imageMap.get(StaticTools.serialNum))));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out.println(bufI.getWidth() + "宽高" + bufI.getHeight());
			this.setSize(new Dimension(bufI.getWidth(), bufI.getHeight() + 40));
		}
//		if (StaticTools.isFirstPoint) {
//			this.addMouseMotionListener(new MouseMotionListener() {
//				@Override
//				public void mouseMoved(MouseEvent e) {
//					// repaint();
//				}
//				@Override
//				public void mouseDragged(MouseEvent e) {
//					if (StaticTools.isFirstPoint) {
//						start.x = e.getX();
//						StaticTools.x1 = e.getX();
//						posDialog.getLabel_x1().setText("x1:" + start.x + "");
//						start.y = e.getY();
//						StaticTools.y1 = e.getY();
//						posDialog.getLabel_y1().setText("y1:" + start.y + "");
//						System.out.println(start.x + "." + start.y);
//						repaint();
//						StaticTools.isFirstPoint = false;
//					} else {
//						end.x = e.getX();
//						StaticTools.x2 = e.getX();
//						posDialog.getLabel_x2().setText("x2:" + end.x + "");
//						end.y = e.getY();
//						StaticTools.y2 = e.getY();
//						posDialog.getLabel_y2().setText("y2:" + end.y + "");
//						System.out.println(end.x + "." + end.y);
//						repaint();
//					}
//				}
//			});
//			this.addMouseListener(new MouseListener() {
//				@Override
//				public void mouseReleased(MouseEvent e) {
//					// cam.snapShot();
//					// rePaint();
//					start.x = 0;
//					start.y = 0;
//					end.x = 0;
//					end.y = 0;
//					repaint();
//					new PicDialog(mainFrame);
//				}
//				@Override
//				public void mousePressed(MouseEvent e) {
//					// repaint();
//				}
//				@Override
//				public void mouseExited(MouseEvent e) {
//				}
//				@Override
//				public void mouseEntered(MouseEvent e) {
//				}
//				@Override
//				public void mouseClicked(MouseEvent e) {
//				}
//			});
//		}
		this.pack();
		this.setVisible(true);
		// posDialog = new PosDialog(mainFrame);
	}

	public void paint(Graphics g) {
		super.paint(g);
//		if (StaticTools.downloadFlag == false) {
		int x = Math.min(start.x, end.x);
		int y = Math.min(start.y, end.y);
		int width = Math.abs(end.x - start.x) + 1;
		int height = Math.abs(end.y - start.y) + 1;
		g.setColor(StaticTools.lineColor);
		g.drawRect(x - 1, y - 1, width + 1, height + 1);
//		}else{
//			g.setColor(StaticTools.lineColor);
//			switch(StaticTools.lineType){
//			case "line":
//					g.drawLine(start.x, start.y, end.x, end.y);
//				break;
//			}
//		}
		// g.drawRect(start.x, start.y, Math.abs(start.x - end.x),
		// Math.abs(start.y - end.y));
	}

	private void init() {
		start = new Point();
		end = new Point();
		jImageLabel = new JLabel();
		mainPanel = new JPanel();
		PicDialogListener pl = new PicDialogListener(mainFrame, this, posDialog);
		if (StaticTools.isFirstPoint) {
			mainPanel.add(jImageLabel);
			this.add(mainPanel);
		}else{
			mainPanel = new JPanel(new BorderLayout());
			buttonY = new JButton("はい");
			buttonY.addActionListener(pl);
			buttonN = new JButton("いいえ");
			buttonN.addActionListener(pl);
			Box box = Box.createHorizontalBox();
			box.add(buttonY);
			box.add(Box.createHorizontalGlue());
			box.add(buttonN);
			mainPanel.add(jImageLabel,BorderLayout.CENTER);
			mainPanel.add(box, BorderLayout.SOUTH);
			this.add(mainPanel);
		}
//		if (StaticTools.downloadFlag) {
//			buttonEdit = new JButton("コメントしますか？");
//			buttonEdit.addActionListener(pl);
//			boxEdit = Box.createHorizontalBox();
//			boxEdit.add(jImageLabel);
//			boxEdit.add(buttonEdit);
//			mainPanel.add(boxEdit);
//			this.add(mainPanel);
//		}

	}

	public JButton getButtonY() {
		return buttonY;
	}

	public JButton getButtonN() {
		return buttonN;
	}

	public JButton getButtonEdit() {
		return buttonEdit;
	}

	public Box getBoxEdit() {
		return boxEdit;
	}

	private void rePaint() {
		cam = new Cam();
		cam.snapShot();
		if (StaticTools.isFirstPoint) {
			if (StaticTools.downloadFlag) {
				System.out.println("准备下载" + StaticTools.Path
						+ StaticTools.tubeDownloadMap.get(0));
				image = new ImageIcon(StaticTools.Path
						+ StaticTools.tubeDownloadMap.get(0));
			} else {
				image = new ImageIcon(StaticTools.imagePath);
			}
			jImageLabel.setIcon(image);
		} else {
			System.out.println(StaticTools.serialNum);
			subImage = new ImageIcon(
					StaticTools.imageMap.get(StaticTools.serialNum));
			jImageLabel.setIcon(subImage);
			System.out.println("子图片:"
					+ StaticTools.imageMap.get(StaticTools.serialNum));
		}
	}
}
