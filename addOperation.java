public class addOperation {

	public static void main(String[] args){
		int[] a = {7,1,6};
		int[] b = {5,9,2};
		System.out.println("Output A: " + addListA(initialize(a),initialize(b)));	
		int[] c = {6,1,7};
		int[] d = {2,9,5};
		System.out.println("Output B: " + addListB(initialize(c),initialize(d)));	
	}
	
	
	
	static int addListA(sNode n1, sNode n2){
		int N1 = n1.valueD();
		int i = 1;
		while(n1.next != null){
			n1 = n1.next;
			N1+=n1.valueD()*Math.pow(10, i);
			i++;
		}
		
		int N2 = n2.valueD();
		i = 1;
		while(n2.next != null){
			n2 = n2.next;
			N2+=n2.valueD()*Math.pow(10, i);
			i++;
		}	
		System.out.println("Add two numbers: "+ N1+" + "+ N2);
		return N1+N2;
	}
	
	
	static int addListB(sNode n1, sNode n2){
		int i = getL(n1);
		double N1 = n1.valueD()*Math.pow(10, i-1);
		while(n1.next != null){
			n1 = n1.next;
			i--;
			N1+=n1.valueD()*Math.pow(10, i-1);

		}
		
		i = getL(n2);
		double N2 = n2.valueD()*Math.pow(10, i-1);
		while(n2.next != null){
			n2 = n2.next;
			i--;
			N2+=n2.valueD()*Math.pow(10, i-1);

		}	
		System.out.println("Add two numbers: "+ N1+" + "+ N2);
		return (int) (N1+N2);
	}
	
	
	static int getL(sNode d){
		//get the length of the list
		int l=0;
		if(d==null) return l;
		l++;
		return l+getL(d.next);
	}
	
	
	static sNode initialize(int[] s){
		sNode head = new sNode(s[0]);
		sNode current = head;
		for(int i = 1; i < s.length; i ++){
			sNode n = new sNode(s[i]);
			current.next = n;
			current = n;
		}
//		System.out.println("this node is: "+head.valueD());
		return head;
	}
}
