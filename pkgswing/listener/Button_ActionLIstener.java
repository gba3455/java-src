package pkgswing.listener;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button_ActionLIstener implements ActionListener{
	ActionListenerDemo2 frame = null;
	public Button_ActionLIstener(ActionListenerDemo2 actionListenerDemo2) {
		// TODO Auto-generated constructor stub
		this.frame = actionListenerDemo2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == frame.button){			
			String str = e.getActionCommand();
			if(str.equals("close")){
				frame.textField.setText(str);
				frame.button.setActionCommand("open");
			}else if(str.equals("open")){
				frame.textField.setText(str);
				frame.button.setActionCommand("close");
			}
		}else if(e.getSource() == frame.buttonSet){
			String str = e.getActionCommand();
//			if(frame.buttonSet.getActionCommand().equals("SouthPanel is open")){
//			if(str.equals("SouthPanel is open")){
//				frame.buttonSet.setActionCommand("SouthPanel is close");
//				frame.setSize(new Dimension(300,100));
//				frame.panelSouth.setVisible(false);
//			}else{
//				frame.buttonSet.setActionCommand("SouthPanel is open");
//				frame.setSize(new Dimension(300,330));
//				frame.panelSouth.setVisible(true);
//			}
			//method 2
			if(frame.panelSouth.isVisible()){
				frame.setSize(new Dimension(300,100));
				frame.panelSouth.setVisible(false);
			}else{
				frame.setSize(new Dimension(300,330));
				frame.panelSouth.setVisible(true);
			}
		}
		
	}

}
