package tree;

class Tree {
	int data;
	Tree left;
	Tree right;
	
	Tree(int val){
		data = val;
		left = right = null;
	}
}

public class BinaryTree {
	static Tree root;
	
	//inorder traversal
	public void InorderTraversal(Tree root) {
		if(root == null)
			return ;
		
		InorderTraversal(root.left);
		System.out.print(root.data + " ");
		InorderTraversal(root.right);
		
	}
	
	//preorder traversal
	public static void PreorderTraversal(Tree root) {
		if(root == null)
			return ;
		System.out.print(root.data + " ");
		PreorderTraversal(root.left);
		PreorderTraversal(root.right);
	}
	
	//postorderTraversal
	public static void PostorderTraversal(Tree root) {
		if(root == null)
			return ;
		PostorderTraversal(root.left);
		PostorderTraversal(root.right);
		System.out.print(root.data + " ");
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
		
		//traversal
		
		BinaryTree o = new BinaryTree();
		System.out.print("InorderTraversal : ");
		o.InorderTraversal(root);
		System.out.println();
		
		System.out.print("PreorderTraversal : ");
		PreorderTraversal(root);
		System.out.println();
		
		System.out.print("PostorderTraversal : ");
		PostorderTraversal(root);
	}

}
