package newpackage;

public class B extends A {
	static {
		System.out.println("static B Hello");
	}
	{
		System.out.println("object B Hello");
	}
	
	public B() {
		System.out.println("B constructor");
	}
	
	public static void Hello(){
		System.out.println("Say Hello");
	}
	
	public static void main(String[] args) {
		new AnnotationConfiguration().
		 configure().
		 addAnnotatedClass(B.class).
		 buildSessionFactory();
	}
}
