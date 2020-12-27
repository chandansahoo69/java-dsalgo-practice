package tree;

public class ExpressionTreeFromPostfixNotation {
	
	class zz{
		int ptr = 0;
	}
	
	CharTree PostFixExpressionTree(char post[]) {
		zz o = new zz();
		o.ptr = post.length - 1;
		return PostFixExpressionTreeUtil(post, o);
	}
	
	static CharTree PostFixExpressionTreeUtil(char post[], zz o) {
		if(o.ptr < 0)
			return null;
		
		CharTree root = new CharTree(post[o.ptr]);
		
		if(post[o.ptr] == '+' || post[o.ptr] == '-' || post[o.ptr] == '*'
				|| post[o.ptr] == '/' || post[o.ptr] == '^' ) {
			o.ptr--;
			root.right = PostFixExpressionTreeUtil(post, o);
			root.left = PostFixExpressionTreeUtil(post, o);
		}
		else
			o.ptr--;
		return root;
	}
	
	//postorderTraversal
		public static void PostorderTraversal(CharTree root) {
			if(root == null)
				return ;
			PostorderTraversal(root.left);
			PostorderTraversal(root.right);
			System.out.print(root.data + " ");
		}

	public static void main(String[] args) {
		char post[] = {'a','b','+','c','d','-','*'};
		
		ExpressionTreeFromPostfixNotation a = new ExpressionTreeFromPostfixNotation();
		CharTree root = a.PostFixExpressionTree(post);
		System.out.print("Postorder Traversal : ");
		PostorderTraversal(root);
	}

}
