package kmp;

public class KMP {
	public static void main(String[] args) {
		
	}
	private void populateFArray(String pattern){
		int [] failure=new int [pattern.length()+1];
		failure[0]=-1;
		int j=1;
		for(int i=0;i<pattern.length();i++){
			while(pattern.charAt(failure[j])!=pattern.charAt(i) || failure[j]!=-1){
				
			}
			if(pattern.charAt(failure[j])==pattern.charAt(i)){
				failure[j]=i;
				j++;
			}
		}
		
	}
	private int returnIndex(String word, String pattern, int[] failure){
		int index=0;
		int match=0;
		
		while(match<pattern.length()||match+index<word.length()){
			if(word.charAt(index+match)==pattern.charAt(failure[index+1])){
				match++;
			}
			else{
				match=failure[index];
				
			}
			if(match==pattern.length()){
				return index;
			}
		}
		
		return -1;
	}

}
