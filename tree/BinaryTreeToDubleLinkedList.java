package tree;

public class BinaryTreeToDubleLinkedList {
	
	static Tree root;
	
	static Tree headList;
	static Tree tail;
	
	public static void convert(Tree root) {
		if(root == null)
			return ;
		convert(root.left);
		
		if(tail == null) {
			headList = root;
		} else {
			root.left = tail;
			tail.right = root;
		}
		tail = root;
		
		convert(root.right);
	}
	
	public static void print(Tree root) {
		while(root != null) {
			System.out.print(root.data + " ");
			root = root.right;
		}
	}

	public static void main(String[] args) {
		//create the nodes
		root = new Tree(2);
		root.left = new Tree(7);
		root.right = new Tree(5);
		root.left.left = new Tree(1);
		root.left.right = new Tree(6);
		root.left.right.left = new Tree(5);
		root.left.right.right = new Tree(11);
		root.right.right = new Tree(9);
		root.right.right.left = new Tree(4);
		
		convert(root);
		print(headList);

	}

}
