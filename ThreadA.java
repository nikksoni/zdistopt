
public class ThreadA {
	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		b.start();

		synchronized (b) {
			try {
				while (true) {
					if (ThreadB.value % 2 == 0) {
						System.out.println("EVEN " + ThreadB.value);
						ThreadB.value++;
						b.notify();
					} else {
						b.wait();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

class ThreadB extends Thread {
	public static int value = 1;

	@Override
	public void run() {
		synchronized (this) {
			try {
				while (true) {
					if (ThreadB.value % 2 == 1) {
						System.out.println("ODD " + ThreadB.value);
						ThreadB.value++;
						this.notify();
					} else {
						this.wait();
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}