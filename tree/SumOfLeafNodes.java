package tree;

public class SumOfLeafNodes {
	static Tree root;
	
	public static int sum(Tree root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return root.data;
		return sum(root.left) + sum(root.right);
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
		
		System.out.println(sum(root));

	}

}
