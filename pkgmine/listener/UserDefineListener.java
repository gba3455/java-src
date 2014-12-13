package pkgmine.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pkgmine.dialog.UserDefineDialog;
import pkgmine.frame.MainFrame;
import pkgmine.tools.StaticTools;

public class UserDefineListener implements ActionListener{
	UserDefineDialog userDefineDialog;
	MainFrame mainFrame;
	public UserDefineListener(UserDefineDialog userDefineDialog,MainFrame mainFrame) {
		this.userDefineDialog = userDefineDialog;
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int row = 0;
		int col = 0;
		int mine = 0;
		if(e.getSource() == userDefineDialog.getButtonN()){
			userDefineDialog.setVisible(false);
			userDefineDialog.dispose();
			mainFrame.reStartGame();
		}
		else if(e.getSource() == userDefineDialog.getButtonY()){
			String rowText = userDefineDialog.getjTextField1().getText();
			Pattern pattern = Pattern.compile("^[0-9]{1,2}$");
			Matcher matcher = pattern.matcher(rowText);
			if(!matcher.matches()){
				userDefineDialog.getjMsg().setText("行数输入不合法");
				return;
			}else{
				row = Integer.parseInt(rowText);
				if(row < 9 || row > 30){
					userDefineDialog.getjMsg().setText("行数不合法 9-30");
					return;
				}
			}
			
			String colText = userDefineDialog.getjTextField2().getText();
			try {
				col = Integer.parseInt(colText);
				if(col < 9 || col > 30){
					userDefineDialog.getjMsg().setText("列数不合法 9-30");
				}
			} catch (Exception e2) {
				userDefineDialog.getjMsg().setText("列数应该为数字 9-30");
				return;
			}
			
			String mineText = userDefineDialog.getjTextField3().getText();
			try {
				mine = Integer.parseInt(mineText);
				if(mine < 10){
					mine = 10;
				}else{
					mine = Math.min(mine, StaticTools.allRows * StaticTools.allCols * 4/5);
				}
			} catch (Exception e2) {
				userDefineDialog.getjMsg().setText("雷数应该为数字 9-30");
				return;
			}
			StaticTools.allRows = row;
			StaticTools.allCols = col;
			StaticTools.allMineCount = mine;
			userDefineDialog.setVisible(false);
			userDefineDialog.dispose();
			mainFrame.reStartGame();
		}
	}

}
