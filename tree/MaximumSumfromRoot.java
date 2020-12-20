package tree;

public class MaximumSumfromRoot {
	
	static Tree root ;
	
	class B{
		int max = 0;
	}
	
	int MaximumSumRoot(Tree root) {
		B o = new B();
		int cSum = 0;
		MaximumSumRootUtil(root, cSum, o);
		return o.max;
	}
	
	static void MaximumSumRootUtil(Tree root, int cSum, B o){
		if(root == null)
			return ;
		
		cSum += root.data;
		
		if(root.left == null && root.right == null && cSum > o.max)
			o.max = cSum;
		MaximumSumRootUtil(root.left, cSum, o);
		MaximumSumRootUtil(root.right, cSum, o);
	}

	public static void main(String[] args) {
		root = new Tree(4);
		root.left = new Tree(3);
		root.right = new Tree(2);
		root.left.left = new Tree(1);
		root.left.right = new Tree(9);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);
		
		MaximumSumfromRoot o = new MaximumSumfromRoot();
		System.out.println(o.MaximumSumRoot(root));

	}

}
