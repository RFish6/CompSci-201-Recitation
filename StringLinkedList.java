public class StringLinkedList implements Comparable<StringLinkedList> {

	private class Node {
		String myValue;
		Node myNext;

		Node(String value, Node next) {
			myValue = value;
			myNext = next;
		}
	}

	// You can add other instance variables, but you may then
	// need to update other methods
	Node myHead;

	// BE SURE YOU TEST THIS CODE WORKS WITH THE StringLinkedListTester
	// BEFORE YOU SUBMIT!

	/**
	 * Adds a new node with valueToAdd as value to the <em>end</em> of this
	 * linked list
	 */
	public void addAtEnd(String valueToAdd) {
		// TODO 1. Complete addAtEnd
		
		if(myHead == null) {
			myHead = new Node(valueToAdd, null);
			return;
		}
		Node cur = myHead;
		while(cur.myNext != null) {
			cur = cur.myNext;
		}
		
		cur.myNext = new Node(valueToAdd, null);

	}

	/**
	 * Adds a new node with valueToAdd as value to the <em>beginning</em> of
	 * this linked list
	 */
	public void addAtBeginning(String valueToAdd) {
		myHead = new Node(valueToAdd, myHead);
	}

	/**
	 * Removes the longest string from the list,
	 * 
	 * if you have the list [a,b,longstring,z,q] after this function runs you
	 * end up with [a,b,z,q] if more than one string has the same longest
	 * length, remove the first one if the list is empty, do nothing if the list
	 * has only 1 element, remove it
	 */
	public void removeLongestString() {
		// TODO 2 Complete removeLongestString
		// when you implement this function, be sure to think about
		// a. what if the list is empty
		// b. what if the longest element is the first element
		// c. what if the list has only 1 element
		if(myHead == null) {
			return;
		}
		if(myHead.myNext == null) {
			myHead = null;
			return;
		}
		
		Node cur = myHead;
		int maxLength = 0;
		while(cur != null) {
			int len = cur.myValue.length();
			if(len > maxLength) {
				maxLength = len;
			}
			cur = cur.myNext;
		}
		
		cur = myHead;
		Node prev = null;
		while(cur != null) {
			if(cur.myValue.length() == maxLength) {
				if(prev != null) {
					prev.myNext = cur.myNext;
				}
				else {
					myHead = cur.myNext;
				}
				return;
			}
			
			prev = cur;
			cur = cur.myNext;
		}
		
		

	}

	/**
	 * Repeats (doubles) each element [a,b,c] -> [a,a,b,b,c,c]
	 */
	public void doubleList() {
		// TODO 3. Complete doubleList
		// it should be short. Mine was 5 lines
		Node cur = myHead;
		while(cur != null) {
			Node next = cur.myNext;
			cur.myNext = new Node(cur.myValue, next);
			cur = cur.myNext.myNext;
		}
	}

	/**
	 * Move k elements from the beginning of the list to the end [a,b,c,d,e] ->
	 * moveToEnd(2) -> [c,d,e,a,b]
	 */
	public void moveToEnd(int k) {
		// TODO 4. completeMoveToEnd
		Node cur = myHead;
		while(cur.myNext != null) {
			cur = cur.myNext;
		}
		
		Node end = cur;
		cur = myHead;
		
		while(k > 0) {
			end.myNext = cur;
			end = cur;
			cur = cur.myNext;
			end.myNext = null;		
			k--;
		}
		myHead = cur;
		
	}

	public String toString() {
		// I've written this one for you!
		StringBuilder b = new StringBuilder();
		Node current = myHead;
		while (current != null) {
			b.append(current.myValue);
			// this is a little crude because it prints out a blank for last
			// element too
			// I opted to keep the code extra simple rather than print right
			b.append(" ");
			current = current.myNext;
		}
		return b.toString();
	}

	/**
	 * Implements a natural ordering on lists To compare string lists, first
	 * compare 1st elements, than second elements, etc. using the standard
	 * lexicographic string comparison. (e.g. [a z c] < [aa b c]) If one list
	 * has the same starting elements as another, but is shorter (e.g. [a] and
	 * [a b]) the shorter one is less if two StringLists have the same elements
	 * and are are the same length, then they are equal
	 */
	public int compareTo(StringLinkedList other) {
		// TODO 5. complete compareTo
		Node cur = myHead;
		Node otherCur = other.myHead;
		while(cur != null && otherCur != null) {
			int cmpTo = cur.myValue.compareTo(otherCur.myValue);
			if(cmpTo != 0) {
				return cmpTo;
			}
			cur = cur.myNext;
			otherCur = otherCur.myNext;
		}
		
		if(cur == null && otherCur != null) {
			return -1;
		}
		
		else if(cur != null && otherCur == null){
			return 1;
		}
		
		return 0;
	}

}
