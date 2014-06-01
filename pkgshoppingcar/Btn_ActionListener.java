package pkgshoppingcar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Btn_ActionListener implements ActionListener{
	TestShoppingCar frame = null;
	Map<Integer,OrderItemBean> map = new HashMap<Integer, OrderItemBean>();
	ShoppingCar sc = new ShoppingCar(0, 0, map);
	public Btn_ActionListener(TestShoppingCar tsc) {
		this.frame = tsc;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == frame.buy_Btn){
			frame.setSize(new Dimension(300,330));
			frame.panelSouth.setVisible(true);
			switch (Integer.parseInt(frame.field.getText())) {
			case 1:
				sc.buy(1);
				break;
			case 2:
				sc.buy(2);
				break;
			default:
				sc.buy(3);
				break;
			}
		}else if(e.getSource() == frame.del_Btn){
			switch (Integer.parseInt(frame.field.getText())) {
			case 1:
				sc.delete(1);
				break;
			case 2:
				sc.delete(2);
				break;
			default:
				sc.delete(3);
				break;
			}
		}else if(e.getSource() == frame.outPut_Btn){
			FileWriter fileWriter = null;
			BufferedWriter bufferedWriter = null;
			try {
				fileWriter = new FileWriter("./src/pkgshoppingcar/log/" + GetDate.getDate(1) + ".log",true);
				bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write(GetDate.getDate(2));
				bufferedWriter.newLine();
				bufferedWriter.write(frame.textArea.getText());
				bufferedWriter.newLine();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				try {
					bufferedWriter.flush();
					bufferedWriter.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		frame.textArea.setText(sc.show());
	}

}
