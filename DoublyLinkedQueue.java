public class DoublyLinkedQueue<T> implements InterfaceQueue<T> {
    private Node firstNode;
    private Node lastNode;
    private int numberOfEntries;
/////////////////////////////////////////////////////////////////////
   private class Node{
        T value;
        Node next;
        Node previous;
        
        private Node(T value){            
            this.value = value;
            next = null;
            previous = null;
        }
        private Node(T value, Node nextNode, Node prevNode){
            this.value = value;
            next = nextNode;
            previous = prevNode;
        }
    }
/////////////////////////////////////////////////////////////////////
 public void addFront(T entry){
        Node newNode = new Node(entry);
        if(firstNode == null){
            newNode.previous = null;
            newNode.next = null;
            firstNode = newNode;
            lastNode = newNode;
        }
        else{
        newNode.next = firstNode;
        newNode.previous = null;
        firstNode.previous = newNode;
        firstNode = newNode;
        }
        numberOfEntries++;
        System.out.println(firstNode.value);               
    }
    //-------------------------------------------------------------------
 public void addBack(T entry){
	 Node newNode = new Node(entry);
	 if(lastNode == null){
		 firstNode = newNode;
		 lastNode = newNode;
	 }
	 else{
		 newNode.previous = lastNode;
		 newNode.next = null;
		 lastNode.next = newNode;
		 lastNode = newNode;
		 numberOfEntries++;
	 }
	 
 }
    public void enqueue(T entry){
        Node newNode = new Node(entry);
        if(lastNode == null){
            newNode.previous = null;
            newNode.next = null;
            firstNode = newNode;
            lastNode = newNode;
        }
        else{
            newNode.next = null;
            newNode.previous = lastNode;
            lastNode.next = newNode;
            lastNode = newNode;
        }
        numberOfEntries++;
        System.out.println(lastNode.value);
    }
    //-------------------------------------------------------------------
    public T dequeue(){
    	T front  = null;
    	if(!isEmpty())
        front = firstNode.value;
        assert firstNode != null;
        firstNode.value = null;
        firstNode = firstNode.next;
        if (firstNode ==null){
        	lastNode =null;
        
        }
        numberOfEntries--;
        return front;
        
    }
    //-------------------------------------------------------------------

    public void iteratingForward(){
        Node temp;
        temp = firstNode;
        while(temp != null){
            System.out.print(temp.value + " ");
            
            temp = temp.next;
        }
       System.out.println();
        
    }
    //-------------------------------------------------------------------
    public boolean isEmpty(){
        return numberOfEntries < 0;
    }
    public T getFront() {
	   T front = null;
	    if(!isEmpty())
		    front = firstNode.value;
	   
	   
	   return front;
    }
    public void clear() {
	   while(!isEmpty()){
		   removeFront();
	   }
	
    }
    public  T removeFront(){
    	T front  = null;
    	if(!isEmpty())
        front = firstNode.value;
        assert firstNode != null;
        firstNode.value = null;
        firstNode = firstNode.next;
        if (firstNode ==null){
        	lastNode =null;
        
        }
        numberOfEntries--;
        return front;
    	
    }
    public T removeBack(){
    	T back = null;
    	if(!isEmpty()){
    		back = lastNode.value;
    	}
    	    assert lastNode != null;
    		lastNode = lastNode.previous;
    		if(lastNode == null)
    			firstNode =null;
    		else
    			lastNode.next = null;;
    		numberOfEntries--;
    	
      	
    	return back;
    
}  
}
