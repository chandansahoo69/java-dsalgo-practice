package tree;

public class PrintDataAtGivenLevel {
	static Tree root;
	
	public static void PrintLevel(Tree root, int level) {
		if(root == null) {
			return ;
		}
		if(level == 1) {
			System.out.print(root.data + " ");
			return ;
		}
		
		PrintLevel(root.left, level - 1);
		PrintLevel(root.right, level - 1);
	}
	
	public static void main(String[] args) {
		
		//create the nodes
		root = new Tree(4);
		root.left = new Tree(3);
		root.right = new Tree(2);
		root.left.left = new Tree(1);
		root.left.right = new Tree(9);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);
		
		PrintLevel(root, 3);
		
	}
}
