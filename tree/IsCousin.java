package tree;

public class IsCousin {
	
	static Tree root;
	
	public static boolean Cousin(Tree root, Tree a, Tree b) {
		IsSiblings obj = new IsSiblings();
		GetLevelOfNode obj1 = new GetLevelOfNode();
		
		if(root == null)
			return false;
		if(obj1.GetLevel(root, a.data, 1) != obj1.GetLevel(root, b.data, 1))
			return false;
		return !obj.Siblings(root, a, b);
	}

	public static void main(String[] args) {
		//create the nodes
		root = new Tree(2);
		root.left = new Tree(7);
		root.right = new Tree(5);
		root.left.left = new Tree(2);
		root.left.right = new Tree(6);
		root.left.right.left = new Tree(5);
		root.left.right.right = new Tree(11);
		root.right.right = new Tree(9);
		root.right.right.left = new Tree(4);
		
		System.out.println(Cousin(root, root.left.right.left, root.right.right.left));

	}

}
