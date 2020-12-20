package tree;

public class CheckParrentContainsSumOfChildren {
	
	static Tree root;
	
	static boolean ifParrentContainsSumOfChildren(Tree root) {
		if(root == null || root.left == null && root.right == null)
			return true;
		
		int a = root.left == null ? 0 : root.left.data;
		int b = root.right == null ? 0 : root.right.data;
		
		return (a+b == root.data) && 
				ifParrentContainsSumOfChildren(root.left)
				&& ifParrentContainsSumOfChildren(root.right);
	}

	public static void main(String[] args) {
		root = new Tree(12);
		root.left = new Tree(4);
		root.left.left = new Tree(3);
		root.left.right = new Tree(1);
		root.right = new Tree(8);
		root.right.right = new Tree(8);
		
		System.out.println(ifParrentContainsSumOfChildren(root));
	}

}
