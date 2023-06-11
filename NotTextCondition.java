
public class NotTextCondition implements TextCondition
{
    TextCondition condition;

    public NotTextCondition(TextCondition condition)
    {
        this.condition = condition;
    }

    @Override
    public boolean match(Text text)
    {
        return !condition.match(text);
    }   
}