package tree;

public class GetNoOfLeafNode {
	static Tree root;
//	int sum;
	public static int GetLeafNode(Tree root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		return GetLeafNode(root.left) + GetLeafNode(root.right);
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
		
		int n = GetLeafNode(root);
		System.out.println(n);
	}
}
