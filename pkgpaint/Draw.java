package pkgpaint;


import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

import java.awt.Dimension;

/**
 * 
 * @author yangzhenlin
 *
 */

public class Draw extends JFrame {
	private JPanel j = null;
	/**
	 * 初始化窗体
	 */
	public void initDraw() {
		this.setTitle("画图板");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);

		/**
		 * 设置画布背景色
		 */
		this.getContentPane().setBackground(java.awt.Color.WHITE);

		/**
		 * 设置布局
		 */
		FlowLayout layout = new FlowLayout();
		this.setLayout(layout);

		/**
		 * 加组件
		 */
		String texts[] = { "line", "rect", "oval", "arc" ,"triangle"};
		ButtonGroup group = new ButtonGroup();
		for (int i = 0; i < texts.length; i++) {
			JRadioButton shapeBtn = new JRadioButton(texts[i]);
			/**
			 * 设置按钮的动作命令
			 */
			shapeBtn.setActionCommand(texts[i]);
			
			/**
			 * 设置按钮大小
			 */
			Dimension dim=new Dimension(140,30);
			shapeBtn.setPreferredSize(dim);
			/**
			 * 设置文本居中
			 */
			shapeBtn.setHorizontalAlignment(JTextField.CENTER);
			/**
			 * 将按钮分组
			 */
			group.add(shapeBtn);
			/**
			 * 将按钮显示在窗体上
			 */
			this.add(shapeBtn);
			if (i == 0) {
				shapeBtn.setSelected(true);
			}

		}

		/**
		 * 设置颜色组选项
		 */
		String colortexts[] = { "black", "blue", "green", "yellow", "orange",
				"pink", "red" };
		ButtonGroup colorgroup = new ButtonGroup();
		for (int i = 0; i < colortexts.length; i++) {
			JRadioButton shapeColorBtn = new JRadioButton(colortexts[i]);
			/**
			 * 设置按钮的动作命令
			 */
			shapeColorBtn.setActionCommand(colortexts[i]);
			
			/**
			 * 设置按钮的大小
			 */
			Dimension dim=new Dimension (100,30);
			shapeColorBtn.setPreferredSize(dim);
			
			/**
			 * 设置文本居中
			 */
			shapeColorBtn.setHorizontalAlignment(JTextField.CENTER);
			
			/**
			 * 将按钮分组
			 */
			colorgroup.add(shapeColorBtn);
			/**
			 * 将按钮显示在窗体上
			 */
			this.add(shapeColorBtn);
			if (i == 0) {
				shapeColorBtn.setSelected(true);
			}
		}


		// ------------
		/**
		 * 显示窗体
		 */
		j = new JPanel();
		j.setBackground(Color.black);
		j.setSize(new Dimension(300,400));
//		j.setOpaque(false);
		j.setVisible(true);
		this.add(j);
		this.setVisible(true);
		// ------------

		/**
		 * 从窗体上获取画布对象
		 */
		java.awt.Graphics g = this.getGraphics();

		/**
		 * 给窗体加上鼠标监听器对象，创建监听器对象的时候讲画布对象传给监听器
		 */
		DrawListener dlis = new DrawListener(g, group,colorgroup);
		this.addMouseListener(dlis);
	}
}