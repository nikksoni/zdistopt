import java.util.Set;
import java.util.TreeSet;

public class Testing {
	static int value=1;

public static void main(String[] args) {
	Testing t=new Testing();
	Threadss tt=t.new Threadss();
	Thread ttt=new Thread(tt);
	ttt.start();
	Thread ttt3=new Thread(tt);
	ttt3.start();
	
//	while (true){
//		synchronized (ttt) {
//			try {
//				ttt.wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println(value+"-"+Thread.currentThread().getName());
//			value++;
//			ttt.notify();
//			
//		}
//	}
	
	
//	String s="76,187,226,240,253,262,289,326,327,334,413,471,76,187,226,240,253,262,289,326,327,334,413,471,128,131,145,154,166,221,234,238,241,247,249,252,256,257,264,272,275,281,285,299,300,301,303,304,306,307,309,319,321,330,333,338,344,374,424,425,433";
//	System.out.println(s.replace(" ", "hhhhhhhh"));
//System.out.println("hello \n test");	
////Set<Integer> k =new TreeSet<Integer>();
////System.out.println(k.contains(null));
}
class Threadss implements Runnable{
	public Threadss() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true){
			synchronized (this) { 
				try {
					if(value!=1){
						this.wait();
					}
				
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(value+"-"+Thread.currentThread().getName());
				value++;
				this.notify();
			}
		}
		
	}

}

	
}

