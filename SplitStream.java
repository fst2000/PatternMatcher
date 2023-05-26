public class SplitStream implements Stream
{
    CharSequence sequence;
    char split;
    public SplitStream(CharSequence sequence, char split)
    {
        this.sequence = sequence;
        this.split = split;
    }

    @Override
    public void read(Reader reader)
    {
        int start = 0;
        boolean noSplit = true;
        int length = sequence.length();
        for(int i = 0; i < length; i++)
        {
            if(split == sequence.charAt(i))
            {
                reader.read(new RangeCharSequence(sequence, start, i));
                start = i + 1;
                noSplit = false;
            }
        }
        if(noSplit) reader.read(sequence);
        else if(start < length) reader.read(new RangeCharSequence(sequence, start, length));
    }
}
