package eg.edu.alexu.csd.datastructure.mailServer;

public class Filter implements IFilter {
	
	public String folder;
	public String filtersubject;
	public String filtersender;
	
	public void setfiltersubject(String subject) {
		this.filtersubject=subject;
	}
	
	public void setfiltersender(String sender) {
		this.filtersender=sender;
	}
	
	
	public void filtermails(String user,DLinkedList list) {
		if(filtersubject!=null) {
			for(int i=list.size()-1;i>=0;i--) {
				String[] s = (String[]) list.get(i);
				if(s!=null) {
					if(!s[0].toLowerCase().contains(filtersubject.toLowerCase())) {
						list.remove(i);
					}
				}
				
			}
		}
		else if(filtersender!=null) {
			for(int i=(list.size()-1);i>=0;i--) {
				String[] s = (String[]) list.get(i);
				if(s!=null) {
					if(!(s[1].equals(filtersender))) {
						list.remove(i);
					}
				}
				
			}
		}
	}
	

}
