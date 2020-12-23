package tree;

public class LowestCommonAncestor {
	
	static Tree root;
	
	static Tree LowestCommonAnsector(Tree root, int a, int b) {
		//base case
		if(root == null)
			return root;
		//it will handel two cases lfskewtree 2-3 and 
		//rtskewtree 2-3 
		if(root.data == a || root.data == b)
			return root;
		
		Tree l = LowestCommonAnsector(root.left, a, b);
		Tree r = LowestCommonAnsector(root.right, a, b);
		//if a and b are in both the part then it handeled in this
		if(l != null && r != null)
			return root;
		//if it present at left tree then return
		if(l != null)
			return l;
		//if it present at right tree then return 
		if(r != null)
			return r;
		//unless return null if no one is present
		return null;
	}

	public static void main(String[] args) {
		root = new Tree(4);
		root.left = new Tree(3);
		root.right = new Tree(2);
		root.left.left = new Tree(1);
		root.left.right = new Tree(9);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);
		
		//LowestCommonAnsector in binary tree
		
		Tree n = LowestCommonAnsector(root, 4, 1);
		if(n == null)
			System.out.println("LowestCommonAnsector dosent exist");
		else
			System.out.println(n.data);

	}

}
