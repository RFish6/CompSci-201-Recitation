// TODO Add your names and NetIDs below (comma-separated)
/*
 * Linked list practice code
 * 
 * SUBMIT-NAMES:
 * SUBMIT-NetIDs:
 */
public class ListNode {
    String info;
    ListNode prev;   
    ListNode next;
    
    public ListNode(String s, ListNode before, ListNode after){
        info = s;
        prev = before;
        next = after;
    }

    /**
     * @returns the node whose info field is largest (alphabetically), 
     * null if list is null
     */
    public static ListNode maxNodeIter (ListNode  list) {
        // TODO Complete iterative version of maxNode
    	if(list == null) {
    		return null;
    	}
    	
    	ListNode cur = list;
    	ListNode largest = list;
    	while (cur != null) {
    		if(cur.info.compareTo(largest.info) > 0) {
    			largest = cur;
    		}
    		cur = cur.next;
    	}
    	
    	return largest;
    }

    /**
     * @returns the node whose info field is largest (alphabetically), 
     * null if list is null. Should be recursive
     */
    public static ListNode maxNode (ListNode  list) {
        // TODO Complete recursive version of maxNode
        return maxNodeHelper(list, list);
    }
    
    private static ListNode maxNodeHelper(ListNode list, ListNode largest) {
    	if(list == null) {
    		return largest;
    	}
    	
    	if(list.info.compareTo(largest.info) >= 0) {
    		return maxNodeHelper(list.next, list);
    	}
    	else {
    		return maxNodeHelper(list.next, largest);
    	}
    }

    /**
     * Move node containing word to front of list and
     * return modified list. If word not found, no changes
     * made to list, original list returned
     * @param list is list being modified
     * @param word is targetted node for move-to-font
     * @return first node in possibly modified list.
     */
    public static ListNode moveToFront(ListNode list, String word) {
        ListNode first = list;
        ListNode wordToMove = null;
        
        while(first != null) {
        	if(first.info.equals(word)) {
        		wordToMove = first;
        		break;
        	}
        	
        	first = first.next;
        }
        
        if(wordToMove == null) {
        	return list;
        }
        
        wordToMove.prev.next = wordToMove.next;
        wordToMove.next.prev = wordToMove.prev;
        wordToMove.prev = null;
        wordToMove.next = list;
        
        return wordToMove;
    }
    
    private static void printList(ListNode list) {
    	ListNode cur = list;
    	while(cur != null) {
    		System.out.print(cur.info + " ");
    		cur = cur.next;
    	}
    	System.out.println(" ");
    }

    public static void main(String[] args) {
        // TODO make a list ("A", "B", "C", "D")
    	ListNode a = new ListNode("A", null, null);
    	ListNode b = new ListNode("B", a, null);
    	ListNode c = new ListNode("C", b, null);
    	ListNode d = new ListNode("D", c, null);
    	ListNode e = new ListNode("E", d, null);
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	d.next = e;
    	
    	System.out.println(maxNode(a).info);
    	System.out.println(maxNodeIter(a).info);
    	
    	ListNode res2 = moveToFront(a, "F");
    	printList(res2);
    	ListNode res = moveToFront(a, "D");
    	printList(res);
    	
    }
}
