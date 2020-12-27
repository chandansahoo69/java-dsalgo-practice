package tree;

public class DeserializationofBinaryTree {
	
	class ds{
		int ptr;
	}
	
	Tree ds(int ds[]) {
		ds o = new ds();
		return dsUtil(ds, o);
	}
	
	static Tree dsUtil(int ds[], ds o) {
		if(ds[o.ptr] == -1) {
			o.ptr++;
			return null;
		}
		Tree root = new Tree(ds[o.ptr]);
		o.ptr++;
		root.left = dsUtil(ds, o);
		root.right = dsUtil(ds, o);
		return root;
	}

	public static void main(String[] args) {
		int ds[] ={4, 3, 1, -1, -1, 9, -1, -1, 2, 6, -1, -1, 7, -1,-1};
		
		DeserializationofBinaryTree o = new DeserializationofBinaryTree();
		
		Tree root = o.ds(ds);
		BinaryTree.PreorderTraversal(root);
	}

}
