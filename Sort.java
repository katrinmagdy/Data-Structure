package eg.edu.alexu.csd.datastructure.mailServer;

import eg.edu.alexu.csd.datastructure.mailServer.DLinkedList.Dnode;

public class Sort implements ISort {
	
	public String accto;
DLinkedList list=new DLinkedList();
public void setlist(DLinkedList list){//constructor
	this.list=list;//list of emails
}

public void swap(DLinkedList d,Dnode a,Dnode b) {
	Mail tmp;
	tmp=a.getElement();
	a.setElement(b.getElement());b.setElement(tmp);
}


public void SortingMailsByDates(){String arrOfDates[]=new String[list.size()];int counter =0;
if (list.size()>0) {
Dnode v=list.head.getNext();
while(counter<list.size()) {
	arrOfDates[counter]=v.getElement().date;
	counter++;
	v=v.getNext();
}
QuickSortByStack q=new QuickSortByStack();q.IterativeQuickSort(arrOfDates);int i=0;
while(i<counter) {System.out.print(arrOfDates[i]+"  ");
	i++;
}
//loop for sorting list
v=list.head.getNext();i=arrOfDates.length-1;int x=0;counter=0;
while(counter<list.size()) {
	if(v.getElement().date.contentEquals(arrOfDates[i])==false) {
		x=counter;Dnode y=v;
		while(x<list.size()) {
			if(y.getElement().date.contentEquals(arrOfDates[i])==false) {
				x++;y=y.getNext();
			}else {
				break;
			}
		}
		i--;counter++;
		swap(list,y,v);v=v.getNext();
	}else {
		i--;counter++;v=v.getNext();
	}
}
counter=0;System.out.println();Dnode h=list.head.getNext();
while(counter<list.size()) {System.out.print(h.getElement().date+" ");h=h.getNext();
	counter++;
}
}



}
	


public void SortingMailsBySubject() {
	String arrOfSubjects[]=new String[list.size()];int counter =0;
	if (list.size()>0) {
	Dnode v=list.head.getNext();
	while(counter<list.size()) {
		arrOfSubjects[counter]=v.getElement().subject;
		counter++;
		v=v.getNext();
	}
	QuickSortByStack q=new QuickSortByStack();q.IterativeQuickSort(arrOfSubjects);int i=0;
	while(i<counter) {System.out.print(arrOfSubjects[i]+"  ");
		i++;
	}
	//loop for sorting list
	v=list.head.getNext();i=0;int x=0;counter=0;
	while(counter<list.size()) {
		if(v.getElement().subject.contentEquals(arrOfSubjects[i])==false) {
			x=counter;Dnode y=v;
			while(x<list.size()) {
				if(y.getElement().subject.contentEquals(arrOfSubjects[i])==false) {
					x++;y=y.getNext();
				}else {
					break;
				}
			}
			i++;counter++;
			swap(list,y,v);v=v.getNext();
		}else {
			i++;counter++;v=v.getNext();
		}
	}
	counter=0;System.out.println();Dnode h=list.head.getNext();
	while(counter<list.size()) {System.out.print(h.getElement().subject+"  ");h=h.getNext();
		counter++;
	}
	}


}
	
public void SortingMailsBySender() {
	String arrOfSenders[]=new String[list.size()];int counter =0;
	if (list.size()>0) {
	Dnode v=list.head.getNext();
	while(counter<list.size()) {
		arrOfSenders[counter]=v.getElement().sender;
		counter++;
		v=v.getNext();
	}
	QuickSortByStack q=new QuickSortByStack();q.IterativeQuickSort(arrOfSenders);int i=0;
	while(i<counter) {System.out.print(arrOfSenders[i]+"  ");
		i++;
	}
	//loop for sorting list
	v=list.head.getNext();i=0;int x=0;counter=0;
	while(counter<list.size()) {
		if(v.getElement().sender.contentEquals(arrOfSenders[i])==false) {
			x=counter;Dnode y=v;
			while(x<list.size()) {
				if(y.getElement().sender.contentEquals(arrOfSenders[i])==false) {
					x++;y=y.getNext();
				}else {
					break;
				}
			}
			i++;counter++;
			swap(list,y,v);v=v.getNext();
		}else {
			i++;counter++;v=v.getNext();
		}
	}
	counter=0;System.out.println();Dnode h=list.head.getNext();
	while(counter<list.size()) {System.out.print(h.getElement().sender+"  ");h=h.getNext();
		counter++;
	}
	}
	
}
	
public void SortingMailsByReciever() {
	String arrOfRecievers[]=new String[list.size()];int count=0;
	int counter=0;Dnode h=list.head.getNext();
	while(counter<list.size()){
		arrOfRecievers[count]= String.valueOf(h.getElement().listreceivers.GetFirstElement());
		count++;
		h=h.getNext();
		counter++;
	}
	QuickSortByStack q=new QuickSortByStack();q.IterativeQuickSort(arrOfRecievers);
	Dnode v=list.head.getNext();int i=0;int x=0;counter=0;
	while(counter<list.size()) {String s= String.valueOf(v.getElement().listreceivers.GetFirstElement());
		if(s.contentEquals(arrOfRecievers[i])==false) {
			x=counter;Dnode y=v;
			while(x<list.size()) {
				String ss= String.valueOf(y.getElement().listreceivers.GetFirstElement());
				if(ss.contentEquals(arrOfRecievers[i])==false) {
					x++;y=y.getNext();
				}else {
					break;
				}
			}
			i++;counter++;
			swap(list,y,v);
			v=v.getNext();
		}else {
			i++;counter++;v=v.getNext();
		}
	}
	counter=0;Dnode f=list.head.getNext();
	while(counter<list.size()) {
		System.out.print(f.getElement().listreceivers.GetFirstElement()+"  ");counter++;
		f=f.getNext();
	}
}

}
