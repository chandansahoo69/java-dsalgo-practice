package tree;

//class Tree {
//	int data;
//	Tree left;
//	Tree right;
//	
//	Tree(int val){
//		data = val;
//		left = right = null;
//	}
//}

public class HeaightOfTree {
	static Tree root;

	public static int Height(Tree root) {
		if(root == null)
			return -1;
		return 1 + Max(Height(root.left) , Height(root.right));
	}
	
	public static int Max(int a, int b) {
		
		return a > b ? a : b;
	}
	
	public static void main(String[] args) {
		
		//create the nodes
		root = new Tree(2);
		root.left = new Tree(7);
		root.right = new Tree(5);
		root.left.left = new Tree(2);
		root.left.right = new Tree(6);
		root.left.right.left = new Tree(5);
		root.left.right.right = new Tree(11);
		root.right.right = new Tree(9);
		root.right.right.left = new Tree(4);
		
		int n = Height(root);
		System.out.println(n);
		
	}
}
