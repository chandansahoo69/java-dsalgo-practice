package tree;

public class DeepestNodeInBinaryTree {
	
	class p{
		int maxlevel = -1;
		int res = -1;
	}
	
	int DeepestNode(Tree root) {
		p o = new p();
		DeepestNodeUtil(root, 0, o);
		return o.res;
	}
	
	static void DeepestNodeUtil(Tree root, int level, p o) {
		if(root == null)
			return ;
		
		DeepestNodeUtil(root.left, level+1, o);
		//if the level is greater then maxlevel then store 
		//the result and update the level at the maximum level the
		//deepest node is present 
		if(level > o.maxlevel) {
			o.res = root.data;
			o.maxlevel = level;
		}
		
		DeepestNodeUtil(root.right, level+1, o);
	}
	
	static Tree root;

	public static void main(String[] args) {
		//create the nodes
		root = new Tree(1);
		root.left = new Tree(2);
		root.right = new Tree(3);
		root.right.left = new Tree(6);
		
//		root.left.left = new Tree(1);
//		root.left.right = new Tree(9);
//		root.right.right = new Tree(7);
//		root.right.right.right = new Tree(8);
				
		DeepestNodeInBinaryTree o = new DeepestNodeInBinaryTree();
		int n = o.DeepestNode(root);
		System.out.println(n);
	}

}
