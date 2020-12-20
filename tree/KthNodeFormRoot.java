package tree;

import java.util.ArrayList;

public class KthNodeFormRoot {
	
	static Tree root;
	
	class K{
		ArrayList<Integer> a = new ArrayList<>();
	}
	
	ArrayList<Integer> KthNode(Tree root, int k){
		K o = new K();
		KthNodeUtil(root, k, o);
		return o.a;
	}
	
	static void KthNodeUtil(Tree root, int k, K o) {
		if(root == null)
			return ;
		if(k == 0) {
			o.a.add(root.data);
			return ;
		}
		KthNodeUtil(root.left, k-1, o);
		KthNodeUtil(root.right, k-1, o);
	}

	public static void main(String[] args) {
		
		root = new Tree(4);
		root.left = new Tree(3);
		root.right = new Tree(2);
		root.left.left = new Tree(1);
		root.left.right = new Tree(9);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);
		
		KthNodeFormRoot o = new KthNodeFormRoot();
		System.out.println(o.KthNode(root, 2));

	}

}
