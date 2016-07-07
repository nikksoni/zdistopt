
 class Mainn extends Hello {
	  void hello(){
		System.out.println("helloStatic");
	}

	public void test() {
		System.out.println("static");
		
	}
}
class Static2 extends Mainn{
	public  void hello(){
		System.out.println("hello2");
	}
}

public class StaticCheck extends Hello {
	
	public static void main(String[] args) {
//		System.out.println(Hello.a);
		Mainn two=new Static2();
		two.hello();
	
	}
	
	@Override
	public void test() {
		System.out.println("static");
		
	}
	
}