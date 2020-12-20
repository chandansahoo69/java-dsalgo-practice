package tree;

public class TwoTreeMirrorToEachOtherOrNot {
	
	static Tree root1,root2;
	
	static boolean isMirrorToEachOther(Tree root1, Tree root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		return (root1.data == root2.data) && 
				isMirrorToEachOther(root1.left, root2.right) && 
				isMirrorToEachOther(root1.right , root2.left);
	}

	public static void main(String[] args) {
		
		root1 = new Tree(2);
		root1.left = new Tree(3);
		root1.left.left = new Tree(4);
		root1.right = new Tree(1);
		
		root2 = new Tree(2);
		root2.right = new Tree(3);
		root2.right.right = new Tree(0);
		root2.left = new Tree(1);
		
		System.out.println(isMirrorToEachOther(root1,root2));

	}

}
