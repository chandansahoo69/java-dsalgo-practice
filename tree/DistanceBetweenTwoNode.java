package tree;

public class DistanceBetweenTwoNode {
	
	static Tree root;
	
	//LowestCommonAncestor
	
	static int distanceBetweenTwoNodes(Tree root, int a, int b) {
		Tree lca = LowestCommonAncestor.LowestCommonAnsector(root, a, b);
		if(lca == null)
			return -1;
		int dis = distance(lca, a, 0) + distance(lca, b, 0);
		return dis;
	}
		
	static int distance(Tree root, int s, int dis) {
		if(root == null)
			return -1;
		if(root.data == s)
			return dis;
		int d = distance(root.left,s, dis+1);
		
		if(d != -1)
			return d;
		
		d = distance(root.right,s, dis+1);
		
		return d;
	}

	public static void main(String[] args) {
		root = new Tree(4);
		root.left = new Tree(3);
		root.right = new Tree(2);
		root.left.left = new Tree(1);
		root.left.left.left = new Tree(10);
		root.left.left.left.left = new Tree(11);
		root.left.right = new Tree(9);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);
		
		int m = distanceBetweenTwoNodes(root, 4, 4);
		System.out.println(m);

	}

}
