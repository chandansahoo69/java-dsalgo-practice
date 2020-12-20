package tree;

public class ConvertBTtoSumTree {
	
	static Tree root;
	
	static void convert(Tree root) {
		Utill(root);
	}
	
	static int Utill(Tree root) {
		if(root == null)
			return 0;
		
		int lVal = Utill(root.left);
		int rVal = Utill(root.right);
		
		int sum = root.data + lVal + rVal;
		root.data = lVal + rVal;
		
		return sum;
	}

	public static void main(String[] args) {
		root = new Tree(3);
		root.left = new Tree(1);
		root.right = new Tree(2);
		root.left.left = new Tree(1);
		root.left.right = new Tree(9);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);
		
		convert(root);
		BinaryTree o = new BinaryTree();
		o.InorderTraversal(root);

	}

}
