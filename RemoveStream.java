public class RemoveStream implements Stream
{
    Stream stream;
    char removeSequence;
    public RemoveStream(Stream stream, char removeSequence)
    {
        this.stream = stream;
        this.removeSequence = removeSequence;
    }
    @Override
    public void read(Reader reader)
    {
        stream.read(sequence ->
        {
            int length = sequence.length();
            for(int i = 0; i < length; i++)
            {
                if(sequence.charAt(i) != removeSequence) reader.read(sequence);
            }
        });
    }
}
