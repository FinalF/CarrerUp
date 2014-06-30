public class moveAroundX {
/*
 * 
 * Write code to partition a linked list around a value x, such that all nodes less than
x come before all nodes greater than or equal to x.

 *idea: loop the list one time, 
 *		if >x, move it to the tail
 *		if < x, move it to the head 
 * O(n)
 */
	
	public static void main(String[] args){
		String a = "aegfcdb";
		System.out.println("Input: "+ a);
		System.out.println("Output with order around X: " );		
		dNode head = initialize(a);
		dNode tail = findTail(head);
//		int l= length(head);
		print(move(head,tail,head,'c'));
	}
	
	
	static void print(dNode head){
		System.out.print(head.value());
		if(head.next != null){
			print(head.next);
		}
	}

	
	static dNode findTail(dNode head){
		while(head.next != null){
			head = head.next;
		}
		return head;
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
	
	static dNode move(dNode head,dNode tail, dNode current,  char x){
		dNode endNode=tail;
		while(current!=null){
				dNode newCurrent = current.next;
			if(current.pre!=null && current.next!= null){
//				System.out.println("node: "+current.value()+" pre: "+current.pre.value()+" next: "+current.next.value());
			}
			if(current.value()!=x){
				if(current.pre!=null)//exclude the special case
					current.pre.next = current.next;
				if(current!=head && current.next!=null)
					current.next.pre = current.pre;
				if(current.value()>x){
						current.pre = tail;
						current.next = null;
						tail.next = current;
						tail = current;
				}else{
					if(current!=head){
						current.pre = null;
						current.next = head;
						head.pre=current;
						head = current;
					}
				}
			}
			if(current==endNode) return head;
			current = newCurrent;
		}

		return head;
	}

}
