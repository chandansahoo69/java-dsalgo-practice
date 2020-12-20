package tree;

public class DeleteBinaryTree {
	
	static Tree root;
	
	public static Tree Delete(Tree root) {
		if(root == null)
			return null;
		root.left = Delete(root.left);
		root.right = Delete(root.right);
		
		System.out.print("\nDeleted node : " + root.data);
		root = null;
		return root;
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
			
			root = Delete(root);
}

}
