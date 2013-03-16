import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*;
import java.lang.Thread;

public class Pressz {
	public static boolean writez = true;
	public static boolean writex = true;

	public static class Killer extends Thread {
		public void run() {
			try {
				new BufferedReader(new InputStreamReader(System.in)).readLine();
				writez = false;
				new BufferedReader(new InputStreamReader(System.in)).readLine();
				writex = false;
			} catch (Exception e) { }
		}
	}

	public static void main(String[] argv) throws Exception {
		System.out.println("Press Enter to Kill");
		new Killer().start();
		Robot r = new Robot();
		while (writez) {
			int key = KeyEvent.VK_Z;
			r.keyPress(key);
			Thread.sleep(15);
			r.keyRelease(key);
			Thread.sleep(250);
		}
		while (writex) {
			int key = KeyEvent.VK_X;
			r.keyPress(key);
			Thread.sleep(15);
			r.keyRelease(key);
			Thread.sleep(50);
		}
	}
}
