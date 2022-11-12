import java.util.ArrayList;

public class userFun implements sysEntry
{

    private String userID;
    private String sysEntryType;

    ArrayList<String> followerList; // list of users following the user
    ArrayList<String> followingsList; //list of users the user IS following

    ArrayList<String> postMessages;

    private boolean changed;


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

    public void addfollowing(String userID) //
    {
        this.followingsList.add(userID);

    }

    public void deletefollowing(String userID) //unfollows
    {
        this.followingsList.remove(userID);

    }



    public ArrayList<String> showPostMessages()//showing contents
    {
        return postMessages;
        
    }


    @Override
    public void attach(sysEntry obj)
     {
        this.followerList.add(userID);
        
    }

    @Override
    public void detach(sysEntry obj) 
    {
        this.followerList.remove(userID);
        
    }

    @Override
    public void notifyObservers() 
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Object getUpdate(sysEntry obj)
     {
        String entry = userID + ": " + sysEntryType;
        this.postMessages.add(entry);

        return followerList;
    }
    

    
}
