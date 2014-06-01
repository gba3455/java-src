import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/*
 * NIO.2的Path类提供了如下的一个方法来监听文件系统的变化。
 register(WatcherService watcher,WatchEvent.Kind<?>... events):用watcher监听该path代表的目录下文件变化。event参数指定要监听哪些类型的事件。
 WatchService有三个方法来监听目录的文件变化事件。
 WatchKey poll():获取下一个WatchKey，如果没有WatchKey发生就立即返回null；
 WatcheKey poll(long timeout,TimeUnit unit):尝试等待timeout时间去获取下一个WatchKey；
 WatchKey  take():获取下一个WatchKey，如果没有发生就一直等待；
 如果程序需要一直监控，则应该选择使用take()方法，如果程序只需要监控指定时间，则使用poll方法。

 实现流程如下
 1.为文件系统创建一个WatchService 实例 watcher
 2.为你想监听的目录注册 watcher。注册时，要注明监听那些事件。
 3.在无限循环里面等待事件的触发。当一个事件发生时，key发出信号，并且加入到watcher的queue
 4.从watcher的queue查找到key，你可以从中获取到文件名等相关信息
 5.遍历key的各种事件
 6.重置 key，重新等待事件
 7.关闭服务
 */
public class WatchServiceDemo {
	private static WatchService watchService;
	public static void main(String[] args) throws Exception {
		getContent();
	}

	public static String getContent() {
		try {
			while (true) {
				watchService = FileSystems.getDefault().newWatchService();
				Paths.get("/Users/SQZS/downloads/").register(watchService,
						StandardWatchEventKinds.ENTRY_CREATE,
						StandardWatchEventKinds.ENTRY_DELETE,
						StandardWatchEventKinds.ENTRY_MODIFY);
				WatchKey key = watchService.take();
				for (WatchEvent<?> event : key.pollEvents()) {
					System.out.println(event.context() + "发生了" + event.kind()
							+ "事件");
					return event.context() + "发生了" + event.kind() + "事件";
				}
				if (!key.reset()) {
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}