
public class ScopeTextStream implements TextStream
{
    TextStream source;
    TextCondition enter;
    TextCondition exit;
    TextMap inScope;
    TextMap outScope;
    
    public ScopeTextStream(TextStream source, TextCondition enter, TextCondition exit, TextMap inScope, TextMap outScope)
    {
        this.source = source;
        this.enter = enter;
        this.exit = exit;
        this.inScope = inScope;
        this.outScope = outScope;
    }

    class ScopeTextReader implements TextReader
    {
        TextMap map;
        TextReader reader;

        ScopeTextReader(TextReader reader)
        {
            map = outScope;
            this.reader = reader;
        }

        @Override
        public void read(Text text)
        {
            if(map == outScope && enter.match(text))
            {
                map = inScope;
            }
            else if(map == inScope && exit.match(text))
            {
                map = outScope;
            }
            else map.map(text).read(reader);
        }
    }

    @Override
    public void read(TextReader reader)
    {
        source.read(new ScopeTextReader(reader));
    }
}