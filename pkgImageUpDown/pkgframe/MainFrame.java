package pkgImageUpDown.pkgframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pkgImageUpDown.pkgdialog.PicDialog;
import pkgImageUpDown.pkgdialog.PosDialog;
import pkgImageUpDown.pkglistener.ButtonListener;
import pkgImageUpDown.pkgtools.DownloadImage;
import pkgImageUpDown.pkgtools.StaticTools;
import pkgutil.DateUtil;

public class MainFrame extends JFrame{
	private JLabel jStatus;
	private JLabel jStatusText;
	private JPanel mainPanel;
	private ImageIcon image;
	private JButton jButton;
	private JButton jButton_Open;
	public JButton getjButton_Open() {
		return jButton_Open;
	}

	private PicDialog picDialog = null;
	private PosDialog posDialog = null;
	public PicDialog getPicDialog() {
		return picDialog;
	}

	public PosDialog getPosDialog() {
		return posDialog;
	}

	ButtonListener bl = null;
	public JButton getjButton() {
		return jButton;
	}

	public MainFrame(){
		init();
		this.setTitle("課題提出");
		this.setSize(new Dimension(500,100));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
//		this.pack();
		this.setVisible(true);
	}

	private void init() {
		bl = new ButtonListener(this);
		jButton = new JButton("画像を切り取る");
		jButton.addActionListener(bl);
		
		jButton_Open = new JButton("開く");
		jButton_Open.setVisible(false);
		jButton_Open.addActionListener(bl);
		
		jStatus = new JLabel("Status：");
		jStatusText = new JLabel();
		jStatusText.setForeground(Color.RED);
		
		Box StatusBox = Box.createHorizontalBox();
		StatusBox.add(jStatus);
		StatusBox.add(Box.createHorizontalGlue());
		StatusBox.add(jStatusText);
		
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(StatusBox,BorderLayout.NORTH);
		mainPanel.add(jButton,BorderLayout.CENTER);
		mainPanel.add(jButton_Open,BorderLayout.SOUTH);
		this.add(mainPanel);
	}

	public JLabel getjStatus() {
		return jStatus;
	}

	public JLabel getjStatusText() {
		return jStatusText;
	}

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		DownloadImage dli = new DownloadImage(mainFrame);
		dli.downloadImage();
//		File f = new File(StaticTools.imagePath + StaticTools.imageName);
//		File f2 = new File(StaticTools.imagePath + StaticTools.subImageName);
//		f.deleteOnExit();
//		f2.deleteOnExit();
	}
}
