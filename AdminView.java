//Singleton pattern
public class AdminView 
{
    private static AdminView instance;

    private AdminView(){}

    private static class AdminViewHelper
    {
        private static final AdminView innerInstance = new AdminView();
    }

    public static AdminView getAdminView()
    {
        return AdminViewHelper.innerInstance;
    }
    
}





/*
 * 
 * 
 * Composite for the user groups
Observer for following/updating feeds 
Visitor for updating stuffs (edited) used to traverse the tree
list.<IuserCluber>add

cluster has user and usergroup
He didn’t say what to use singleton for but I assume make the admin control panel a singleton



 */