package MyFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import pkgImageUpDown.pkgtools.StaticTools;
class MyFrame extends JFrame{
	JFrame f = new JFrame();
	public MyFrame() {
		f.setTitle("test");
		f.add(new MPanel());
		f.setSize(new Dimension(1320,1240));
		f.setLocationRelativeTo(null);
	    f.setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame();
	}
}
class MPanel extends JPanel{
	Point start,end; 

	public MPanel() {
		this.setBackground(Color.BLACK.brighter());
		 this.addMouseListener(new MouseAdapter(){
		        public void mousePressed(MouseEvent e){
		        	start =e.getPoint();
		        	StaticTools.x1 = start.x;
		        	StaticTools.y1 = start.y;
		            repaint();
		            System.out.println(start);
		         }
		        @Override
		        public void mouseReleased(MouseEvent e) {
		        	StaticTools.x1 = 0;
		        	StaticTools.y1 = 0;
		        	StaticTools.y2 = 0;
		        	StaticTools.x2 = 0;
		        	repaint();
		        }
		       });
		    
		 this.addMouseMotionListener(new MouseMotionListener() {
				
				@Override
				public void mouseMoved(MouseEvent e) {
					// TODO Auto-generated method stub

		        	 repaint();
				}
				
				@Override
				public void mouseDragged(MouseEvent e) {
					// TODO Auto-generated method stub
					end = e.getPoint();
					StaticTools.x2 = end.x;
					StaticTools.y2 = end.y;
		        	 repaint();
		        	 System.out.println(end);
				}
			});
	}
    public void paint(Graphics g) {
    	super.paint(g);
    	Graphics2D g2d = (Graphics2D)g; 
    	GradientPaint gradient = new GradientPaint(0,0,Color.WHITE,  
                150,150,Color.YELLOW.darker()); 
    	g2d.setPaint(gradient);  
		int x = Math.min(StaticTools.x1, StaticTools.x2);
		int y = Math.min(StaticTools.y1, StaticTools.y2);
		int width = Math.abs(StaticTools.x2 - StaticTools.x1) + 1;
		int height = Math.abs(StaticTools.y2 - StaticTools.y1) + 1;
		Color c = new Color(x / 5, y / 5, x / 5);
		g.setColor(c);
//		for(int i = 1; i < 100; i++){
//			for(int j = 1; j < 100; j++){
//				if(i % 2 != 0 && j % 2 != 0)
//				g.drawLine(x - i, y - j, width + i, height + j);
//			}
//		}
//		g.drawLine(x - 1, y - 1, width + 1, height + 1);
//		g.drawLine(x - 10, y - 10, width + 10, height + 10);
//		g.drawLine(x - 20, y - 20, width + 20, height + 20);
//		g.drawLine(x - 30, y - 30, width + 30, height + 30);
//		g.drawLine(x - 100, y - 100, width + 100, height + 100);
		for(int i = 0; i < 100; i++){

			g.drawLine((int)Math.random()*x++ - 1, (int)Math.random()*y++ - 1, (int)Math.random()*width++ + 1, (int)Math.random()*height++ + 1);
		}
		for(int i = 0; i < 100; i++){

			g.drawLine(y++ - 1, x++ - 1, height++ + 1, width++ + 1);
		}
	}
    
    public void update(Graphics g){
    	System.out.println("_________________________________");
    }
}