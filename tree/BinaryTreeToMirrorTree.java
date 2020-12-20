package tree;

public class BinaryTreeToMirrorTree {
	
	static Tree root;
	
	//inorder traversal
		public static void InorderTraversal(Tree root) {
			if(root == null)
				return ;
			
			InorderTraversal(root.left);
			System.out.print(root.data + " ");
			InorderTraversal(root.right);
			
		}
	
	static Tree MirrorTree(Tree root){
		if(root == null)
			return null;
		//swap the left node and the right node
		Tree temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		MirrorTree(root.left);
		MirrorTree(root.right);
		
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
		
		InorderTraversal(root);
		System.out.println();
		Tree mirror = MirrorTree(root);
		InorderTraversal(mirror);

	}

}
