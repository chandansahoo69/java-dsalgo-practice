package tree;

public class IdenticalTreeOrNot {
	static Tree root1,root2;
	
	public static boolean Identical(Tree root1, Tree root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		
		return (root1.data == root2.data &&
				Identical(root1.left, root2.left) && 
				Identical(root1.right, root2.right));
	}
	
	public static void main(String[] args) {
		//create the root1
			root1 = new Tree(2);
			root1.left = new Tree(7);
			root1.right = new Tree(5);
			root1.left.left = new Tree(2);
			root1.left.right = new Tree(6);
			root1.left.right.left = new Tree(5);
			root1.left.right.right = new Tree(11);
			root1.right.right = new Tree(9);
			root1.right.right.left = new Tree(4);
		//create the root1	
			root2 = new Tree(2);
			root2.left = new Tree(7);
			root2.right = new Tree(5);
			root2.left.left = new Tree(2);
			root2.left.right = new Tree(6);
			root2.left.right.left = new Tree(5);
			root2.left.right.right = new Tree(11);
			root2.right.right = new Tree(9);
			root2.right.right.left = new Tree(4);
			
			System.out.println(Identical(root1,root2));
	}
}
