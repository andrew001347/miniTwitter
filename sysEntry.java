public interface sysEntry 
{

    public void showEntryType();//will distinguish between user and group functions
    
    //Observer pattern 
    public void attach(sysEntry obj);
	public void detach(sysEntry obj);

	public void notifyObservers();
	
	public Object getUpdate(sysEntry obj);
    
}
