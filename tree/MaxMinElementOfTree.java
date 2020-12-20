package tree;

public class MaxMinElementOfTree {
	
	static Tree root;
	
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	static void MinMax(Tree root) {
		if(root == null)
			return;
		if(max < root.data)
			max = root.data;
		if(min > root.data)
			min = root.data;
		MinMax(root.left);
		MinMax(root.right);
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
				
				MinMax(root);
				
				System.out.println(max + " " + min);

	}

}
