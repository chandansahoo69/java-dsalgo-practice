package tree;

public class BinaryTreeFromPostAndInorder {
	
	class i{
		int ptr=0;
	}
	
	Tree constructBst(int post[], int in[]) {
		i o = new i();
		o.ptr = post.length - 1;
		return constructBstUtil(post, in, 0, post.length-1, o);
	}
	
	static Tree constructBstUtil(int post[], int in[], int s, int e, i o) {
		if(e<s)
			return null;
		
		Tree root = new Tree(post[o.ptr]);
		
		int mid = FindElmInInorder(in, s, e, post[o.ptr]);
		
		o.ptr--;
		
		root.right = constructBstUtil(post,in,mid+1,e,o);
		root.left = constructBstUtil(post,in,s,mid-1,o);
		
		return root;
	}
	
	static int FindElmInInorder(int in[], int s, int e, int elm) {
		int j;
		for ( j = e; j >= s; j--) {
			if(in[j] == elm) {
				return j;
			}
		}
		return j;
	}

	public static void main(String[] args) {
		int post[] = {1,9,3,6,7,2,4};
		int in[] = {1,3,9,4,6,2,7};
		
		BinaryTreeFromPostAndInorder o = new BinaryTreeFromPostAndInorder();
		
		Tree root = o.constructBst(post, in);
		BinaryTree b = new BinaryTree();
		System.out.print("InorderTraversal : ");
		b.InorderTraversal(root);
	}

}
