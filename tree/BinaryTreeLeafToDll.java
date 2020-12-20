package tree;

public class BinaryTreeLeafToDll {
	
	static Tree root, headList, prev;
	
	public static Tree convertToDLL(Tree root) {
		if(root == null)
			return null;
		
		if(root.left == null && root.right == null) {
			if(prev == null)
				headList = root;
			else {
				root.left = prev;
				prev.right = root;
			}
			prev = root;
			return null;
		}
		
		root.left = convertToDLL(root.left);
		root.right = convertToDLL(root.right);
		
		return root;
	}

	public static void print(Tree root) {
		while(root != null) {
			System.out.print(root.data + " ");
			root = root.right;
		}
	}
	
	public static void main(String[] args) {
		root = new Tree(2);
		root.left = new Tree(7);
		root.right = new Tree(5);
		root.left.left = new Tree(1);
		root.left.right = new Tree(6);
		root.left.right.left = new Tree(15);
		root.left.right.right = new Tree(11);
		root.right.right = new Tree(9);
		root.right.right.left = new Tree(4);
		
		convertToDLL(root);
		print(headList);
		System.out.println();
		
		BinaryTree o = new BinaryTree();
		
		o.InorderTraversal(root);

	}

}
