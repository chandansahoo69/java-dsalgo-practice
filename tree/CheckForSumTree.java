package tree;

public class CheckForSumTree {
	
	static Tree root;
	
	class Temp {
		boolean flag = true;
	}
	
	boolean isSumTree(Tree root) {
		Temp o = new Temp();
		isSumTreeUtill(root, o);
		return o.flag;
	}
	
	static int isSumTreeUtill(Tree root, Temp o) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return root.data;
		
		int lval = isSumTreeUtill(root.left, o);
		int rval = isSumTreeUtill(root.right, o);
		
		if(root.data != lval + rval)
			o.flag = false;
		
		return root.data + lval + rval;
	}

	public static void main(String[] args) {
		root = new Tree(3);
		root.left = new Tree(1);
		root.right = new Tree(2);
//		root.left.left = new Tree(1);
//		root.left.right = new Tree(9);
//		root.right.left = new Tree(6);
//		root.right.right = new Tree(7);
		CheckForSumTree obj = new CheckForSumTree();
		
		System.out.println(obj.isSumTree(root));

	}

}
