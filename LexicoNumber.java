import java.util.Arrays;
import java.util.Comparator;

public class LexicoNumber {
	public static void main(String[] args) {
		String str1="instantaneouslyi";
		String str="instantaneouslyi";
		
		System.out.println(1e18);
		int [] arr=new int[26];
		Character[] chars = new Character[str.length()];
		for (int i = 0; i < chars.length; i++)
		    {
				chars[i] = str.charAt(i);
				arr[chars[i]-'a']++;
		    }

		// sort the array
		Arrays.sort(chars, new Comparator<Character>() {
		    public int compare(Character c1, Character c2) {
		        int cmp = Character.compare(
		            Character.toLowerCase(c1.charValue()),
		            Character.toLowerCase(c2.charValue())
		        );
		        if (cmp != 0) return cmp;
		        return Character.compare(c1.charValue(), c2.charValue());
		    }
		});

		// rebuild the string
		StringBuilder sb = new StringBuilder(chars.length);
		for (char c : chars) sb.append(c);
		
		System.out.println(sb.toString());
		
		String sorted=sb.toString();
		
		
		int number=0;
		int i=0;
		while(sorted.length()>1){
			for (int p = 0; p < sorted.length(); p++) {
				if(str.charAt(i)==sorted.charAt(p)){
					int k=count(sorted, p, arr);
					number+= k;
					arr[sorted.charAt(p)-'a']--;
					sorted=removeIthChar(sorted, p);
					i++;
					p=sorted.length();
				}
			}
		}
		
		System.out.println("num  "+number);
		
	}
	
	
	private static int factorial(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
	
	private static int count(String str, int startIndex, int[] arr){
		int total=factorial(str.length()-1);
		int denFactor=1;
		for(int i=0;i<26;i++){
			if(arr[i]>0){
				denFactor*=factorial(arr[i]);
			}
		}
		int res=(total*(startIndex)/denFactor);
		return res;
	}
	
	
	private static String removeIthChar(String s, int index){
		if(s.length()>1){
		if(index==0){
			 return (s.substring(1, s.length()));
		} else if(index==s.length()-1){
			return (s.substring(0, s.length()-1));
		} else{
			return (s.substring(0, index) + s.substring(index+1, s.length()) );
		}
		} else if (s.length()==1){
			return "";
		}
		 return null;
		
	}
	
	

}
