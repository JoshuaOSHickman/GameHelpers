import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*;
import java.lang.Thread;

public class Pressx {
	public static class Killer extends Thread {
		public void run() {
			try {
				new BufferedReader(new InputStreamReader(System.in)).readLine();
				System.exit(0);
			} catch (Exception e) { }
		}
	}

	public static void main(String[] argv) throws Exception {
		System.out.println("Press Enter to Kill");
		new Killer().start();
		Robot r = new Robot();
		int key = KeyEvent.VK_X;
		while (true) {
			Thread.sleep(100);
			r.keyPress(key);
			r.keyRelease(key);
		}
	}
}
