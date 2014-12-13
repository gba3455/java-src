package pkgiostream;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TestFileActionListener implements ActionListener{
	TestFileGui frame = null;
	public TestFileActionListener(TestFileGui gui) {
		this.frame = gui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == frame.dir_Btn){
			frame.textArea.setText("");
			String path = frame.pathField.getText();
			ArrayList<String> arrayList = TestFile.getDirGui(path);
			for (String string : arrayList) {
				frame.textArea.append(string + "\n");
			}
		}
	}

}
