import java.util.ArrayList;

public class userFun implements sysEntry
{

    private String userID;
    private String sysEntryType;

    ArrayList<String> followList;

    ArrayList<String> postMessages;

    public userFun(String userID, String sysEntryType)
    {
        this.userID=userID;
        this.sysEntryType=sysEntryType;
    }

    @Override
    public void showEntryType() 
    {
       System.out.print(userID+ " and "+sysEntryType);
        
    }

    public void addUser(String userID) //tracks who is following who
    {
        this.followList.add(userID);

    }

    public void deleteUser(String userID) //will be able to add user ids to this group. will have the same group id
    {
        this.followList.remove(userID);

    }

    public ArrayList<String> showPostMessages() 
    {
       return postMessages;
        
    }

    
}
