package tree;

public class CheckIfTwoNodesAreInSamePath {
	
	static Tree root;
	
	class check {
		boolean flag = true;
	}
	
	boolean Util(Tree root, int a, int b) {
		check o = new check();
		LowestCommonAnsector(root, a, b, o);
		return o.flag;
	}
	
	static Tree LowestCommonAnsector(Tree root, int a, int b, check o) {
		//base case
		if(root == null)
			return root;
		//it will handel two cases lfskewtree 2-3 and 
		//rtskewtree 2-3 
		if(root.data == a || root.data == b)
			return root;
		
		Tree l = LowestCommonAnsector(root.left, a, b, o);
		Tree r = LowestCommonAnsector(root.right, a, b, o);
		//if a and b are in both the part then it handled in this case
		if(l != null && r != null) {
			//as it handle the third case i.e a and b are present
			//at different side so the never comes in same path
			o.flag = false;
			return root;
		}
		//if it present at left tree then return
		if(l != null)
			return l;
		//if it present at right tree then return 
		if(r != null)
			return r;
		//unless return null if no one is present
		return null;
	}

	public static void main(String[] args) {
		root = new Tree(4);
		root.left = new Tree(3);
		root.right = new Tree(2);
		root.left.left = new Tree(1);
		root.left.left.left = new Tree(10);
		root.left.left.left.left = new Tree(11);
		root.left.right = new Tree(9);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);
		
		CheckIfTwoNodesAreInSamePath o = new CheckIfTwoNodesAreInSamePath();
		boolean t = o.Util(root, 10,11);
		System.out.println(t);
	}

}
