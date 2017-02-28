public class LinkedDataList<T> implements ADTListInterface<T> {

	private Node firstNode;
	private int numberOfEntries = 0;
	private class Node{
		T data;
		Node next;
		private Node(T data){
			this(data, null);			
		}
		private Node(T data, Node nextNode){
			this.data = data;
		    next = nextNode;
		}
	}
	public boolean add(T entry) {
		Node newNode = new Node(entry, firstNode);
		firstNode= newNode;
		numberOfEntries++;
		return true;
	}

	
	public boolean add(T entry, int place) {
		boolean success = false;
		int index = 1;
		Node temp = firstNode;
		if (place < numberOfEntries){
			while(index < numberOfEntries){
				temp = temp.next;
				index++;
			}
			temp.next = new Node(entry,temp.next);
			success = true;
			
		}
		else
			System.out.println("not able be put in that place");
		return success;
	}

	public boolean removeAll() {
		firstNode = null;
		return true;
	}

	public boolean remove(T entry) {
		Node temp = firstNode;
		Node cur = null;

        while(!((temp.data).equals(entry))){ 
        	cur = temp;
    	   temp = temp.next;
        }
           cur = temp.next; 
           
       
		return true;
	}

	public boolean replace(T item, int location) throws Exception {
		boolean success = false;
		if(!isEmpty()){
		Node replace = find(location);
		replace.data = item;
		}
		else
			throw new Exception();
		return success;
		
	}
	private Node find(int number) throws Exception{
		assert (firstNode != null) && (1 <= number) && (number <= numberOfEntries);
		Node currentNode = firstNode;
		
		for(int i = 1; i < number; i++)
		{
			currentNode = currentNode.next;
		}
		
		assert currentNode != null;
		
		return currentNode;
	}
	
		
	
	   public Node find(T entry) throws Exception{
		      Node theLink = firstNode;
		      if(!isEmpty()){
		          while(theLink.data != entry){
		              if(theLink == null)
		                  return null;
		              else
		                  theLink = theLink.next;        
		          }
		      }
		      else 
		    	  throw new Exception();
		      return theLink;
	   }	      

	public T look() {
		
		return firstNode.data;
	}

	public T[] lookAll() {
	@SuppressWarnings("unchecked")
	T[] array = (T[])new Object[numberOfEntries];
	int index = 0;
	Node temp = firstNode;
	while(index < numberOfEntries && firstNode != null) {
		array[index] = temp.data;
		temp = temp.next;
		index++;
	}
		return array;
	}


	public boolean checkItem(T entry) {
		boolean success = false;
		Node temp = firstNode;
		while(success && temp != null){
			if(temp.data == entry){
				success = true;
			}
			else
				temp = temp.next;
		}
		return success;
	}

	public int count() {
		return numberOfEntries;
	}

	public boolean isEmpty() {
		return firstNode == null;
	}

}
