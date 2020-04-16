package eg.edu.alexu.csd.datastructure.queue;

public class ArrBasedQueue implements IQueue,IArrayBased {
	
	int QueueSize=0;int first=-1;int last=-1;
	Object arr[];
	public ArrBasedQueue(int size) {
		this.arr=new Object[size];
	}
	
	public void enqueue(Object item) {
		if(QueueSize<arr.length) {
			last++;
			if(last<arr.length) {
				
			}else {
				last=0;
			}
			arr[last]=item;
			QueueSize++;
		}else {
			throw new RuntimeException("The Queue is full");
		}
	}
	
	public Object dequeue() {
		if(this.isEmpty()==false) {
			QueueSize--;
			first++;
			if(first==arr.length) {
				first=0;
			}
			return arr[first];
			}
		else {
			throw new RuntimeException("The Queue is empty");
		}
		
	}
	
	public boolean isEmpty() {
		if(QueueSize>0) {
			return false;
		}else {
			return true;
		}
		
	}
	
	public int size() {
		return QueueSize;
	}

}
