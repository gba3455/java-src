package pkgfinalproject.pkgframe;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import pkgfinalproject.pkglistener.ButtonListener;
import pkgfinalproject.pkgutils.MyCharSet;
import pkgfinalproject.pkgutils.MyDetector;
import pkgfinalproject.pkgutils.StaticTools;
import jxl.read.biff.BOFRecord;

public class MyDropTarget
{
	final int DESKTOP_WIDTH = 1024;
    final int DESKTOP_HEIGHT = 768;
    final int FRAME_DISTANCE = 60;
    JFrame jf = new JFrame("KCGIファイナルプロジェクト(ファイルを中にドラッグして下さい)");
    //定义一个虚拟桌面
    private JDesktopPane desktop = new JDesktopPane();
    //保存下一个内部窗口的座标点
    private int nextFrameX;
    private int nextFrameY;
    //定义内部窗口为虚拟桌面的1/2大小
    private int width = DESKTOP_WIDTH / 2;
    private int height = DESKTOP_HEIGHT / 2;
    
    JOptionPane jop = new JOptionPane();
    public void init()
    {
            desktop.setPreferredSize(new Dimension(DESKTOP_WIDTH, DESKTOP_HEIGHT));
            //将当前窗口创建成拖放源
            new DropTarget(jf, DnDConstants.ACTION_COPY ,  new ImageDropTargetListener());
            jf.add(desktop);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.pack();
            jf.setVisible(true);
    }

    class ImageDropTargetListener extends DropTargetAdapter
    {
            public void drop(DropTargetDropEvent event)
            {
                    //接受复制操作
                    event.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                    //获取拖放的内容
                    Transferable transferable = event.getTransferable();
                    DataFlavor[] flavors = transferable.getTransferDataFlavors();
                    //遍历拖放内容里的所有数据格式
                    for (int i = 0; i < flavors.length; i++)
                    {  
                            DataFlavor d = flavors[i];
                            try
                            {
                                    //如果拖放内容的数据格式是文件列表
                                    if (d.equals(DataFlavor.javaFileListFlavor))
                                    {
                                            //取出拖放操作里的文件列表
                                            java.util.List fileList 
                                                    = (java.util.List) transferable.getTransferData(d);
                                            String filePath = null;
                                            Set<String> probablySet = new HashSet<String>();
                                            for (Object f : fileList)
                                            {
                                                    //显示每个文件
//                                                   showImage((File)f , event);
                                            	showText((File)f,event);
                                            	filePath = ((File)f).getAbsolutePath();
                                            	probablySet.add(((File)f).getName() + "は" + MyDetector.getProbablyEncode(filePath) + "の可能性が大きいです");
                                            }
                                            StringBuilder sb = new StringBuilder();
                                            for(String s : probablySet){
                                            	sb.append(s);
                                            }
                                            jf.setTitle(sb.toString());
                                    }
                            }
                            catch (Exception e)
                            {  
                                    e.printStackTrace();
                            }
                            //强制拖放操作结束，停止阻塞拖放源
                            event.dropComplete(true);
                    }
            }
            
            private void showText(File f,DropTargetDropEvent event) throws IOException{
//            	Map<String,Charset> cscs = Charset.availableCharsets();
            	ButtonListener bl = new ButtonListener(jop,desktop);
            	for(String cs : StaticTools.charset){
//            	for(Entry<String, Charset> map : cscs.entrySet()){
            		JInternalFrame iframe = new JInternalFrame(cs, true, true, true, true);
//                	JTextArea jt = new JTextArea(new String(getText((File)f).getBytes(),Charset.forName(cs)));
            		String content = getText((File)f,cs);
            		StaticTools.contentMap.put(cs, content);
                	JTextArea jt = new JTextArea(content);
                	jt.setLineWrap(true);
                	Box box = Box.createVerticalBox();
                	box.add(new JScrollPane(jt));
                	JButton jbtemp = StaticTools.jbMap.get(cs);
                	jbtemp.addActionListener(bl);
                	jbtemp.setActionCommand(cs);
                	box.add(jbtemp);
                	iframe.add(box);
                	desktop.add(iframe);
                	//设置内部窗口的原始位置（内部窗口默认大小是0X0，放在0,0位置）
                    iframe.reshape(nextFrameX, nextFrameY, width, height);
                    //使该窗口可见，并尝试选中它
                    iframe.show();
                    //计算下一个内部窗口的位置
                    nextFrameX += FRAME_DISTANCE;
                    nextFrameY += FRAME_DISTANCE;
                    if (nextFrameX + width > desktop.getWidth()) nextFrameX = 0;
                    if (nextFrameY + height > desktop.getHeight()) nextFrameY = 0;
            	}
            }
            
            private String getText(File f,String cs) throws IOException{
//            	FileReader fr = new FileReader(f);
//            	int readNum = 0;
//            	char[] cbuf = new char[1024];
            	StringBuilder sb = new StringBuilder();
//            	while((readNum = fr.read()) != -1){
//            		sb.append((char)readNum);
//            	}
//            	return sb.toString();
            	String line = null;
            	BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), cs));
            	while((line = br.readLine()) != null){
            		sb.append(line);
            	}
            	return sb.toString();
            }
            //显示每个文件的工具方法
            private void showImage(File f , DropTargetDropEvent event)throws java.io.IOException
            {
                    Image image = ImageIO.read(f);
                    if (image == null)
                    {
                            //强制拖放操作结束，停止阻塞拖放源
                            event.dropComplete(true);
                            JOptionPane.showInternalMessageDialog(desktop , "系统不支持这种类型的文件");
                            //方法返回，不会继续操作
                            return;
                    }
                    ImageIcon icon = new ImageIcon(image);
                    //创建内部窗口显示该图片
                    JInternalFrame iframe = new JInternalFrame(f.getName()
                            ,true , true , true , true);
                    JLabel imageLabel = new JLabel(icon);
                    iframe.add(new JScrollPane(imageLabel));
                    desktop.add(iframe);
                    //设置内部窗口的原始位置（内部窗口默认大小是0X0，放在0,0位置）
                    iframe.reshape(nextFrameX, nextFrameY, width, height);
                    //使该窗口可见，并尝试选中它
                    iframe.show();
                    //计算下一个内部窗口的位置
                    nextFrameX += FRAME_DISTANCE;
                    nextFrameY += FRAME_DISTANCE;
                    if (nextFrameX + width > desktop.getWidth()) nextFrameX = 0;
                    if (nextFrameY + height > desktop.getHeight()) nextFrameY = 0;
            }
    }
}