package pkgpaint;


import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 画布的监听器，实现鼠标监听器接口
 * 
 * @author yangzhenlin;
 * 
 */
public class DrawListener implements MouseListener {
	private int x1, x2, y1, y2;
	private java.awt.Graphics g;
	private javax.swing.ButtonGroup group;
	private javax.swing.ButtonGroup colorgroup;
	private String type = "line";
	private String colortype="black";

	private Color color = Color.RED;// 设置颜色

	public DrawListener(java.awt.Graphics g, javax.swing.ButtonGroup group,
			javax.swing.ButtonGroup colorgroup) {
		this.g = g;
		this.group = group;
		this.colorgroup = colorgroup;
		
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		
		/**
		 * 要绘制的时候才需要知道即将绘制的形状和颜色
		 * 得到按钮组中被选中的按钮
		 */
		javax.swing.ButtonModel bm = group.getSelection();
		javax.swing.ButtonModel colorbm =colorgroup.getSelection();
		
		/**
		 * 得到按钮的动作命令，做为要绘制的形状类型
		 */
		type = bm.getActionCommand();
		colortype=colorbm.getActionCommand();
		
		if(colortype.equals("black")){
			color =Color.BLACK;
		}else if(colortype.equals("blue")){
			color=Color.BLUE;
		}else if(colortype.equals("green")){
			color=Color.GREEN;
		}else if(colortype.equals("yellow")){
			color=Color.YELLOW;
		}else if(colortype.equals("orange")){
			color=Color.ORANGE;
		}else if(colortype.equals("pink")){
			color=Color.PINK;
		}else if(colortype.equals("red")){
			color=Color.RED;
		}
		/**
		 * 设置绘制颜色
		 */
		g.setColor(color);

		x1 = e.getX();
		y1 = e.getY();

	}

	public void mouseReleased(MouseEvent e) {

		x2 = e.getX();
		y2 = e.getY();

		if (type.equals("line")) {
			/**
			 * 画直线
			 */
			g.drawLine(x1, y1, x2, y2);

		}else if (type.equals("rect")) {
			/**
			 * 画矩形
			 */
			g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
					Math.abs(y1 - y2));

		} else if (type.equals("oval")) {
			g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
					Math.abs(y1 - y2));
		} else if (type.equals("arc")) {
			g.drawArc(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2),
					Math.abs(y1 - y2), 90, 90);
		}else if (type.equals("triangle")){
			g.drawLine(Math.min(x1,x2), Math.min(y1,y2),Math.max(x1, x2) , Math.max(y1, y2));
			g.drawLine(Math.min(x1, x2), Math.min(y1,y2), Math.min(x1,x2),Math.max(y1, y2));
			g.drawLine(Math.min(x1, x2), Math.max(y1,y2),Math.max(x1,x2),Math.max(y1, y2));
		}
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

}