package tree;

public class DoubleTreeFormBinaryTree {
	
	static Tree root;
	
	static void DoubleTree(Tree root) {
		if(root == null)
			return;
		DoubleTree(root.left);
		DoubleTree(root.right);
		
		Tree newNode = new Tree(root.data);
		newNode.left = root.left;
		root.left = newNode;
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
		
		BinaryTree o = new BinaryTree();
		o.InorderTraversal(root);
		DoubleTree(root);
		System.out.println();
		o.InorderTraversal(root);
	}

}
