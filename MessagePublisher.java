class MessagePublisher implements Subject
{
    private String tweet;

    public MessagePublisher(String message)
    {
        this.tweet=message;

    }

    public String getTweet()
    {
        return tweet;
    }

    @Override
    public String accept(Visitor visitor) 
    {
       return visitor.visit(this);
    }
    
}