import javax.swing.JFrame;
import javax.swing.JPanel;

public interface Visitor 
{
    public void update();
    public void setSubject(Subject sub);
    public String visit(MessagePublisher messagePublisher);
    
}







/*private String message;
    
    public Observer(String message)
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }*/