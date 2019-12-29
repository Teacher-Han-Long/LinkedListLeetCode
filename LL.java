class LL
{
	private class ListNode 
	{
		private ListNode next;
		private int data;
		public ListNode(int data)
		{
			this.data = data;
			this.next = null;
		}
	}
	
	//creates a linked list
	public ListNode makeList() 
	{
		ListNode head = new ListNode(0);
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		ListNode six = new ListNode(6);
		ListNode six2 = new ListNode(6);
		head.next = one;
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		six.next = six2;
		return head;
	}
	
	//prints out linked list
	public void printList(ListNode head)
	{
		ListNode curr = head;
		while ( curr != null ) 
		{
			System.out.printf("[%s]-->", curr.data);
			curr = curr.next;
		}
		System.out.printf("%s %n%n", curr);
	}
	
	//removes duplicates from a sorted list
	public void removeDuplicates(ListNode head)
	{
		if (head == null) return;
		ListNode curr = head;
		while (curr != null && curr.next != null) 
		{
			if (curr.data == curr.next.data)
			{
				curr.next = curr.next.next;
			} 
			else
			{
				curr = curr.next;
			}
		}
	}
	
	// reverses a list
	public ListNode reverseList(ListNode head) 
	{
		if (head == null) return head;
		ListNode curr = head;
		ListNode prev = null;
		ListNode next = null;
		while (curr != null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	//get nth node from the end
	public ListNode getNthNodeFromEnd(ListNode head, int n)
	{
		if (head == null) return head;
		if (n <= 0) throw new IllegalArgumentException("Invalid n = " + n);
		ListNode ptr1 = head;
		ListNode ptr2 = head;
		int count = 0;
		while (count < n) 
		{
			if (ptr2 == null )
			{
				throw new IllegalArgumentException(n + " is greater than the number of nodes.");
			}
			ptr2 = ptr2.next;
			count++;
		}
		while (ptr2 != null)
		{
			ptr2 = ptr2.next;
			ptr1 = ptr1.next;
		}
		return ptr1;
	}
	
	//finds the middle node
	public ListNode middleNode(ListNode head)
	{
		ListNode i = head;
		ListNode j = head;
		while (j != null && j.next != null)
		{
			i = i.next;
			j = j.next. next;
		}
		return i;
	}
	
	
	
	
	public static void main(String[] args)
	{
		LL list = new LL();
		//create
		ListNode head = list.makeList();
		list.printList(head);
		//remove duplicates
		list.removeDuplicates(head);
		//reverse
		head = list.reverseList(head);
		list.printList(head);
		//nth node from the end
		ListNode third = list.getNthNodeFromEnd(head, 3); 
		System.out.printf("The third node from the end is %d %n", third.data); 
		ListNode middle = list.middleNode(head);
		System.out.printf("The middle node of the List is %s %n%n", middle.data);
	}
}