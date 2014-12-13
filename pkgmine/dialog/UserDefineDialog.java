package pkgmine.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import pkgmine.frame.MainFrame;
import pkgmine.listener.UserDefineListener;
import pkgmine.tools.StaticTools;

public class UserDefineDialog extends JDialog{
	private JLabel jMsg = new JLabel();
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JTextField jTextField3;
	private JPanel panel;
	private JButton buttonY;
	private JButton buttonN;
	MainFrame mainFrame = null;
	UserDefineListener userDefineListener = null;
	
	public UserDefineDialog(MainFrame frame) {
		super(frame);
		this.mainFrame = frame; 
		jMsg.setForeground(Color.red);
		this.setTitle("カスタマイズ");
		this.add(getPanel());
		this.add(jMsg,BorderLayout.NORTH);
		this.setSize(new Dimension(200,150));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(mainFrame);
		this.setResizable(false);
		this.setModal(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				mainFrame.reStartGame();
			}
		});
		this.setVisible(true);
	}
	
	public JPanel getPanel(){
		JPanel jp = new JPanel();
		Border border = BorderFactory.createEmptyBorder(5, 20, 5, 5);
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		Box boxH = Box.createHorizontalBox();
		jTextField1 = new JTextField(StaticTools.allRows + "");
		jTextField1.setPreferredSize(new Dimension(30,20));
		jTextField1.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				typeCheck(e);
			}

			
			@Override
			public void keyReleased(KeyEvent e) {
				numCheck(jTextField1);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		boxH.add(new JLabel("幅さ"));
		boxH.add(jTextField1);
		Box boxW = Box.createHorizontalBox();
		jTextField2 = new JTextField(StaticTools.allCols + "");
		jTextField2.setPreferredSize(new Dimension(30,20));
		jTextField2.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				typeCheck(e);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				numCheck(jTextField2);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		boxW.add(new JLabel("高さ"));
		boxW.add(jTextField2);
		Box boxB = Box.createHorizontalBox();
		jTextField3 = new JTextField(StaticTools.allMineCount + "");
		jTextField3.setPreferredSize(new Dimension(30,20));
		jTextField3.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				typeCheck(e);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				numCheck(jTextField3);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		boxB.add(new JLabel("地塁"));
		boxB.add(jTextField3);
		
		Box boxS = Box.createVerticalBox();
		boxS.add(boxH);
		boxS.add(Box.createVerticalStrut(8));
		boxS.add(boxW);
		boxS.add(Box.createVerticalStrut(8));
		boxS.add(boxB);
		boxS.setBorder(border);
		Box boxT = Box.createVerticalBox();
		userDefineListener = new UserDefineListener(this,mainFrame);
		buttonY = new JButton("はい");
		buttonY.addActionListener(userDefineListener);
		buttonY.setPreferredSize(new Dimension(70,30));
		buttonY.setMargin(new Insets(0, 2, 0, 2));
		buttonN = new JButton("いいえ");
		buttonN.addActionListener(userDefineListener);
		buttonN.setPreferredSize(new Dimension(70,30));
		buttonN.setMargin(new Insets(0, 2, 0, 2));
		boxT.add(buttonY);
		boxT.add(Box.createVerticalStrut(25));
		boxT.add(buttonN);
		boxT.setBorder(border);
		panel.add(boxS);
		panel.add(boxT);
		Border border2 = BorderFactory.createEmptyBorder(3, 15, 5, 15);
		jp.setBorder(border2);
		jp.add(panel);
		return jp;
	}

	private void numCheck(JTextField field) {
		JTextField jTextField = new JTextField();
		jTextField = field;
		String text = jTextField.getText();
		Pattern pattern = Pattern.compile("^[0-9]{0,1}$");
		Matcher matcher = pattern.matcher(text);
		if(!matcher.matches()){
			if(text.length() > 2){
				jMsg.setText("桁オーバー");
				jTextField.setText(text.substring(0, 2));
				return;
			}
			else{
			if(jTextField == jTextField3){
				int mine = Integer.parseInt(jTextField3.getText());
				int castMine = StaticTools.allRows * StaticTools.allCols * 4/5;
				if(mine < 9){
					mine = 10;
				}else if(mine > castMine){
					jMsg.setText("数字オーバー(9~" + castMine + ")");
				}else{
					jMsg.setText(" ");
				}
			}else{
				int height = Integer.parseInt(text);
				if(height < 9 || height > 30){
					jMsg.setText("数字オーバー(9~30)");
					jTextField.setText(text.substring(0, 2));
					return;
				}
			}
		}
		}
	}

	private void typeCheck(KeyEvent e) {
		char ch = e.getKeyChar();
		if((ch < '0') || (ch > '9')){
			jMsg.setText("数字だけ入力可能");
			e.setKeyChar((char) 8);//backspace
		}else{
			jMsg.setText(" ");
		}
	}
	
	public JTextField getjTextField1() {
		return jTextField1;
	}

	public JTextField getjTextField2() {
		return jTextField2;
	}

	public JTextField getjTextField3() {
		return jTextField3;
	}
	public JLabel getjMsg() {
		return jMsg;
	}

	public JButton getButtonY() {
		return buttonY;
	}

	public JButton getButtonN() {
		return buttonN;
	}
}
