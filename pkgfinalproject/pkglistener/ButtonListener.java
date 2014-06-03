package pkgfinalproject.pkglistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import pkgfinalproject.pkgutils.OutPutContent;
import pkgfinalproject.pkgutils.StaticTools;

public class ButtonListener implements ActionListener{
	JOptionPane jop = null;
	JDesktopPane desktop = null;
	public ButtonListener(JOptionPane jop,JDesktopPane desktop) {
		this.jop = jop;
		this.desktop = desktop;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		if(StaticTools.jbMap.containsKey(str)){
			StaticTools.MACDESKTOP = getPath();
			System.out.println(StaticTools.contentMap.get(str));
				if(OutPutContent.OutPut(StaticTools.contentMap.get(str))){
					jop.showInternalMessageDialog(desktop, StaticTools.MACDESKTOP + "OutPut成功！");
				};
		}
	}
	
	private static String getPath(){
		JFileChooser fc = new JFileChooser();
		fc.setDialogType(JFileChooser.FILES_ONLY);
		fc.setDialogTitle("SAVE");
		fc.setMultiSelectionEnabled(false);
		fc.showSaveDialog(null);
		if (fc.getSelectedFile()==null) {
			return null;
		}
		return fc.getSelectedFile().getPath();
	}

}
