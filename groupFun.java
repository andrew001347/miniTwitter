import java.util.ArrayList;

public class groupFun implements sysEntry
{
    private String groupID;
    private String sysEntryType;
    private ArrayList<String> groupEntry;

    private boolean changed;


    public groupFun(String groupID, String sysEntryType)
    {
        this.groupID=groupID;
        this.sysEntryType=sysEntryType;
        this.groupEntry=new ArrayList<>();

    }



    @Override
    public void showEntryType()
     {
        System.out.print(groupID+ " and "+sysEntryType);
        
    }



    @Override
    public void attach(sysEntry obj)
     {
        this.groupEntry.add(sysEntryType);
        
    }



    @Override
    public void detach(sysEntry obj) 
    {
        this.groupEntry.remove(obj);
        
    }



    @Override
    public void notifyObservers() 
    {
        if(!changed)
        {
            return;
        }

        this.changed=false;
        
    }



    @Override
    public Object getUpdate(sysEntry obj)
    {
       return this.groupID;
    }



}
