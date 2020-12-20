package tree;

public class SumOfAllNodes {
	static Tree root;

	public static int Sum(Tree root) {
		if(root == null)
			return 0;
		return root.data + Sum(root.left) + Sum(root.right);
	}
	
	public static void main(String[] args) {
		
		//create the nodes
		root = new Tree(4);
		root.left = new Tree(3);
		root.right = new Tree(2);
		root.left.left = new Tree(1);
		root.left.right = new Tree(9);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);
		
		int n = Sum(root);
		System.out.println(n);
	}
}
