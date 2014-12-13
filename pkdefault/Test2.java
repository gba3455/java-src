package pkdefault;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Test2 extends JFrame {
	private static JFileChooser jFileChooser = null;
	private static JTextArea jTextArea = null;
	private static JScrollPane jScrollPane = null;
	private static JPanel btnPanel = null;
	private static JButton jButton = null;
	private static JButton watch_Btn = null;
	private static JPanel jPanel = null;
	private static File SourceText = null;
	private static WatchService watchService = null;

	Test2() {
		init();
		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jButton) {
					int intRetVal = jFileChooser.showOpenDialog(null);
					if (intRetVal == JFileChooser.APPROVE_OPTION) {
						System.out.println(jFileChooser.getSelectedFile());
						SourceText = jFileChooser.getSelectedFile();
					}
				}
			}
		});
		watch_Btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == watch_Btn) {
					jTextArea.append("监视开始" + "\r\n");
					new Thread(new Runnable() {

						@Override
						public void run() {
							if (SourceText == null) {
								jTextArea.append("请先打开目录");
							} else {
								WatchingStart();
							}
						}
					}).start();
				}
			}
		});
	}

	private void WatchingStart() {
		try {
			while (true) {
				watchService = FileSystems.getDefault().newWatchService();
				Paths.get(SourceText.getAbsolutePath()).register(watchService,
						StandardWatchEventKinds.ENTRY_CREATE,
						StandardWatchEventKinds.ENTRY_DELETE,
						StandardWatchEventKinds.ENTRY_MODIFY);
				WatchKey key = watchService.take();
				for (WatchEvent<?> e : key.pollEvents()) {
					System.out.println(e.kind().toString());
					if (e.kind().toString() == "ENTRY_CREATE") {
						if (e.context().toString().endsWith(".txt"))
							getContent(SourceText.getAbsolutePath()
									+ File.separator + e.context());
						new File(SourceText + File.separator + e.context()).deleteOnExit();
					}
				}
				if (!key.reset()) {
					break;
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	private void getContent(String add) {
		try {
			int start = -1;
			int end = -1;
			String link = null;
			String pa55 = null;
			InputStreamReader isr = new InputStreamReader(new FileInputStream(
					new File(add)), "gbk");
			char[] chr = new char[1024];
			int len = 0;
			while ((len = isr.read(chr)) != -1) {
				String str = new String(chr, 0, len);

				start = str.indexOf("链接：");
				end = str.indexOf("密码：");
				link = str.substring(start + 3, end);
				pa55 = str.substring(end + 3, end + 7);
				jTextArea.append(link + "\r\n");
				jTextArea.append(pa55 + "\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void init() {
		jPanel = new JPanel();
		btnPanel = new JPanel();

		jFileChooser = new JFileChooser();
		jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		jTextArea = new JTextArea();
		jTextArea.setLineWrap(true);
		jScrollPane = new JScrollPane(jTextArea);
		jButton = new JButton("Open");
		watch_Btn = new JButton("Watch");

		jPanel.setLayout(new BorderLayout());
		btnPanel.add(jButton);
		btnPanel.add(watch_Btn);
		jPanel.add(btnPanel, BorderLayout.NORTH);
		jPanel.add(jScrollPane);

		this.setTitle("沈美乡网盘链接密码提取器");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(500, 400));
		this.setLocationRelativeTo(null);
		this.add(jPanel);
		// this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Test2();
	}
}