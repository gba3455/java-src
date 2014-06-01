package pkgmine.dialog;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import pkgmine.frame.MainFrame;
import pkgmine.listener.ButtonListener;
import pkgmine.tools.StaticTools;

public class NameDialog extends JDialog{
	private JTextField field;
	private JLabel jLabel;
	private JButton buttonY;
	private JButton buttonN;
	private JPanel jPanel;
	private Box box1;
	private Box box2;
	private Box box3;
	MainFrame mainFrame;
	public NameDialog(int level,MainFrame mainFrame){
		super(mainFrame);
		this.mainFrame = mainFrame;
		this.add(getPanel(level));
		this.setTitle("名前を入力して下さい");
		this.setSize(new Dimension(220,150));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(mainFrame);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
	}

	private void initLabel(int level){
//		jLabel = new JLabel();
//		if(StaticTools.allMineCount == 10 || StaticTools.allMineCount == 40 || StaticTools.allMineCount == 99){
//			jLabel.setText("おめでとう～名前を入力して下さい");
//		}
		jLabel = new JLabel();
		if(level == 1 &&StaticTools.allMineCount == 10){
			jLabel.setText("初級クリア！おめでとう～");
		}else if(level == 2 && StaticTools.allMineCount == 40){
			jLabel.setText("中級クリア！おめでとう～");
		}else if(level == 3 && StaticTools.allMineCount == 99){
			jLabel.setText("高級クリアおめでとう～");
		}else{
			jLabel.setText("クリア！おめでとう～");
		}
	}
	
	private JPanel getPanel(int level){
		initLabel(level);
		jPanel = new JPanel();
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
		field = new JTextField("匿名");
		field.setPreferredSize(new Dimension(20,10));
		ButtonListener buttonListener = new ButtonListener(this);
		buttonY = new JButton("はい");
		buttonY.addActionListener(buttonListener);
		buttonN = new JButton("いいえ");
		buttonN.addActionListener(buttonListener);
		box1 = Box.createHorizontalBox();
		box1.add(jLabel);
		box2 = Box.createHorizontalBox();
		box2.add(Box.createHorizontalStrut(30));
		box2.add(field);
		box2.add(Box.createHorizontalStrut(30));
		box3 = Box.createHorizontalBox();
		box3.add(buttonY);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(buttonN);
		jPanel.add(box1);
		jPanel.add(Box.createVerticalStrut(13));
		jPanel.add(box2);
		jPanel.add(Box.createVerticalStrut(13));
		jPanel.add(box3);
		Border border = BorderFactory.createEmptyBorder(15, 5, 10, 5);
		jPanel.setBorder(border);
		return jPanel;
	}
	
	public JTextField getField() {
		return field;
	}

	public JButton getButtonY() {
		return buttonY;
	}

	public JButton getButtonN() {
		return buttonN;
	}

	public static void main(String[] args) {
//		new NameDialog(1);
//		String value = JOptionPane.showInputDialog(null,"enter");
//		System.out.println(value);
	}
}
