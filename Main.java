import delta.Study;


public class Main extends Study{
	public static void main(String[] args) {
		Study a=new Study();
		
		
		StaticClass K=new StaticClass();
		Thread t1=new Thread(K);
		Thread t2=new Thread(K);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}

}
