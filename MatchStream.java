public class MatchStream implements Stream
{
    Stream stream;
    Reader[] readers;
    public MatchStream(Stream stream, Reader... readers)
    {
        this.stream = stream;
        this.readers = readers;
    }
    @Override
    public void read(Reader reader)
    {
        stream.read(sequence ->
        {
            for (var r : readers)
            {
                r.read(sequence);
            }
        });
    }
    
}
