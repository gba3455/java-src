package pkgmine.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import pkgmine.bean.HeroBean;
import pkgmine.frame.MainFrame;
import pkgmine.tools.StaticTools;

public class HeroDialog extends JDialog{
	private static final long serialVersionUID = 1L;
	
	private JTable jta = null;
	
	private JPanel panel = null;
	
	DefaultTableModel dataModel;
	
	private int level = 0;
	
	private Vector<Vector<String>> dataCol;
	
	private MainFrame mainFrame;
	
	public HeroDialog(int level,MainFrame mainFrame){
		//固定拥有者.
		super(mainFrame);
		this.mainFrame = mainFrame;
		this.level = level;
		this.setTitle("最高記録");
		this.add(getPanel());
		this.setSize(new Dimension(220,150));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(mainFrame);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
	}
	
	public JPanel getPanel(){
		Vector<String> colName = new Vector<String>();
		colName.add("名前");
		colName.add("時間");
		dataCol = new Vector<Vector<String>>();
		addData();
		jta = new JTable(){
		
//		public boolean isCellEditable(int row,int column){
//			return false;
//		}
	};
	dataModel = new DefaultTableModel(dataCol,colName);

	jta.setModel(dataModel);
	//不可改变列宽
	jta.getTableHeader().setResizingAllowed(false);
	//不可移动列
	jta.getTableHeader().setReorderingAllowed(false);
	//设置列宽
	jta.getColumnModel().getColumn(0).setPreferredWidth(80);
	jta.getColumnModel().getColumn(1).setPreferredWidth(20);
	//设置只能单选行
	jta.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	JScrollPane jsp = new JScrollPane(jta);
	panel = new JPanel(new BorderLayout());
	panel.add(jsp);
	return panel;
	}
	
	private void addData(){
		if(level == 1){
			add2Data(StaticTools.treeSetC);
			
		}else if(level == 2){
			add2Data(StaticTools.treeSetZ);
		}else{
			add2Data(StaticTools.treeSetG);
		}
	};

	private void add2Data(TreeSet<HeroBean> treeSet) {
		for (HeroBean heroBean : treeSet) {
			Vector<String> v = new Vector<String>();
			v.add(heroBean.getName());
			v.add(heroBean.getTime() + "");
			dataCol.add(v);
		}
	}
	
	public static void main(String[] args) {
		new HeroDialog(1,null);
	}
}
