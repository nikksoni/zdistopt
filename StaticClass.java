
public class StaticClass implements Runnable{
	A a1 =new A();
	B b1=new B();
	Integer aa=0;
	
	public class A{
		int c=20;
		int d=25;
		
	}
	
public class B{
		int a=10;
		int b=15;
	}

@Override
public void run() {
	synchronized(aa){
		System.out.println("B1"+ b1.b);
		System.out.println("changes c" +a1.c+ "test11"+a1.d+ " ttt12"+Thread.currentThread().getName());
		a1.c=33;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a1.d=44;
		System.out.println(" c" +a1.c+ "test "+a1.d+ " ttt"+Thread.currentThread().getName());
		
	};
}
	
	
}






