package tree;

import java.util.ArrayList;

public class BoundaryTraversal {
	
	static Tree root;
	
	class B {
		ArrayList<Integer> a = new ArrayList<>();
	}
	
	ArrayList<Integer> Boundary(Tree root) {
		B o = new B();
		
		if(root == null)
			return o.a;
		
		o.a.add(root.data);
		
		if(root.left == null && root.right == null)
			return o.a;
		
		leftBoundary(root.left, o);
		leafNode(root, o);
		rightBoundary(root.right, o);
		
		return o.a;
	}
	
	static void leftBoundary(Tree root, B o){
		if(root == null)
			return ;
		
		if(root.left != null || root.right != null)
			o.a.add(root.data);
		
		leftBoundary(root.left, o);
		leftBoundary(root.right, o);
	}
	
	static void rightBoundary(Tree root, B o) {
		if(root == null)
			return ;
		
		rightBoundary(root.right, o);
		rightBoundary(root.left, o);
		
		if(root.left != null ||root.right != null)
			o.a.add(root.data);
	}
	
	static void leafNode(Tree root, B o) {
		if(root == null)
			return ;
		
		leafNode(root.left, o);
		
		if(root.left == null && root.right == null)
			o.a.add(root.data);
		
		leafNode(root.right, o);
	}

	public static void main(String[] args) {
		root = new Tree(3);
		root.left = new Tree(1);
		root.right = new Tree(2);
		root.left.left = new Tree(1);
		root.left.left.left = new Tree(9);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);
		
		BoundaryTraversal o = new BoundaryTraversal();
		System.out.println(o.Boundary(root));

	}

}
