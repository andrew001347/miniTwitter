import java.util.ArrayList;

public class groupFun implements sysEntry
{
    private String groupID;
    private String sysEntryType;
    ArrayList<String> groupEntry;



    public groupFun(String groupID, String sysEntryType)
    {
        this.groupID=groupID;
        this.sysEntryType=sysEntryType;

    }



    @Override
    public void showEntryType()
     {
        System.out.print(groupID+ " and "+sysEntryType);
        
    }

    public void addUser(String userID) //will be able to add user ids to this group. will have the same group id
    {
        this.groupEntry.add(userID);

    }

    public void deleteUser(String userID) //will be able to add user ids to this group. will have the same group id
    {
        this.groupEntry.remove(userID);

    }



}
