package eg.edu.alexu.csd.datastructure.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrBasedQueueTest {

	@Test
	public void test() {
		ArrBasedQueue a=new ArrBasedQueue(10);
		
		//check that the queue is empty
		assertEquals(true,a.isEmpty());
		
		//add some elements and check the dequeue method
		a.enqueue(5);a.enqueue(6);a.enqueue(7);
		
		assertEquals(5, a.dequeue());
		assertEquals(6, a.dequeue());
		assertEquals(7, a.dequeue());
		
		
		//add some elements and check that the queue is not empty
		a.enqueue(1);a.enqueue(2);a.enqueue(3);
		assertEquals(false,a.isEmpty());
		
		//check the size
		assertEquals(3, a.size());
		
		//dequeue an element and check the size has decreased
		a.dequeue();
		assertEquals(2, a.size());
		
		//empty the dequeue and check if the queue is empty
		a.dequeue();a.dequeue();
		assertEquals(0, a.size());
		
		assertEquals(true,a.isEmpty());
		
		//try to dequeue an empty queue and check if an exception is occured
		try {
			a.dequeue();
		}catch(RuntimeException r){
			assertEquals("The Queue is empty",r.getMessage());
		}
		
		//enqueue 9 elements
		a.enqueue(1);a.enqueue(2);a.enqueue(3);
		a.enqueue(4);a.enqueue(5);a.enqueue(6);
		a.enqueue(7);a.enqueue(8);a.enqueue(9);
		
		//check the size 
		assertEquals(9, a.size());
		
		// check if the queue is empty
		assertEquals(false,a.isEmpty());
		
		//add another element since the size of the queue is 10 so the queue is full
		a.enqueue(10);
		
		//try enqueue another element when the queue is full and check if an exception is occured
		try {
		a.enqueue(11);
		}catch(RuntimeException t) {
			assertEquals("The Queue is full",t.getMessage());
		}
		
		//from a full stack dequeue an element and enqueue another element an exception does not occur
		a.dequeue();
		a.enqueue(11);
		
		assertEquals(2, a.dequeue());
		
		//dequeue till the before last element and check that the last element is the last enqueued element
	    a.dequeue(); a.dequeue(); a.dequeue(); a.dequeue(); a.dequeue(); a.dequeue(); a.dequeue(); a.dequeue(); 
		
		assertEquals(11, a.dequeue());
		
	}

}
