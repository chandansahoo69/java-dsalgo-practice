package tree;

public class DeleteLeafNodeHavingValueX {
	
	static Tree root;
	
	static Tree DeleteVlauex(Tree root, int x) {
		if(root == null)
			return root;
		
		root.left = DeleteVlauex(root.left, x);
		root.right = DeleteVlauex(root.right, x);
		
		if(root.data == x && root.left == null && root.right == null)
			return null;
		
		return root;
	}

	public static void main(String[] args) {
		root = new Tree(1);  
	    root.left = new Tree(2);  
	    root.right = new Tree(4);  
	    root.left.left = new Tree(5);  
	    root.left.right = new Tree(6);  
	    root.left.left.left = new Tree(9);  
	    root.left.left.right = new Tree(10);  
	    root.right.right = new Tree(8);  
	    root.right.left = new Tree(7);  
	    root.right.left.left = new Tree(11);  
	    root.right.left.right = new Tree(12); 
	    
	    BinaryTree o = new BinaryTree();
	    Tree temp = DeleteVlauex(root, 10);
		System.out.print("InorderTraversal : ");
		o.InorderTraversal(temp);
		System.out.println();

	}

}
