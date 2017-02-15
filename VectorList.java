import java.util.Arrays;

public class VectorList<T> implements ADTList<T>{

	private T[] array;
	private int numberOfEntries = 0;
	private boolean init = false;
	private final static int DEFAULT_SIZE = 25;
	
	public VectorList(){
		this(DEFAULT_SIZE);
		
	}
	public VectorList(int size){
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[size];
		array = temp;
		init = true;
	}
	
	
	public boolean add(T entry) {
		ensureCapacity();
		if(init == true){
			if(!arrayIsFull()){
			array[numberOfEntries] = entry;
			numberOfEntries++;
			}
			else
				return false;
		}		
		else
			throw  new SecurityException();
		
		
			
		return true;
	}
	 

	private boolean arrayIsFull() {
		
		return numberOfEntries >= array.length;
	}

	public boolean add(T entry, int place) {
		ensureCapacity();
		if(!(place >= array.length)){
			if(!(array[place] == null)){
			   for(int i = 0; i < numberOfEntries; i++){
				   T oldEntry = array[place];
				   array[place] = entry;
				   entry = oldEntry;
				   place++;
				   if(array[place] == null)
					   break;
			   }	   
			}
			 else if((array[place + 1] == null)){
				while(!(array[place + 1] == null)){
					place++;
			 }
			array[place] = entry; 
			 }
	    else 
				 array[place] = entry;
		numberOfEntries++;	
	    }
		else{
			System.out.println("please put in order");
		}
			
		
		return true;
	
		}
    private void ensureCapacity(){
        if(numberOfEntries == array.length -1){
            int newLength = 2*array.length;
            
            array = Arrays.copyOf(array, newLength);
        }
    }

	public boolean removeAll() throws Exception {
		while(!isEmpty()){
			remove();
		}
		return true;
	}
    public boolean remove() throws Exception{
    	boolean success = false;
    //	T value = null;
    	if(numberOfEntries < 0){
    //		value = array[numberOfEntries -1];
    		array[numberOfEntries -1] = null;
    		success = true;
    		numberOfEntries--;
    	}
    	else{
    		throw new Exception();
    	}
    	return success;
    }
	public boolean remove(T entry) {
		boolean success = false;
		int index = 0;
	    int location = 0;
		while(success && index < numberOfEntries){
			if(array[index].equals(entry)){
				success = true;
				location = index;
				
			}
			index++;
		}
	//	T removed = array[location];
		array[location] = array[numberOfEntries - 1];
		array[numberOfEntries - 1] = null;
		return success;
	}

	public boolean replace(T item, int location) {
		boolean replaced = false;
		if( location < numberOfEntries){
		array[location] = item;
		replaced = true;
		}
		return replaced;
	}

	public T look() {
		T item = null;
		if(isEmpty())
		  item = array[numberOfEntries -1];
		return item;
	}

	public T[] lookAll() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[])new Object[numberOfEntries];
		
		for(int i = 0; i < numberOfEntries; i++){
			temp[i] = array[i];
		}
		return temp;
	}

	 
	public boolean checkItem(T entry) {
		boolean success = false;
		int index = 0;
		while(success && index < numberOfEntries){
			if(array[index].equals(entry)){
				success = true;
				
			}
			index++;
		}
		return success;
	}

	public int count() {
		return numberOfEntries;
	}

	public boolean isEmpty() {
		
		return numberOfEntries == 0;
	}

}
