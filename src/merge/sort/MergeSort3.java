/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merge.sort;

/**
 *
 * @author Alina
 * Merge Sort Code: GeeksForGeeks example template
 * 2/16/18
 */
public class MergeSort3 {
    
    //node
    node head = null;
    
	static class node 
	{
		int val;
		node next;

		public node(int val) 
		{
			this.val = val;
		}
	}
        
    //node: a,b,c for thirds
    node sortedMerge3(node a, node b, node c) 
	{
		node node = null;
                
		if (a == null)
			return b;
		if (b == null)
			return c;
                if (c == null)
			return a;
                
		if (a.val <= b.val && a.val <=c.val) 
		{
			node = a;
			node.next = sortedMerge3(a.next, b, c);
		} 
                if (b.val >= a.val && b.val <= c.val)
		{
			node = b;
			node.next = sortedMerge3(a, b.next, c);
		}
                else
                {
                        node = c;
			node.next = sortedMerge3(a, b, c.next);
                }
		return node;

	
    }

    node getThirds(node head)
    {
        //find 3 points
                node header = head;
                int size = 0;
                if (head == null)
                        return head;
                while(header.next != null)
                {    header = header.next;
                    size++;
                }
                //size= size +2 ;
               int thirds = (int)size/3;
                node s = head.next;              
		
		//while(s != null)
                 for( int i = 0; i <thirds; i++)
                 s = s.next;                   
		return s;
    }    
    
    node mergeSort3(node head) 
	{
		//check if link is null
		if (head == null || head.next == null || head.next.next==null)
		{
			return head;
		}
                
		//separate into thirds
		node first = getThirds(head);                
                node second = first.next;
                second = getThirds(second);
                
                //node third = second.next;
                first.next = null;
                //second.next = null;
		//sort thirds
		node left = mergeSort3(head);
                node center= mergeSort3(first);
		node right = mergeSort3(second);

		// combine thirds
		node sortedlist = sortedMerge3(left, center, right);
		return sortedlist;
	}

    
	void push(int sorted) 
	{
		node nnode = new node(sorted);
		nnode.next = head;
		head = nnode;
	}

	// print
	void printList(node headref) 
	{
		while (headref != null) 
		{
			System.out.print(headref.val + " ");
			headref = headref.next;
		}
	}
        
        //print to string
        public String PrintOut (node header)
        {
            String out="";
            while (header != null) 
		{
			out += header.val + " ";
			header = header.next;
                }
            return out;
        }
    
        
        public String PrintSort(node head)
        {
            
            head = mergeSort3(head);            
            String out="";
            while (head != null) 
		{
			out += head.val + " ";
			head = head.next;
                }
            return out;
        }
   /*     
   public static void main(String[] args) {
       MergeSort3 list3 = new MergeSort3();
                //random num for LL
                Random randm = new Random();
                for (int ran = 1; ran<10; ran++)
                {
                   list3.push(randm.nextInt(100)); 
                }
                System.out.println("Original Linked List:");
		list3.printList(list3.head);
                
                System.out.print("\n");
		// Apply merge Sort
		list3.head = list3.mergeSort3(list3.head);
		System.out.print("Sorted Linked List: \n");
		list3.printList(list3.head);
    }
*/


}
