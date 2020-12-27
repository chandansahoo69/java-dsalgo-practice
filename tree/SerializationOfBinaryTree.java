package tree;

import java.util.ArrayList;

public class SerializationOfBinaryTree {
	
	static Tree root;
	
	class ar{
		ArrayList<Integer> a = new ArrayList<>();
	}
	
	void Serialized(Tree root) {
		ar o = new ar();
		SerializedUtil(root, o);
		System.out.println(o.a);
	}
	
	static void SerializedUtil(Tree root, ar o) {
		if(root == null) {
			o.a.add(-1);
			return ;
		}
		o.a.add(root.data);
		SerializedUtil(root.left, o);
		SerializedUtil(root.right, o);
	}

	public static void main(String[] args) {
		root = new Tree(4);
		root.left = new Tree(3);
		root.right = new Tree(2);
		root.left.left = new Tree(1);
		root.left.right = new Tree(9);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);
		
		SerializationOfBinaryTree o = new SerializationOfBinaryTree();
		o.Serialized(root);

	}

}
