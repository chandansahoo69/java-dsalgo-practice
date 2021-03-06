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
		//create the node first
		Tree root = new Tree(post[o.ptr]);
		//then find the elm of post in in array 
		int mid = FindElmInInorder(in, s, e, post[o.ptr]);
		//then decrease the pointer 
		o.ptr--;
		//create the right part bcz in post order (l R N) 
		//the pointer is pointing to end of array when it decrease 
		//it will first encounter with right so 
		root.right = constructBstUtil(post,in,mid+1,e,o);
		root.left = constructBstUtil(post,in,s,mid-1,o);
		//return the root
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
