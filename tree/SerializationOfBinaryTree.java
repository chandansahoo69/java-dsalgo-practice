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
		//if it null then add the value -1 so that when we 
		//deseriallized the value then will now that the value 
		//containing -1 after it is a leaf node
		if(root == null) {
			o.a.add(-1);
			return ;
		}
		//add the value in pre order manner when leaf node comes then 
		//add -1 in base case
		o.a.add(root.data);
		//call the left and right part
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