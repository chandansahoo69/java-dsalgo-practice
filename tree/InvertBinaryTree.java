package tree;

public class InvertBinaryTree {
	
	static Tree root;
	
	static void invert(Tree root) {
		if(root == null)
			return ;
		
		Tree temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		invert(root.left);
		invert(root.right);
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
				
				BinaryTree o = new BinaryTree();
				
				o.InorderTraversal(root);
				System.out.println();
				invert(root);
				o.InorderTraversal(root);

	}

}
