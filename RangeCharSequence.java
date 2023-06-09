public class RangeCharSequence implements CharSequence
{
    CharSequence sequence;
    int start;
    int end;

    public RangeCharSequence(CharSequence sequence, int start, int end)
    {
        this.sequence = sequence;
        this.start = start;
        this.end = end;
    }

    @Override
    public int length()
    {
        return (end - start) + 1;
    }

    @Override
    public char charAt(int index)
    {
        return sequence.charAt(start + index);
    }

    @Override
    public CharSequence subSequence(int start, int end)
    {
        return new RangeCharSequence(sequence, start, end);
    }
}
