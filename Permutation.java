
public class Permutation {
	private static int  count=0;
	public static void main(String[] args) {
		StringBuilder build=new StringBuilder("HELLOWOR");
		Permutation p=new Permutation();
		p.permute(build, 0, build.length()-1);
		System.out.println(count);;
		
	}
	private void swap(StringBuilder build, int x,int y){
		char temp=build.charAt(x);
		build.setCharAt(x, build.charAt(y));
		build.setCharAt(y, temp);
	}
	
	private void permute(StringBuilder build, int startIndex,int finalIndex){
		if(startIndex==finalIndex){
			count++;
			System.out.println(build);
		} else {
			for(int i=startIndex;i<=finalIndex;i++){
				swap(build, startIndex, i);
				permute(build, startIndex+1, finalIndex);
				swap(build, startIndex, i);
			}
		}
	}

}
