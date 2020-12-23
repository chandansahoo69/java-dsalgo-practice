package binarySearchTree;

//import java.util.ArrayList;
import java.util.Arrays;

class Node{
	int data;
	Node left,right;
	
	public Node(int data) {
		this.data = data;
		left = right = null;
	}
	public Node() {}
}

class LinkedList{
	int data;
	LinkedList next;
	public LinkedList(int data) {
		this.data = data;
		next = null;
	}
	public LinkedList() {
		// TODO Auto-generated constructor stub
	}
}

public class InsertionInBinaryTree {
	
	static int countNodes(Node node) {
		if(node == null)
			return 0;
		if(node.left == null && node.right == null)
			return 1;
		return countNodes(node.left) + countNodes(node.right);
	}
	
	public static Node insert(Node node, int val) {
		if(node == null) {
			node = new Node(val);
			return node;
		}
		if(val < node.data)
			node.left = insert(node.left, val);
		else if(val > node.data)
			node.right = insert(node.right, val);
		
		return node;
	}
	
	static int inorderPredecessor(Node root) {
		//once we have to go left then right
		root = root.left;
		while(root.right != null)
			root = root.right;
		return root.data;
	}
	static int inorderSuccesser(Node root) {
		root = root.right;
		while(root.left != null)
			root = root.left;
		return root.data;
	}
	
	public static Node delete(Node root, int val) {
		//if the node is null then return null
		if(root == null)
			return root;
		//if the value is small than the root then go left
		if(val < root.data)
			root.left = delete(root.left, val);
		//if the value is greater then go right
		else if(val > root.data)
			root.right = delete(root.right, val);
		//if the value is matching then delete the value
		else {
			if(root.left == null && root.right == null)
				root = null;
			else if(root.left != null) {
				//find inorder predecessor
				root.data = inorderPredecessor(root);
				root.left = delete(root.left, root.data);
			}
			else if(root.right != null) {
				//find inorder successor
				root.data = inorderSuccesser(root);
				root.right = delete(root.right, root.data);
			}
		}
		return root;
	}
	
	static void inOrder(Node root) {
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	static void preOrder(Node root) {
		if(root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	static void postOrder(Node root) {
		if(root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	static boolean isNodePresent(Node root, int val) {
		if(root == null)
			return false;
		boolean isPresent = false;
		while(root != null) {
			if(val == root.data) {
				isPresent = true;
				break;
			}
			else if(val < root.data)
				root = root.left;
			else if(val > root.data)
				root = root.right;
		}
		return isPresent;
	}
	
	static Node getParrentOfNode(Node root, int val) {
		if(root == null)
			return root;
		Node getParrent = null;
		
		while(root != null) {
			if(val < root.data) {
				getParrent = root;
				root = root.left;
			} else if(val > root.data) {
				getParrent = root;
				root = root.right;
			} else
				break;
		}
		
		return root != null ? getParrent : null;
	}
	
	public static int sumOfLeafNodes(Node root)
    {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return root.data;
        return sumOfLeafNodes(root.left) + sumOfLeafNodes(root.right);
    }
	
	static int count;
	
	static void countNodeInGivenRange(Node root, int l, int r) {
		if(root == null)
			return ;
		if(root.data >= l && root.data <= r)
			count++;
		if(l<root.data)
			countNodeInGivenRange(root.left, l, r);
		if(r>root.data)
			countNodeInGivenRange(root.right, l, r);
	}
	
	static int sum;
	
	static void addAllGreaterValueToveryNode(Node root) {
		if(root == null)
			return ;
		addAllGreaterValueToveryNode(root.right);
		
		sum = sum + root.data;
		root.data = sum;
		
		addAllGreaterValueToveryNode(root.left);
	}
	
	static Node checkForBalancedBST(int a[]) {
		Arrays.sort(a);
		return createBalancedBST(a, 0, a.length-1);
	}
	
	static Node createBalancedBST(int a[], int start, int end) {
		if(start > end)
			return null;
		
		int mid = (start + end) / 2;
		
		Node demo = new Node(a[mid]);
		
		demo.left = createBalancedBST(a, start, mid-1);
		demo.right = createBalancedBST(a, mid+1, end);
		
		return demo;
	}
	
	static boolean checkForBST(Node root) {
		return checkForBSTUtill(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}
	static boolean checkForBSTUtill(Node root, int l, int r) {
		if(root == null)
			return true;
		if(root.data < l || root.data > r)
			return false;
		return (checkForBSTUtill(root.left, l, root.data-1) && 
				checkForBSTUtill(root.right, root.data+1, r));
	}
	
	static boolean checkForDeadEnd(Node root) {
		return checkForDeadEndUtill(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	static boolean checkForDeadEndUtill(Node root, int l, int r) {
		if(root == null)
			return false;
		
		if(root.left == null && root.right == null) {
			if(l == r) {
				return true;
			}
		}
		return (checkForDeadEndUtill(root.left, l, root.data-1) 
				|| checkForDeadEndUtill(root.right, root.data+1, r));
	}
		
	class K{
		int k=0;
	}
	
	Node KthSmallestElementUtil(Node root, int k) {
		K o = new K();
		o.k = k;
		return KthSmallestElement(root, o);
	}
	
	static Node KthSmallestElement(Node root, K o) {
		if(root == null)
			return null;
		Node left = KthSmallestElement(root.left, o);
		
		if(left != null)
			return left;
		
		o.k--;
		if(o.k == 0) {
			return root;
		}
		
		return KthSmallestElement(root.right, o);
	}
	
	Node KthLargestElementUtil(Node root, int k) {
		K o = new K();
		o.k = k;
		return KthSmallestElement(root, o);
	}
	
	static Node KthLargestElement(Node root, K o) {
		if(root == null)
			return null;
		Node left = KthLargestElement(root.right, o);
		
		if(left != null)
			return left;
		
		o.k--;
		if(o.k == 0) {
			return root;
		}
		
		return KthLargestElement(root.left, o);
	}
	
//	static int sum1 = 0;
	
	void BSTtoSumOfSmallerKeyUtil(Node root) {
		K o = new K();
		BSTtoSumOfSmallerKey(root, o);
	}
	
	static void BSTtoSumOfSmallerKey(Node root, K o) {
		if(root == null)
			return ;
		BSTtoSumOfSmallerKey(root.left, o);
		
		o.k += root.data;
		root.data = o.k;
		
		BSTtoSumOfSmallerKey(root.right, o);
	}
	
	void BSTtoGreaterSumTree(Node root) {
		K o = new K();
		BSTtoGreaterSumTreeUtil(root, o);
	}
	
	static void BSTtoGreaterSumTreeUtil(Node root, K o) {
		if(root == null)
			return ;
		BSTtoGreaterSumTreeUtil(root.right, o);
		
		o.k += root.data;
		root.data = o.k;
		
		BSTtoGreaterSumTreeUtil(root.left, o);
	}
	
	Node BSTfromPreOrder(int a[]) {
		K o = new K();
		o.k = 0;
		int size = a.length;
		return BSTfromPreOrderUtil(a,size,Integer.MIN_VALUE,Integer.MAX_VALUE,o);
	}
	
	static Node BSTfromPreOrderUtil(int a[],int size,int l,int r,K o) {
		if(l > r)
			return null;
		if(o.k >= size)
			return null;
		if(a[o.k] < l || a[o.k] > r)
			return null;
		//make a node first bcz pre = NLR
		Node root = new Node(a[o.k]);
		//store the value of node to use in range
		int x = a[o.k];
		//increment the ptr 
		o.k++;
		//call the left and right tree
		root.left = BSTfromPreOrderUtil(a,size,l,x-1,o);
		root.right = BSTfromPreOrderUtil(a,size,x+1,r,o);
		//then return the root
		return root;
	}
	
	Node BSTfromPostOrder(int a[]) {
		K o = new K();
		o.k = a.length - 1;
		return BSTfromPostOrderUtil(a,Integer.MIN_VALUE,Integer.MAX_VALUE,o);
	}
	
	static Node BSTfromPostOrderUtil(int a[], int l, int r, K o) {
		if(l>r)
			return null;
		if(o.k < 0)
			return null;
		if(a[o.k] < l || a[o.k] > r)
			return null;
		
		int x = a[o.k];
		Node root = new Node(a[o.k]);
		o.k--;
		root.left = BSTfromPostOrderUtil(a, l, x-1, o);
		root.right = BSTfromPostOrderUtil(a, x+1, r, o);
		
		return root;
		
	}
	
	static Node LowestCommonAnsector(Node root, int a, int b) {
		//base case
		if(root == null)
			return root;
		//it will handel two cases lfskewtree 2-3 and 
		//rtskewtree 2-3 
		if(root.data == a || root.data == b)
			return root;
		
		Node l = LowestCommonAnsector(root.left, a, b);
		Node r = LowestCommonAnsector(root.right, a, b);
		//if a and b are in both the part then it handeled in this
		if(l != null && r != null)
			return root;
		//if it present at left tree then return
		if(l != null)
			return l;
		//if it present at right tree then return 
		if(r != null)
			return r;
		//unless return null if no one is present
		return null;
	}
	
//	class C{
//		ArrayList<Integer> a = new ArrayList<>();
//	}
//	
//	ArrayList<Integer> PreOrderToPostOrderUtil(int pre[]) {
//		C o = new C();
//		PreOrderToPostOrder(pre, 0, pre.length - 1, o);
//		return o.a;
//	}
//	
//	static int nextGreater(int pre[], int l, int r) {
//		int i;
//		for (i = r; i > l; i--) {
//			if(pre[i] < pre[r])
//				return i;
//		}
//		return i;
//	}
//	
//	static void PreOrderToPostOrder(int pre[], int l, int r, C o) {
//		if(l > r)
//			return ;
//				
//		int g = nextGreater(pre, l, r);
//		
//		o.a.add(pre[l]);
//		
//		PreOrderToPostOrder(pre, l, g, o);
//		PreOrderToPostOrder(pre, g+1, r-1, o);		
//		
//	}
	
//	LinkedList head;
//	
//	static void push(int data) {
//		InsertionInBinaryTree o = new InsertionInBinaryTree();
//		LinkedList newNode = new LinkedList(data);
//		newNode.next = o.head;
//		o.head = newNode;
//	}
//	
//	class List{
//		InsertionInBinaryTree o = new InsertionInBinaryTree();
//		LinkedList node = new LinkedList();
//	}
	
//	static Node LinkedListToBalancedBST(LinkedList head) {
//		InsertionInBinaryTree o = new InsertionInBinaryTree();
//		return LinkedListToBalancedBSTUtil(o.head, 5);
//	}
//	static Node LinkedListToBalancedBSTUtil(InsertionInBinaryTree o, int n) {
//		if(n == 0)
//			return null;
//		
//		Node root = new Node();
//		root.left = LinkedListToBalancedBSTUtil(o, n/2);
//		
//		root.data = o.head.data;
//		o.head = o.head.next;
//		
//		root.right = LinkedListToBalancedBSTUtil(o, n/2);
//		
//		return root;
//	}
	
//	static void kthLargestElement(Node root, int k , )
	
//	static Node BSTFromLevelOrder(int []a) {
//		List<int[]> arr = Arrays.asList(a);
//		return ConvertToBSTFormLevelOrder(arr);
//	}
	
//	static Node ConvertToBSTFormLevelOrder(List<int[]> arr) {
//		if(arr.size() == 0)
//			return null;
//		
//		Node root = new Node((Integer) arr.get(0));
//		
//		ArrayList<Integer> arr1 = new ArrayList<>();
//		ArrayList<Integer> arr2 = new ArrayList<>();
//		
//		for (int i = 1; i < arr.size(); i++) {
//			if((Integer) arr.get(i) < (Integer)arr.get(0))
//				arr1.add((Integer) arr.get(i));
//			else
//				arr2.add((Integer) arr.get(i));
//		}
//		
//		root.left = ConvertToBSTFormLevelOrder(arr1);
//		root.right = ConvertToBSTFormLevelOrder(arr2);
//		
//		return root;
//	}
	public static void main(String[] args) {
		 Node root = null;
		 root = insert(root, 12);
		 root = insert(root, 9);
		 root = insert(root, 10);
		 root = insert(root, 8);
		 root = insert(root, 13);
		 root = insert(root, 14);
		 root = insert(root, 15);
		 		 
		 //print the inorder value
//		 inOrder(root);
		 
//		 root = delete(root, 8);
//		 System.out.println("Inorder Traversal: ");
//		 inOrder(root);
//		 
//		 System.out.println("\nPreorder Traversal: ");
//		 preOrder(root);
//		 
//		 System.out.println("\nPostorder Traversal: ");
//		 postOrder(root);
//		 System.out.println(isNodePresent(root, 13));
		 
		 //to get the parent of a particular node 
//		 Node parrentNode = getParrentOfNode(root, 0);
//		 if(parrentNode != null)
//			 System.out.println(parrentNode.data);
//		 else
//			 System.out.println("parrentNode is not present");
		 
		 //count the no of leaf node are present;
//		 System.out.println(countNodes(root));
		 
//		 countNodeInGivenRange(root, 0, 20);
//		 System.out.println(count);
		 
//		 addAllGreaterValueToveryNode(root);
//		 inOrder(root);
		 
//		 int[] a = {3,2,4,5,1,8,9};
//		 Node temp = checkForBalancedBST(a);
//		 inOrder(temp);
		 
//		 System.out.println(checkForBST(root));
//		 System.out.println(checkForDeadEnd(root));
		 
//		 int []a = new int[]{1,2,3,4,5};
//		 Node temp = BSTFromLevelOrder(a);
//		 inOrder(temp);
		 
		 
//		 InsertionInBinaryTree o = new InsertionInBinaryTree();
//		 Node temp = o.KthSmallestElementUtil(root, 5);
//		 if(temp != null)
//			 System.out.println(temp.data);
//		 else
//			 System.out.println("null");
		 
//		 InsertionInBinaryTree o = new InsertionInBinaryTree();
//		 o.BSTtoSumOfSmallerKeyUtil(root);
//		 inOrder(root);
		 
//		 InsertionInBinaryTree o = new InsertionInBinaryTree();
//		 o.BSTtoGreaterSumTree(root);
//		 inOrder(root);
		 
//		 push(1);
//		 push(2);
//		 push(3);
//		 push(4);
//		 push(5);
		 
//		 InsertionInBinaryTree o = new InsertionInBinaryTree();
//		 Node root = LinkedListToBalancedBST(o.head);
//		 inOrder(root);
		
//		int a[] = {1, 2 , 3, 4, 5};
//		InsertionInBinaryTree o = new InsertionInBinaryTree();
//		ArrayList<Integer> c = new ArrayList<>();
//		c = o.PreOrderToPostOrderUtil(a);
//		System.out.println(c);
		 
		//Bst construction form pre and post
//		int a[] = {40, 30, 35, 45, 60, 65};
//		InsertionInBinaryTree o = new InsertionInBinaryTree();
////		Node temp1 = o.BSTfromPreOrder(a);
////		inOrder(temp1);
//		
//		Node temp2 = o.BSTfromPostOrder(a);
//		inOrder(temp2);
		
		//LowestCommonAnsector in binary tree
		
		Node n = LowestCommonAnsector(root, 12, 14);
		if(n == null)
			System.out.println("LowestCommonAnsector dosent exist");
		else
			System.out.println(n.data);
	}

}
