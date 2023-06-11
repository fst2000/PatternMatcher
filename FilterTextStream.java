
public class FilterTextStream implements TextStream
{
    TextStream source;
    TextCondition condition;
    
    public FilterTextStream(TextStream source, TextCondition condition)
    {
        this.source = source;
        this.condition = condition;
    }

    @Override
    public void read(TextReader reader)
    {
        source.read(c ->
        {
            if(condition.match(c)) reader.read(c);
        });
    }
}