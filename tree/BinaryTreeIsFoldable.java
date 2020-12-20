package tree;

public class BinaryTreeIsFoldable {
	
	static Tree root;
	
	static boolean isFoldable(Tree root) {
		if(root == null)
			return true;
		return isMirrorStructure(root.left, root.right);
	}
	
	static boolean isMirrorStructure(Tree root1, Tree root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		return isMirrorStructure(root1.left, root2.right) &&
				isMirrorStructure(root1.right, root2.left);
	}
	
	public static void main(String [] args) {
		root = new Tree(2);
		root.left = new Tree(3);
		root.left.left = new Tree(4);
		root.right = new Tree(1);
//		root.right.right = new Tree(3);
		
		System.out.println(isFoldable(root));
	}

}
