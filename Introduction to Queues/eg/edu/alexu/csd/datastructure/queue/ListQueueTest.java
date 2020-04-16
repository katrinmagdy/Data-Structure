package eg.edu.alexu.csd.datastructure.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListQueueTest {

	@Test
	public void ListBasedtest() {
		ListQueue Q =new ListQueue();
		
		//check that the queue is empty
		assertEquals(true,Q.isEmpty());
		
		//add some elements 
		Q.enqueue('a');  Q.enqueue('b');  Q.enqueue('c');  Q.enqueue('d');  Q.enqueue('e');
		
		//check the size
		assertEquals(5,Q.size());
		
		//check that the queue is not Empty
		assertEquals(false,Q.isEmpty());
		
		//check the dequeue method
		assertEquals('a',Q.dequeue()); 
		assertEquals('b',Q.dequeue());
		assertEquals('c',Q.dequeue());
		assertEquals('d',Q.dequeue());
		assertEquals('e',Q.dequeue());
		
		//add some elements
		Q.enqueue('f');  Q.enqueue('g');  Q.enqueue('h');  Q.enqueue('i');
		assertEquals(4,Q.size());
		
		//dequeue an element and check the size has decreased
		Q.dequeue();
		assertEquals(3,Q.size());
		
		//empty the dequeue and check if the queue is empty
		Q.dequeue(); Q.dequeue(); Q.dequeue();
		assertEquals(true,Q.isEmpty());
		
		//try to dequeue an empty queue and check if an exception is occurred
		try {
			Q.dequeue();
		}
		catch(RuntimeException e) {
			assertEquals("The Queue is Empty",e.getMessage());
		}
		
	}

}
