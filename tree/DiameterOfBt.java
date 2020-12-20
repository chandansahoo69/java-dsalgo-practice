package tree;

public class DiameterOfBt {
	
	static Tree root;
	
	class d{
		int dia = 0;
	}
	
	int diaMeter(Tree root) {
		d o = new d();
		diaMeterUtil(root, o);
		return o.dia;
	}
	
	static int diaMeterUtil(Tree root, d o) {
		if(root == null)
			return 0;
		
		int l = diaMeterUtil(root.left, o);
		int r = diaMeterUtil(root.right, o);
		
		if(1 + l + r > o.dia)
			o.dia = 1 + l + r;
		
		return 1 + Math.max(l, r);
	}

	public static void main(String[] args) {
		root = new Tree(3);
		root.left = new Tree(1);
		root.right = new Tree(2);
		root.left.left = new Tree(1);
		root.left.left.left = new Tree(9);
		root.right.left = new Tree(6);
		root.right.right = new Tree(7);
		
		DiameterOfBt o = new DiameterOfBt();
		System.out.println(o.diaMeter(root));

	}

}
