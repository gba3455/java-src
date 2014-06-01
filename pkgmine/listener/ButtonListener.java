package pkgmine.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pkgmine.bean.HeroBean;
import pkgmine.dialog.NameDialog;
import pkgmine.tools.StaticTools;

public class ButtonListener implements ActionListener{
	NameDialog nameDialog = null;
	public ButtonListener(NameDialog nameDialog) {
		this.nameDialog = nameDialog;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nameDialog.getButtonY()){
			switch (StaticTools.getLevel()) {
			case 1:
				StaticTools.treeSetC.add(new HeroBean(StaticTools.timeCount, nameDialog.getField().getText()));
				break;
			case 2:
				StaticTools.treeSetZ.add(new HeroBean(StaticTools.timeCount, nameDialog.getField().getText()));
				break;
			case 3:
				StaticTools.treeSetG.add(new HeroBean(StaticTools.timeCount, nameDialog.getField().getText()));
				break;
			default:
				break;
			}
		}
		nameDialog.setVisible(false);
		nameDialog.dispose();
	}

}
