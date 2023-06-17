public class SplitStream implements Stream
{
    Stream stream;
    char split;
    public SplitStream(Stream stream, char split)
    {
        this.stream = stream;
        this.split = split;
    }

    @Override
    public void read(Reader reader)
    {
        stream.read(sequence ->
        {
            int start = 0;
            int length = sequence.length();
            if(length == 0)
            {
                return;
            }
            for(int i = 0; i < length; i++)
            {
                if(sequence.charAt(i) == split)
                {
                    reader.read(new RangeCharSequence(sequence, start, i - 1));
                    start = i + 1;
                }
                else if(i == length - 1) reader.read(new RangeCharSequence(sequence, start, i));
            }
            if(start == 0) reader.read(sequence);
        });
    }

}
