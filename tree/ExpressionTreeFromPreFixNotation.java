package tree;

class CharTree{
	char data;
	CharTree left;
	CharTree right;
	
	CharTree(char val){
		data = val;
		left = null;
		right = null;
	}
}

public class ExpressionTreeFromPreFixNotation {
	
	class l{
		int ptr = 0;
	}
	
	CharTree ExpressionTree(char pre[]) {
		l o = new l();
		o.ptr = 0;
		return ExpressionTreeUtil(pre, o);
	}
	
	static CharTree ExpressionTreeUtil(char pre[], l o) {
		//if the pointer exceed the size of the array then return 
		if(o.ptr == pre.length)
			return null;
		//create a node
		CharTree root = new CharTree(pre[o.ptr]); 

		//if it is a operator then move to the left and right part
		if(pre[o.ptr] == '+' || pre[o.ptr] == '-' || pre[o.ptr] == '*'
				|| pre[o.ptr] == '/' || pre[o.ptr] == '^' ) {
			//move the pointer to the next
			o.ptr++;
			root.left = ExpressionTreeUtil(pre, o);
			root.right = ExpressionTreeUtil(pre, o);
		}
		else
			o.ptr++; //move the pointer to the next
		
		//if it is a operand then the root is already created so
		//simple return 
		return root;
	}
	
	//preorder traversal
		public static void PreorderTraversal(CharTree root) {
			if(root == null)
				return ;
			System.out.print(root.data + " ");
			PreorderTraversal(root.left);
			PreorderTraversal(root.right);
		}
 
	public static void main(String[] args) {
		char pre[] = {'*','+','a','b','-','c','d'};
		ExpressionTreeFromPreFixNotation a = new ExpressionTreeFromPreFixNotation();
		CharTree root = a.ExpressionTree(pre);
		System.out.print("Pre orderTraversal : ");
		PreorderTraversal(root);
	}

}
