package tree;

public class PrintNodesThatDoesnotHaveSiblings {
	
	static Tree root;
	
	static void PrintNodes(Tree root) {
		if(root == null)
			return ;
		
		if(root.left != null && root.right != null) {
			PrintNodes(root.left);
			PrintNodes(root.right);
		}
		
		else if(root.right != null) {
			System.out.println(root.right.data + " ");
			PrintNodes(root.right);
		}
		
		else if(root.right != null) {
			System.out.println(root.left.data + " ");
			PrintNodes(root.left);
		}
		
	}

	public static void main(String[] args) {
		
		root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);
		root.right.left = new Tree(6);
		root.left.left = new Tree(1);
		root.left.right = new Tree(9);
		root.right.right = new Tree(7);
//		root.right.right.right = new Tree(8);
		
		PrintNodes(root);
	}

}
