import java.util.ArrayList;

public class userFun implements sysEntry
{

    private String userID;
    private String sysEntryType;

    ArrayList<String> followerList; // list of users following the user
    ArrayList<String> followingsList; //list of users the user IS following

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
        this.followerList.add(userID);

    }

    public void deleteUser(String userID) //will be able to add user ids to this group. will have the same group id
    {
        this.followerList.remove(userID);

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

    public ArrayList<String> addPostMessages(String userID, String message) //adding contents
    {

        String entry = userID + ": " + message;
        this.postMessages.add(entry);

        return followerList;
        
    }
    

    
}
