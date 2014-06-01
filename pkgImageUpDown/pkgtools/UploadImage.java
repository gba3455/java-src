package pkgImageUpDown.pkgtools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.tools.FileObject;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import pkgImageUpDown.pkgframe.MainFrame;

public class UploadImage {
	MainFrame mainFrame = null;
	public UploadImage(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	public boolean uploadImageByCommonFtpSe(File localImage, String imageRelativePath){
        if(localImage == null || !localImage.exists()){  
            System.out.println("ファイル見つからない"); 
            mainFrame.getjStatusText().setText("ファイル見つからない");
            return false;  
        }else if(imageRelativePath==null || "".equals(imageRelativePath)){  
        	System.out.println("サーバPath　BLANK");  
        	mainFrame.getjStatusText().setText("サーバPath　BLANK");
            return false;  
        }else{  
            FTPClient ftpClient = new FTPClient();  
            try {  
                ftpClient.connect(StaticTools.hostName);  
                boolean loginStatus = ftpClient.login(StaticTools.userName, StaticTools.passWord);  
                System.out.println(loginStatus);
                if(loginStatus){
                    ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);  
                    String relativePath = "";  
                    if(imageRelativePath.startsWith("/")){  
                        relativePath = imageRelativePath.substring(1, imageRelativePath.lastIndexOf("/"));  
                    }else{  
                        relativePath = imageRelativePath.substring(0, imageRelativePath.lastIndexOf("/"));  
                    }  
                    String fileName = imageRelativePath.substring(imageRelativePath.lastIndexOf("/") + 1);  
                    String fileNameTemp = fileName+".tmp";  
                      
                    String[] mkds = relativePath.split("/");  
                    String curpath ="";  
                    boolean mkdFlag = false ;  
                    boolean changeDirectoryFlag = false ;  
                    for(int i =0 ;i<mkds.length;i++){  
                        if(mkds[i]!=null && mkds[i]!=""){  
                            mkdFlag = ftpClient.makeDirectory(mkds[i]);  
                            if(mkdFlag){  
                            	System.out.println("フォルダ作成成功!");  
                            	mainFrame.getjStatusText().setText("フォルダ作成成功!");
                            }else{  
                            	System.out.println("フォルダ既にそんざいしてる.");  
                            	mainFrame.getjStatusText().setText("フォルダ既にそんざいしてる.");
                            }  
                            changeDirectoryFlag = ftpClient.changeWorkingDirectory(mkds[i]);  
                            if(changeDirectoryFlag){  
                            	System.out.println("今のフォルダ["+mkds[i]+"].");
                            	mainFrame.getjStatusText().setText("今のフォルダ["+mkds[i]+"].");
                            }else{  
                                System.out.println("フォルダ切り替え失敗.");  
                                mainFrame.getjStatusText().setText("フォルダ切り替え失敗.");
                            }  
                        }  
                    }  
                    System.out.println("アップロード開始["+fileNameTemp+"].");  
                    mainFrame.getjStatusText().setText("アップロード開始["+fileNameTemp+"].");
                    boolean changeStoreFileFlag = ftpClient.storeFile(fileNameTemp, new FileInputStream(localImage));  
                    if(changeStoreFileFlag){  //successful
                		String formalName = fileNameTemp.substring(0, fileNameTemp.indexOf(".tmp"));
                        ftpClient.rename(fileNameTemp, formalName);  
                        System.out.println("ファイル["+fileNameTemp+"]Rename To["+ formalName +"].");  
                        mainFrame.getjStatusText().setText("文件["+fileNameTemp+"]Rename To["+ formalName +"].");
                    }else{  
                        System.out.println("アップロード失败."); 
                        mainFrame.getjStatusText().setText("アップロード失败.");
                    }  
                      
                    boolean logoutFlag = ftpClient.logout();  
                    return true;  
                }else{  
                }  
            } catch (SocketException e1) {  
                System.out.println("连接ftp服务器出错" + e1);  
                mainFrame.getjStatusText().setText("连接ftp服务器出错" + e1);
            } catch (IOException e1) {  
                System.out.println("连接ftp服务器出错" + e1);  
                mainFrame.getjStatusText().setText("连接ftp服务器出错" + e1);
            }finally{  
                try {  
                	ftpClient.logout();
                    ftpClient.disconnect();  
                } catch (IOException e) {  
                    System.out.println(e);  
                }  
            }  
            return false;  
        }  
    }  
	
	public static void main(String[] args) {
//		downloadImage();
//		File localImage = new File("/users/sqzs/desktop/homework/imgsub.jpg");
//		uploadImageByCommonFtpSe(localImage,"/image/1.jpg");
	}
}
