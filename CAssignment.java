
public class CAssignment {
	public static void main(String[] args) {
		byte b = 57;
//		b = b*5.7;
		System.out.println(b);
		
		Integer i=null;
		Object o = true ? i : "abs"; // NullPointerException!
		System.out.println(o);
	}

}
