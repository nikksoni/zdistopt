
public class BinaryTreeFromPreOrder {
	
	public static void main(String[] args) {
		int[] postArr={12,16,17,15,22,35,33,45,30,18};
		
		BNode root=new BNode();
		populateBinaryTree(root,postArr,postArr.length-1);

	}
	
	
	private static int populateBinaryTree(BNode node,int[]arr,int index){
		if(index==0){
			return -1;
		}else{
			node.value=arr[index];
			if(arr[index-1]>arr[index]){
				BNode lc=new BNode();
				node.left=lc;
				index=populateBinaryTree(lc, arr, index-1);
			}
			if(arr[index-1]<arr[index]){
				BNode rc=new BNode();
				node.right=rc;
				index=populateBinaryTree(rc, arr, index-1);
			}
			
		}
		return -1;
	}

	public static class BNode{
		private int value;
		private BNode left;
		private BNode right;
		
		
		public BNode() {
			super();
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public BNode getLeft() {
			return left;
		}
		public void setLeft(BNode left) {
			this.left = left;
		}
		public BNode getRight() {
			return right;
		}
		public void setRight(BNode right) {
			this.right = right;
		}
		
		
	}
}
