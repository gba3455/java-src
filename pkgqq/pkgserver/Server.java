package pkgqq.pkgserver;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class Server extends JFrame{
	private Map<String,JPanel> tabPanels;
	JTabbedPane tabbedPane = null;
	public Server() {
		init();
		this.setTitle("QQ服务端");
		this.setSize(new Dimension(650,400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.pack();
	}
	private void init(){
		tabsInit();
		tabbedPane = new JTabbedPane();
		for (String string : tabPanels.keySet()) {
			tabbedPane.add(string, tabPanels.get(string));
		}
		this.setLayout(new BorderLayout());
		this.add(tabbedPane,BorderLayout.NORTH);
	}
	private void tabsInit(){
		tabPanels = new LinkedHashMap<String, JPanel>();
		tabPanels.put("服务器管理",new serverMgr());
		tabPanels.put("用户管理", new userMgr());
		tabPanels.put("日志管理", new logMgr());
	}
	class serverMgr extends JPanel{
		public serverMgr() {
			// TODO Auto-generated constructor stub
			JPanel SvrPanel = new JPanel();
			JPanel panelNorth = new JPanel();
			JPanel panelCenter = new JPanel();
			JPanel panelCenterLeft = new JPanel();
			JPanel panelCenterLeftNorth = new JPanel();
			JPanel panelCenterLeftCenter = new JPanel();
			JPanel panelCenterRight = new JPanel();
			//设置边框
			panelNorth.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "在线用户列表"));
			panelCenterLeftNorth.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "通讯信息提示"));
			panelCenterLeftCenter.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "公告发送"));
			panelCenterRight.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "服务器管理"));
			//设置板块大小
			panelNorth.setPreferredSize(new Dimension(650,200));
			panelCenterLeft.setPreferredSize(new Dimension(400,300));
			panelCenterLeftNorth.setPreferredSize(new Dimension(390,130));
			panelCenterLeftCenter.setPreferredSize(new Dimension(390,170));
			panelCenterRight.setPreferredSize(new Dimension(250,300));
			//在线用户列表
			String[] columnNames = {"账号","用户姓名","性别","年龄","在线状态"};
			Object[][] rowData = {};
			JTable table = new JTable(rowData, columnNames);
//			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			JScrollPane scrollPane_Onl_Msg = new JScrollPane(table);
			scrollPane_Onl_Msg.setPreferredSize(new Dimension(640,160));
			//通讯信息提示
			JTextArea textArea_Con_Msg = new JTextArea(6,32);
			JScrollPane scrollPane_Con_Msg = new JScrollPane(textArea_Con_Msg);
			//公告发送
			JTextArea textArea_Ann_Msg = new JTextArea(6,32);
			JScrollPane scrollPane_Ann_Msg = new JScrollPane(textArea_Ann_Msg);
			JButton button_Ann_Msg = new JButton("发送公告");
			button_Ann_Msg.setLocation(0, 0);
			//服务器管理
			Icon image = new ImageIcon("./image/serverstart.gif");
			JLabel labelIcon = new JLabel(image);
			JButton btn_Start = new JButton("启动通讯服务");
			JButton btn_Stop = new JButton("停止通讯服务");
			JButton btn_ForceOffLine = new JButton("强制用户下线");
			Box box = Box.createVerticalBox();
			box.add(btn_Start);
			box.add(Box.createVerticalStrut(10));
			box.add(btn_Stop);
			box.add(Box.createVerticalStrut(40));
			box.add(btn_ForceOffLine);
			//加入
			SvrPanel.setLayout(new BorderLayout());
			
			panelNorth.add(scrollPane_Onl_Msg);
			
			panelCenterLeftNorth.add(scrollPane_Con_Msg);
			
			panelCenterLeftCenter.add(scrollPane_Ann_Msg);
			panelCenterLeftCenter.add(button_Ann_Msg);
			
			panelCenterRight.setLayout(new BorderLayout());
			panelCenterRight.add(labelIcon,BorderLayout.WEST);
			panelCenterRight.add(box,BorderLayout.EAST);
			
			panelCenterLeft.setLayout(new BorderLayout());
			panelCenterLeft.add(panelCenterLeftNorth,BorderLayout.NORTH);
			panelCenterLeft.add(panelCenterLeftCenter);
			
			panelCenter.add(panelCenterLeft);
			panelCenter.add(panelCenterRight);
			
			SvrPanel.add(panelNorth,BorderLayout.NORTH);
			SvrPanel.add(panelCenter);
			this.add(SvrPanel);
		}
	}
	class userMgr extends JPanel{
		public userMgr() {
		JPanel userPanel = new JPanel(new BorderLayout());
		//北桥
		JPanel panelNorth = new JPanel();
		JLabel labelId = new JLabel("编号:");
		JTextField textFieldId = new JTextField();
		textFieldId.setPreferredSize(new Dimension(140,24));
		JLabel labelName = new JLabel("姓名:");
		JTextField textFieldName = new JTextField();
		textFieldName.setPreferredSize(new Dimension(140,24));
		JButton btn_Search = new JButton("查询");
		JLabel labelCount = new JLabel("总记录数:");
		
		//中板
		JPanel panelCenter = new JPanel();
		//边框
		Border border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "用户信息表");
		panelCenter.setBorder(border);
		//表格
		String[] columnNames = {"编号","姓名","性别","年龄","是否在线","注册时间","住址"};
		Object[][] rowData = {
			    {"00001", "Smith","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00002", "mike","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00003", "john","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00004", "jacky","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00001", "Smith","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00002", "mike","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00003", "john","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00004", "jacky","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00001", "Smith","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00002", "mike","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00003", "john","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00004", "jacky","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00001", "Smith","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00002", "mike","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00003", "john","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00004", "jacky","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00001", "Smith","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00002", "mike","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00003", "john","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00004", "jacky","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00001", "Smith","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00002", "mike","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00003", "john","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00004", "jacky","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00001", "Smith","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00002", "mike","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00003", "john","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00004", "jacky","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00001", "Smith","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00002", "mike","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00003", "john","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			    {"00004", "jacky","男", "23", "离线","2010-10-08 10:08:08","厦门"},
			};
		JTable table = new JTable(rowData,columnNames);
		table.getColumnModel().getColumn(5).setPreferredWidth(rowData[0][5].toString().length() * 15);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//		table.setDragEnabled(false);
//		table.selectAll();
		table.setGridColor(Color.BLACK);
		JScrollPane scrollPane_Usr_Msg = new JScrollPane(table);
		scrollPane_Usr_Msg.setPreferredSize(new Dimension(640,400));
		panelCenter.add(scrollPane_Usr_Msg);
		//南桥
		JPanel panelSouth = new JPanel();
		JButton btn_AddUser = new JButton("添加用户");
		JButton btn_ModUser = new JButton("修改用户");
		JButton btn_DelUser = new JButton("删除用户");
		JButton btn_RePass = new JButton("重置密码");
		JButton btn_ReAllPass = new JButton("重置所有密码");
		panelSouth.add(btn_AddUser);
		panelSouth.add(btn_ModUser);
		panelSouth.add(btn_DelUser);
		panelSouth.add(btn_RePass);
		panelSouth.add(btn_ReAllPass);
		
		//开启监听
		SrvActionListener actionListener = new SrvActionListener(this);
		btn_ModUser.addActionListener(actionListener);
		
		labelCount.setForeground(Color.BLUE);
		labelCount.setVisible(true);
		panelNorth.add(labelId);
		panelNorth.add(textFieldId);
		panelNorth.add(labelName);
		panelNorth.add(textFieldName);
		panelNorth.add(btn_Search);
		panelNorth.add(labelCount);
		userPanel.add(panelNorth,BorderLayout.NORTH);
		userPanel.add(panelCenter);
		userPanel.add(panelSouth,BorderLayout.SOUTH);
		this.add(userPanel);
		}
	}
	class logMgr extends JPanel{
		public logMgr() {
			// TODO Auto-generated constructor stub
			JPanel logPanel = new JPanel();
			logPanel.setLayout(new BorderLayout());
			JPanel logPanelNorth = new JPanel();
//			logPanelNorth.setPreferredSize(new Dimension(780,50));
			JPanel logPanelCenter = new JPanel();
			JLabel labelYear = new JLabel("年");
			JLabel labelMonth = new JLabel("月");
			JLabel labelDay = new JLabel("日");
			JLabel labelKeyWord = new JLabel("关键字:");
			JTextField fieldKeyWord = new JTextField();
			JButton btn_Search = new JButton("查询");
			JTextArea textArea = new JTextArea(14,50);
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setPreferredSize(new Dimension(640,400));
			fieldKeyWord.setPreferredSize(new Dimension(140,24));
			
			//设置边框
			Border logBorderup = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE,1),"日志日期选择");
			Border logBorderdown = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue, 1),"历史日志");
			logPanelNorth.setBorder(logBorderup);
			logPanelCenter.setBorder(logBorderdown);
			
			logPanelNorth.add(comboBoxs(1));
			logPanelNorth.add(labelYear);
			logPanelNorth.add(comboBoxs(2));
			logPanelNorth.add(labelMonth);
			logPanelNorth.add(comboBoxs(3));
			logPanelNorth.add(labelDay);
			logPanelNorth.add(labelKeyWord);
			logPanelNorth.add(fieldKeyWord);
			logPanelNorth.add(btn_Search);
			logPanelCenter.add(scrollPane);
			logPanel.add(logPanelNorth,BorderLayout.NORTH);
			logPanel.add(logPanelCenter);
			this.add(logPanel);
		}
		Component comboBoxs(int type){
			String[] Arr;
			JComboBox comboBox = new JComboBox();
			comboBox.setPreferredSize(new Dimension(80,24));
			switch (type) {
			case 1:
				Arr = new String[]{"2001","2002","2003","2004","2005"};
				comboBox = new JComboBox(Arr);
				break;
			case 2:
//				Arr = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12"};
				for(Integer i = 1 ; i <= 12 ; i++){
					comboBox.addItem(i.toString());
				}
			default:				
//				Arr = new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","","","","","","","","","","","","","","","","",""};
//				if(LeapYear.isLeapYear((Integer)comboBox.getSelectedItem())){
//					
//				}
				for(Integer i = 1; i <= 31; i++){
					comboBox.addItem(i.toString());
				}
				break;
			}
			
			
			return comboBox;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server();
	}

}
