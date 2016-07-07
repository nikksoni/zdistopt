
public class PrintLexico {

	private static int count =0;
//	static String str="instantaneouslyi";    //bombay
											 //abbmoy
	static String str="bombay";    //bombay
	public static void main(String[] args) throws Exception {
		String str="instantaneouslyi";
		String alphabet="aaeiilnnnossttuy";
		StringBuilder b=new StringBuilder("aaeiilnnnossttuy");
		
		
		permute(b, 0, b.length());
	}
	
	private static StringBuilder swap(int i, int j, StringBuilder str) {
		char c = str.charAt(i);
		str.setCharAt(i, str.charAt(j));
		str.setCharAt(j, c);
		return str;

	}
	
	
	private static void permute(StringBuilder str, int start, int last) throws Exception{
		if(start<last){
			for(int i=start;i<last;i++){
//				if(str.charAt(i)!=str.charAt(start)){
					swap(start, i, str);
					permute(str, start+1, last);
					swap(start, i, str);
				//}
				
			}
		} else{
//			System.out.println(count);
//			count++;
//			if(str.equals(str.toString())){
				System.out.println(str );//+ "        " + count);
//				throw new Exception("hello "+ count);
//			}
		}
		
	}
}
