package tree;

public class RootToLeafPathSum {
	
	static Tree root;
	
	class A{
		int max = 0;
		boolean flag = false;
	}
	
	boolean RootToLeafPath(Tree root, int sum) {
		A o = new A();
		int currSum = 0;
		RootToLeafPathUtil(root, sum, currSum, o);
		return o.flag;
	}
	
	static void RootToLeafPathUtil(Tree root,int sum, int currSum, A o) {
		if(root == null)
			return ;
		
		currSum += root.data;
		
		if(root.left == null && root.right == null && sum == currSum)
			o.flag = true;
		
		RootToLeafPathUtil(root.left, sum, currSum, o);
		RootToLeafPathUtil(root.right, sum, currSum, o);
	}

	public static void main(String[] args) {
		root = new Tree(4);
		root.left = new Tree(3);
		root.right = new Tree(2);
		root.left.left = new Tree(1);
		root.left.right = new Tree(9);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);
		
		RootToLeafPathSum o = new RootToLeafPathSum();
		System.out.println(o.RootToLeafPath(root, 1));
		

	}

}
