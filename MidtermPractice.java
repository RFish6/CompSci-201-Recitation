
public class MidtermPractice {

	private class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int v, TreeNode l, TreeNode r) {
			
			val = v;
			left = l;
			right = r;
		}

	}

	private class ListNode {
		
		public int val;
		public ListNode next;
		
		public ListNode(int v, ListNode n) {
			
			val = v;
			next = n;
		}

	}
	
	//Test your methods
	public static void main(String[] args) {
		MidtermPractice mp = new MidtermPractice();
	}

	/* A child is running up a staircase with nn steps, and can hop either 1 step,
	2 steps, or 3 steps at a time. Implement a method to count how many possible ways
	the child can run up the stairs
	*/
	public int countWays(int n) {

	}

	/*Check to see if the left and right subtree are a mirror
	That means that if the left tree has a left child, the right tree must
	have a right child in the same spot with the same value
	*/
	public boolean isMirror(TreeNode root) {

	}

	/*Implement a function to check if a binary tree is balanced.  A balanced tree
	is defined to be a tree such that the heights of the 2 subtrees of any node 
	never differ by more than 1
	*/
	public boolean isBalanced(TreeNode root) {

	}

	/*Find the first common ancestor of 2 nodes in a binary tree
	*/
	public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {

	}

	//interatively find if a linked list is a palindrome
	public boolean isPalindromeIter(ListNode head) {

	}

	//recursively find if a linked list is a palindrome
	public boolean isPalindrome(ListNode head) {

	}	
	
	//needed for palindrome recursvive helper method
	private class PalinRes {
		ListNode node;
		boolean result;

		public PalinRes(ListNode n, boolean r) {
			node = n;
			result = r;
		}
	}
	
}

	