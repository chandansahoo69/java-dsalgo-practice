package tree;

public class LeftViewOfTree {
	static int maxLeftLevel,maxRightLevel;
	
	public static void LeftView(Tree root, int level) {
		if(root == null)
			return ;
		if(level >= maxLeftLevel) {
			System.out.print(root.data + " ");
			maxLeftLevel++;
		}
		LeftView(root.left, level + 1);
		LeftView(root.right, level + 1);
		
	}
	
	public static void RightView(Tree root, int level) {
		if(root == null)
			return ;
		if(level >= maxRightLevel) {
			System.out.print(root.data + " ");
			maxRightLevel++;
		}
		RightView(root.right, level + 1);
		RightView(root.left, level + 1);
	}
	
	static Tree root;

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
				System.out.println("Left view :");
				LeftView(root, 0);
				System.out.println("\nRight view :");
				RightView(root, 0);

	}

}
