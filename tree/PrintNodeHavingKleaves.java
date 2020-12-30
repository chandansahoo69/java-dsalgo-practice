package tree;

import java.util.ArrayList;

public class PrintNodeHavingKleaves {
	
	class k {
        ArrayList<Integer> a = new ArrayList<>();
    }
    public ArrayList<Integer> btWithKleaves(Tree root, int k)
    {
        k o = new k();
        util(root, k,o);
        //if the list is empty then add -1 
        if(o.a.isEmpty())
            o.a.add(-1);
            
        return o.a;
    }
    static int util(Tree root, int k ,k o){
        //if the root is null then return 0
        if(root == null)
            return 0;
        //if it is a leaf node then return 1 so we add it 
        if(root.left == null && root.right == null)
            return 1;
        //Here any node having K leaves means sum of leaves in left 
        //subtree and in right subtree must be equal to K. So to solve
        //this problem we use Postorder traversal of tree. First we calculate
        //leaves in left subtree then in right subtree and if sum is equal to
        //K, then print current node. In each recursive call we return sum of 
        //leaves of left subtree and right subtree to it’s ancestor.
        //count the left and right part leaf node 
        int total = util(root.left , k, o) + util(root.right, k, o);
        //if the leaf node of both 
        if(k == total)
            o.a.add(root.data);
            
        return total;
    }
    
    static Tree root;

	public static void main(String[] args) {
		root = new Tree(1);  
	    root.left     = new Tree(2);  
	    root.right     = new Tree(4);  
	    root.left.left = new Tree(5);  
	    root.left.right = new Tree(6);  
	    root.left.left.left = new Tree(9);  
	    root.left.left.right = new Tree(10);  
	    root.right.right = new Tree(8);  
	    root.right.left = new Tree(7);  
	    root.right.left.left = new Tree(11);  
	    root.right.left.right = new Tree(12);  
	  
	    PrintNodeHavingKleaves o = new PrintNodeHavingKleaves();
	    System.out.println(o.btWithKleaves(root, 2));

	}

}
