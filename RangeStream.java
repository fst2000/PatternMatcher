public class RangeStream implements Stream
{
    Stream stream;
    int start;
    int end;
    public RangeStream(Stream stream, int start, int end) {
        this.stream = stream;
        this.start = start;
        this.end = end;
    }
    @Override
    public void read(Reader reader)
    {
        stream.read(sequence ->
        {
            reader.read(new RangeCharSequence(sequence, start, end));
        });
    }
    
}
