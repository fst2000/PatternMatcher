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
                reader.read(sequence);
                return;
            }
            for(int i = 0; i < length; i++)
            {
                if(split == sequence.charAt(i) || i + 1 == length)
                {
                    reader.read(new RangeCharSequence(sequence, start, i));
                    start = i + 1;
                }
            }
            if(start == 0) reader.read(sequence);
        });
    }

}
