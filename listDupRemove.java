public class listDupRemove {
/*
 * Q2.1
 * Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
	
 * idea: iterate the list, compare the current node with rest of the list
 * O(n^2)
 * 
 */
	
	public static void main(String[] args){
		String a = "FOLLOW ME";
		System.out.println("Input: "+ a);
		System.out.println("Output without dup: " );		
		print(findHead(removeDup(initialize(a),initialize(a).next)));
	}
	
	
	static dNode findHead(dNode tail){
		while(tail.pre != null){
			tail = tail.pre;
		}
		return tail;
	}
	static void print(dNode head){
		System.out.print(head.value());
		if(head.next != null){
			print(head.next);
		}
	}
	
	static dNode initialize(String s){
		dNode head = new dNode(s.charAt(0));
		dNode current = head;
		for(int i = 1; i < s.length(); i ++){
			dNode n = new dNode(s.charAt(i));
			current.next = n;
			n.pre = current;
			current = n;
		}
		return head;
	}
	
	
	static dNode removeDup( dNode current, dNode target){
		if(current.next == null)	return current;
		if(target == null) return removeDup(current.next,current.next.next);
		if(current.value() == target.value()){
//			System.out.println("Find dup: "+current.value());
			target.pre.next = target.next;
			dNode newTarget = target.next;
			target.next.pre = target.pre;
			target.pre = null;
			target.next = null;
			return removeDup(current,newTarget);
		}else{
			return removeDup(current, target.next);
		}
	}
}
