public class MatchStream implements Stream
{
    Stream stream;
    Stream[] matchers;
    public MatchStream(Stream stream, Stream... matchers)
    {
        this.stream = stream;
        this.matchers = matchers;
    }
    @Override
    public void read(Reader reader)
    {
        stream.read(sequence ->
        {
            for (var m : matchers)
            {
                m.read(reader);
            }
        });
    }
    
}
