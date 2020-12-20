package tree;

public class GetLevelOfNode {
	
	static Tree root;
	
	int GetLevel(Tree root, int elm, int level) {
		if(root == null)
			return 0;
		int l;
		
		if(root.data == elm)
			return level;
		
		l = GetLevel(root.left, elm, level + 1);
		
		if(l != 0)
			return l;
		
		l = GetLevel(root.right, elm, level + 1);
		
		 return l;
	}

	public static void main(String[] args) {
		
		GetLevelOfNode obj = new GetLevelOfNode();
		
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
				
				System.out.println(obj.GetLevel(root, 11, 1));

	}

}
