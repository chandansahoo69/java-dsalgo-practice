package tree;

public class HeightOfTreeIsBalancedOrNot {
	
	static Tree root;
	
	class demo{
		boolean flag = true;
	}
	
	boolean TreeIsBalancedOrNot(Tree root) {
		demo o = new demo();
		TreeIsBalancedOrNotUtil(root, o);
		return o.flag;
	}
	
	static int TreeIsBalancedOrNotUtil(Tree root, demo c) {
		if(root == null)
			return 0;
		
		int l = TreeIsBalancedOrNotUtil(root.left, c);
		int r = TreeIsBalancedOrNotUtil(root.right, c);
		
		if(Math.abs(l - r) > 1)
			c.flag = false;
		
		return 1 + Math.max(l, r);
	}

	public static void main(String[] args) {
		root = new Tree(3);
		root.left = new Tree(1);
		root.right = new Tree(2);
		root.left.left = new Tree(1);
		root.left.left.left = new Tree(9);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);
		
		HeightOfTreeIsBalancedOrNot o = new HeightOfTreeIsBalancedOrNot();
		System.out.println(o.TreeIsBalancedOrNot(root));
	}

}
