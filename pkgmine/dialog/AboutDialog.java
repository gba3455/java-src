package pkgmine.dialog;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import pkgmine.frame.MainFrame;
import pkgmine.tools.StaticTools;

public class AboutDialog extends JDialog{
	private JLabel iconMine;
	private JLabel iconflag;
	private JLabel jTitle;
	private JLabel jAuthor;
	private JButton buttonY;
	private JLabel jTime;
	private JPanel jPanel;
	private JPanel panelIn;
	private JPanel panelBtn;
	private AboutDialog ad;
	private MainFrame mainFrame;
	public AboutDialog(MainFrame mainFrame) {
		super(mainFrame);
		this.mainFrame = mainFrame;
		ad = this;
		Border border = BorderFactory.createEmptyBorder(5, 15, 5, 5);
		this.setTitle("About");
		this.add(getPanel());
		this.setSize(new Dimension(300,150));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(mainFrame);
		this.setResizable(false);
		this.pack();
		this.setModal(true);
		this.setVisible(true);
	}
	
	private JPanel getPanel(){
		iconMine = new JLabel();
		iconflag = new JLabel();
		jPanel = new JPanel();
		panelBtn = new JPanel();
		panelIn = new JPanel();
		iconMine.setIcon(StaticTools.mineIcon);
		iconflag.setIcon(StaticTools.flagIcon);
		jTitle = new JLabel("Java Mine ver.リクルート");
		jAuthor = new JLabel("作者：周吉　シュウキチ");
		jTime = new JLabel("作成時間：2014.4.20");
		buttonY = new JButton("はい");
		buttonY.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ad.dispose();
			}
		});
		
		Border border = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border border1 = BorderFactory.createEtchedBorder();
		
		
		Box boxUp = Box.createHorizontalBox();
		boxUp.add(iconMine);
		boxUp.add(jTitle);
		boxUp.add(iconflag);
		
		Box boxMi1 = Box.createHorizontalBox();
		boxMi1.add(jAuthor);
		Box boxMi2 = Box.createHorizontalBox();
		boxMi2.add(jTime);
		
		Box box = Box.createVerticalBox();
		box.add(boxUp);
		box.add(Box.createVerticalGlue());
		box.add(boxMi1);
		box.add(boxMi2);
		
		panelIn.setLayout(new BoxLayout(panelIn, BoxLayout.Y_AXIS));
		panelIn.add(box);
		panelBtn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelBtn.add(buttonY);
		panelIn.setBorder(border1);
		jPanel.setLayout(new FlowLayout());
		panelIn.add(panelBtn);
		jPanel.add(panelIn);
		jPanel.setBorder(border);
		return jPanel;
	}
}
