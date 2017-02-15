public interface ADTList <T> {
	
	  /** Adds a entry to the back of the list.
    @return   True if the object has been added to the list */
	public boolean add(T entry);
	
	  /** Adds a entry to a specific place in the list.
    @return   True if the object has been added to the list */	
	public boolean add(T entry, int place);
	
	  /** removes all entries from the list.
    @return   True if the all object have been removed from the list 
    @throws Exception if it is empty*/	
	public boolean removeAll() throws Exception;
	
	 /** removes an entry from the list.
    @return   True if the object has been removed from the list or false otherwise */
	public boolean remove(T entry);
	
	 /** replaces an entry from the list.
    @return   True if the object has been replaced from the list or false otherwise
	 * @throws Exception if locatin is not there */
	public boolean replace(T item, int location) throws Exception;
	
	 /** looks at the top of the list .
    @return    object in top of the list */
	public T look();
	
	 /** looks at all the object in the list
    @return   all objects from the list */
	public T[] lookAll();
	
	 /** check if an item is in the list
    @return   True if the object is in the list */
	public boolean checkItem(T entry);
	
	 /** counts the number of items in the list
    @return   integer number of objects in the list */
	public int count();
	
	 /** check the list if it is empty.
    @return   True if the list is empty or false otherwise */
	public boolean isEmpty();   
}
