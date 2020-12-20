package tree;

public class LevelOrderTraversal {
	
	static Tree root;
	
	public static void Print(Tree root) {
		if(root == null)
			return;
		int height = getHeight(root);
		//bcz level of tree = height of tree + 1 
		for(int i=0; i<=height; i++) {
			PrintAtLevel(root, i+1);
			System.out.println();
		}
	}
	
	public static void PrintAtLevel(Tree root, int level) {
		if(root == null)
			return;
		if(level == 1) {
			System.out.print(root.data + " ");
			return;
		}
		PrintAtLevel(root.left, level -1);
		PrintAtLevel(root.right, level -1);		
	}
	
	public static int getHeight(Tree root) {
		if(root == null)
			return -1;
		return 1 + Max(getHeight(root.left) , getHeight(root.right));
	}
	
	public static int Max(int a, int b) {
		return a > b ? a : b;
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
		
		Print(root);
	}
}
