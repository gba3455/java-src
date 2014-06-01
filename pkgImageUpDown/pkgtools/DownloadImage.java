package pkgImageUpDown.pkgtools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import pkgImageUpDown.pkgframe.MainFrame;

public class DownloadImage {
	MainFrame mainFrame = null;
	public DownloadImage(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	public void downloadImage(){
		StaticTools.localfiles = getLocalFiles();
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect(StaticTools.hostName);
			boolean loginStatus = ftpClient.login(StaticTools.userName, StaticTools.passWord);
            System.out.println(loginStatus);
            if(loginStatus){
            	ftpClient.changeWorkingDirectory(StaticTools.remotePath);
            	FTPFile[] files = ftpClient.listFiles();
            	for(FTPFile f : files){
            		if(f.isFile() && f.getName().endsWith(".jpg")){
//            		Calendar c = f.getTimestamp();
//            		Date date = c.getTime();
//            		
//            		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//            		sdf.format(date);
//            		System.out.println(date.toString());
            			int picNum = 0;
            			if(!StaticTools.localfiles.contains(f.getName())){
            				StaticTools.tubeDownload.add(f.getName());
            				StaticTools.tubeDownloadMap.put(picNum, f.getName());
            				picNum++;
            			}
            			if(StaticTools.tubeDownload.size() != 0){//更新あり
            				mainFrame.getjStatusText().setText("更新あり。。。");
                        	boolean down = download(ftpClient,StaticTools.tubeDownload);
                        	if(down){
                        		mainFrame.getjStatusText().setText("ダウンロード完了、開きますか？");
                        		mainFrame.getjButton_Open().setVisible(true);
                        	}
            			}else{
            				mainFrame.getjStatusText().setText("更新なし。。。");
            			}
//            			remotefiles.add(f.getName());
            		}
            	}
            }
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private boolean download(FTPClient ftpClient,List<String> tubeDown){
		ftpClient.enterLocalPassiveMode();
		boolean downStatus = false;
		try {
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			System.out.println("ダウンロード開始");
			this.mainFrame.getjStatusText().setText("ダウンロード開始");
			for(String name:tubeDown){
				downStatus = ftpClient.retrieveFile(StaticTools.remotePath + name, new FileOutputStream(StaticTools.Path + name));
				System.out.println(name + "ダウンロードing");
				this.mainFrame.getjStatusText().setText("ダウンロードing");
			}
			System.out.println("ダウンロード終了");
			this.mainFrame.getjStatusText().setText("ダウンロード終了");
			downStatus = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return downStatus;
	}
	
	private static List<String> getLocalFiles() {
		File[] files = new File(StaticTools.Path).listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(StaticTools.imageFormat))
					return true;
				return false;
			}
		});
		List<String> fileList = new ArrayList<String>();
		for(File f : files){
			fileList.add(f.getName());
		}
		return fileList;
	}
	public static void main(String[] args) {
		DownloadImage dli = new DownloadImage(null);
		dli.downloadImage();
	}
}
