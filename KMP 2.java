
public class KMP {
	private static final String s="abababababacbababa";
	private static final String pattern="babacba"; 
	private static int[] failure=new int[pattern.length()+1];
	public static void main(String[] args) {
		populateH(pattern);
		int[] newArr=new int[pattern.length()];
		for (int i = 0; i < newArr.length; i++) {
			if(failure[i+1]<0){
				newArr[i]=0;
			}else{
				newArr[i]=failure[i+1];
			}
		}
		System.out.println("f"+searchKMP(pattern.toCharArray(), s.toCharArray(), failure)+" ff");
	}
	private static int populateH(String pat){
		
		 int n = pat.length();
	        failure[0] = -1;
	        for (int j = 1; j < n; j++)
	        {
	            int i = failure[j - 1];
	            while ((pat.charAt(j) != pat.charAt(i + 1)) && i >= 0)
	                i = failure[i];
	            if (pat.charAt(j) == pat.charAt(i + 1))
	                failure[j] = i + 1;
	            else
	                failure[j] = -1;
	        }
//		int i=1,j=0;
//		int[] h=new int[s.length()];
//		
//		while(i<s.length()){
//			if(s.charAt(i)==s.charAt(j)){
//				h[i]=h[i-1]+1;
//				i++;
//				j++;
//			}else{
//				h[i]=0;
//				i++;
//			}
//		}
		for(int k:failure){
			System.out.print(k+" ");
		}
		return -1;
	}

static int searchKMP(char[] w, char[] s, int[] t)  
{  
 int m=0;  
 int i=0;  
 while( ((m + i) < s.length) && (i<w.length) )  
 {  
  if(s[m+i] == w[i]) i++;  
  else  
  {  
   m += i - t[i];  
   if (i > 0) i = t[i];  
   i++;  
  }  
 }  
 if(i == w.length) return m;  
 else return -1;  
}  
}


//abcabc
//   abcabc