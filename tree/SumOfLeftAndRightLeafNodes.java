package tree;

public class SumOfLeftAndRightLeafNodes {
	static Tree root;
	
	public static int sumOfLeftNodes(Tree root, boolean flag) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null && flag)
			return root.data;
		return sumOfLeftNodes(root.left, true) + sumOfLeftNodes(root.right, false);
	}
	
	public static int sumOfRightNodes(Tree root, boolean flag) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null && flag)
			return root.data;
		return sumOfRightNodes(root.left, false) + sumOfRightNodes(root.right, true);
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

				System.out.println("sumOfLeftNodes : ");
				System.out.println(sumOfLeftNodes(root,false));
				System.out.println("sumOfRighttNodes : ");
				System.out.println(sumOfRightNodes(root,false));
				
	}

}
