package com.techelevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StackAndQueueExamples {

	public static void main(String[] args) {
		
		int itemNum = 0;  // variable used in loops below		

/********************************************************************************
 *  Stack - LIFO Collection (Last-In-First-Out)
 *  
 *  Normal access to elements in a Stack is through the push() and pop() methods
 *  
 *  When you take an element off the Stack it is also removed
 *  
 *  Accessing a Stack using an index may be confusing. 
 *      bottom element is at index 0
 *      top element is at index (stack.size() - 1) 
 *  
 *  Some methods:
 *  
 *  .add(object)      - add element to top of Stack
 *  .pop()            - return and remove top element on the Stack
 *  .remove(index)    - remove element at index given
 *  .peek()           - return top element without removing it
 *  .size()           - return the number of elements in the Stack
 *  .isEmpty()        - return true if Stack contains no elements
 *  .empty()          - same as isEmpty()
 *  .get(index)       - return element at the index given
 *  .elementAt(index) - same as get(index)
 *  .clear()          - remove all elements in the Stack
 *  .clone()          - return a reference to a Object class clone of the stack
 *                      you must cast reference to type necessary
 *
 *                      STACK = LAST COME FIRST SERVE. WHATEVER DATA TYPE IS ENTERED FIRST, IS POPPED LAST. DATA ENTERED LAST IS POPPED FIRST
 *                      QUEUE = FIRST COME FIRST SERVE. WHATEVER DATA TYPE WAS ENTERED FIRST IS POPPED/POLLED/REMOVED FIRST
 * 
 **********************************************************************************/

		List<String> arrayList = new ArrayList<>();
		Stack <String> myStack = new Stack();
		
		myStack.push("Kirk");
		myStack.push("Spock");
		myStack.push("McCoy");
		myStack.push("Uhura");
		myStack.push("Scotty");	
		myStack.push("Piccard");
		myStack.push("Worf");
		myStack.push("Riker");
		myStack.push("Geordi");
		myStack.push("Data");
		
		System.out.println("Displaying elements in myStack: ");
		
		itemNum = 0;
		
		for (String item : myStack) {  // Loop through each item in the Stack one at a time
			                           //    each time through the loop item contains the current element
			System.out.println("Item @ index #"+itemNum++ + " " + item);
			}
			
		System.out.println("\nNumber items in myStack - .size(): " + myStack.size());
		System.out.println("  Getting Top of myStack - .pop(): " + myStack.pop());
		System.out.println("Number items in myStack - .size(): " + myStack.size());
		System.out.println("  Last element in Stack - .get(0): " + myStack.get(0));
		System.out.println("   Top Element on Stack - .peek(): " + myStack.peek());
		System.out.println("Number items in myStack - .size(): " + myStack.size());
		
		System.out.println("\nCloning myStack - .clone()");
		Stack<String> clonedStack = (Stack<String>) myStack.clone();
		
		System.out.println("Number items in clonedStack - size(): " + clonedStack.size());
		
		System.out.println("\nClearing clonedStack - .clear()");
		clonedStack.clear();  // empty cloned stack
		
		System.out.println("Number items in clonedStack - .size(): " + clonedStack.size());
		System.out.println("    Number items in myStack - .size(): " + myStack.size());
			
		System.out.println("--------------------------------------------");
/********************************************************************************
 *  Queue - FIFO Collection
 *  
 *  Some methods:
 *  
 *  .add(object)      - add element to end of Queue
 *  .offer(object)    - same as add()
 *  .push(object)     - add element to start of Queue
 *  .pop()            - return and remove top element on the Queue - ONLY WORKS FOR LINKEDLIST
 *  .poll()           - same as pop() - RETURNS NULL IF QUEUE IS EMPTY
 *  .remove()         - same as pop() - THROW AN EXCEPTION (ERROR) IF QUEUE IS EMPTY
 *  .pollLast()       - return and remove last element in the Queue
 *  .remove(index)    - remove element at index given
 *  .peek()           - return top element without removing it
 *  .size()           - return the number of elements in the Queue
 *  .isEmpty()        - return true if Queue contains no elements
 *  .empty()          - same as isEmpty()
 *  .get(index)       - return element at the index given
 *  .clear()          - remove all elements in the Queue
 *  .clone()          - return a reference to a Object class clone of the Queue
 *                      you must cast reference to type necessary
 * 
 **********************************************************************************/
	
		LinkedList <String> myQueue = new LinkedList<String>();	    
		//myQueue.
		
		myQueue.add("Josh");
		myQueue.add("Joe");
		myQueue.push("Craig");   // Put at the start of Queue
		
		myQueue.add("Dan");
		myQueue.add("Mike");
		myQueue.add("Frank");			
			
		itemNum = 0;
	
		for (String item : myQueue) {
			System.out.println("Item #" + itemNum++ + " in Queue: " + item);
			}
		System.out.println("--------------------------------------------");		
			
		System.out.println("\nNumber items in myQueue - .size(): " + myQueue.size());
		System.out.println("  Getting Top of myQueue - .pop(): " + myQueue.pop());
		System.out.println("Number items in myQueue - .size(): " + myQueue.size());
		System.out.println("  Last element in Queue - .get(0): " + myQueue.get(0));
		System.out.println("   Top Element on Queue - .peek(): " + myQueue.peek());
		System.out.println("Number items in myQueue - .size(): " + myQueue.size());
		
		System.out.println("\nCloning myQueue - .clone()");
		LinkedList<String> clonedQueue = (LinkedList<String>) myQueue.clone();
		
		System.out.println("Number items in clonedQueue - size(): " + clonedQueue.size());
		
		System.out.println("\nClearing clonedQueue - .clear()");
		clonedQueue.clear();  // empty cloned Queue
		
		System.out.println("Number items in clonedQueue - .size(): " + clonedQueue.size());
		System.out.println("    Number items in myQueue - .size(): " + myQueue.size());
			
		System.out.println("--------------------------------------------");	
	}

}
