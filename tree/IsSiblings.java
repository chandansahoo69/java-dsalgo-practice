package tree;

public class IsSiblings {
	
	static Tree root;
	
	public boolean Siblings(Tree root, Tree a, Tree b) {
		if(root == null)
			return false;
		
		return (root.left == a && root.right == b)
				|| (root.right == b && root.left == a)
				|| Siblings(root.left ,a ,b)
				|| Siblings(root.right, a, b);
	}

	public static void main(String[] args) {
		
		IsSiblings obj = new IsSiblings();
		
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
				
				System.out.println(obj.Siblings(root, root.left.right.left, root.left.right.right));

	}

}
