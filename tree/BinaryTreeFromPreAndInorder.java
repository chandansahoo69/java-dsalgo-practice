package tree;

public class BinaryTreeFromPreAndInorder {
	
	class k {
		int ptr = 0;
	}
	
	Tree constructBst(int pre[], int in[]) {
		k o = new k();
		return constructBstUtil(pre, in, 0, pre.length-1, o);
	}
	
	static Tree constructBstUtil(int pre[],int in[], int l, int r, k o) {
		if(l > r)
			return null;
		//create a node bcz we are construct in preorder
		Tree root = new Tree(pre[o.ptr]);
		//then find the elm of post in in array 
		int mid = findInInorder(in,l,r,pre[o.ptr]);
		//increase the pointer
		o.ptr++;
		//create the right part bcz in post order (N L R) 
		//the pointer is pointing to end of array when it increase 
		//it will first encounter with left so 
		root.left = constructBstUtil(pre, in, l, mid-1,o);
		root.right = constructBstUtil(pre, in, mid+1, r,o);
		//return root
		return root;
	}
	
	static int findInInorder(int a[], int l, int r, int elm) {
		int i = 0;
		for (i = l; i < r; i++) {
			if(a[i] == elm)
				return i;
		}
		return i;
	}
	

	public static void main(String[] args) {
		int pre[] = {4,3,1,9,2,6,7};
		int in[] = {1,3,9,4,6,2,7};
		
		BinaryTreeFromPreAndInorder o = new BinaryTreeFromPreAndInorder();
		
		Tree root = o.constructBst(pre, in);
		BinaryTree b = new BinaryTree();
		System.out.print("InorderTraversal : ");
		b.InorderTraversal(root);
		System.out.println();
		
	}

}
