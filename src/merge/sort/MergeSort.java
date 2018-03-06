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
 * 2/14/18
 */
public class MergeSort {
    
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
        
    //node: a,b for halves
    node sortedMerge(node a, node b) 
	{
		node node = null;
                
		if (a == null)
			return b;
		if (b == null)
			return a;
                
		if (a.val <= b.val) 
		{
			node = a;
			node.next = sortedMerge(a.next, b);
		} 
		else
		{
			node = b;
			node.next = sortedMerge(a, b.next);
		}
		return node;

	}

    
    node mergeSort(node header) 
	{
		//check if link is null
		if (header == null || header.next == null)
		{
			return header;
		}

		//separate into halves
		node middle = getMiddle(header);
		node mnext = middle.next;
		middle.next = null;

		//sort halves
		node left = mergeSort(header);
		node right = mergeSort(mnext);

		// combine halves
		node sortedlist = sortedMerge(left, right);
		return sortedlist;
	}

	// find where to separate list
	node getMiddle(node h) 
	{
		if (h == null)
			return h;
		node f = h.next;
		node s = h;
		
		while (f != null)
		{
			f = f.next;
			if(f!=null)
			{
				s = s.next;
				f=f.next;
			}
		}
		return s;
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
			System.out.print(headref.val + ", ");
			headref = headref.next;
		}
	}
        
        //print to string
        public String PrintOut (node head) //String out 
        {
		//printList(head);
            
            String out="";
            while (head != null) 
		{
			out += head.val + " ";
			head = head.next;
                }
            return out;
        }
        
        
        public String PrintSort(node head)
        {
            
            head = mergeSort(head);            
            String out="";
            while (head != null) 
		{
			out += head.val + " ";
			head = head.next;
                }
            return out;
        }
        
    
   /* public static void main(String[] args) {
       MergeSort list = new MergeSort();
                //random num for LL
                Random randm = new Random();
                for (int ran = 1; ran<1000; ran++)
                {
                   list.push(randm.nextInt(100)); 
                }
                System.out.println("Original Linked List:");
		list.printList(list.head);
                
		// Apply merge Sort
		list.head = list.mergeSort(list.head);
		System.out.print("\n Sorted Linked List: \n");
		list.printList(list.head);
    }
    */
}
