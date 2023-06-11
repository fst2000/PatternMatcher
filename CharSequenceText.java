
public class CharSequenceText implements Text
{
    CharSequence sequence;

    public CharSequenceText(CharSequence sequence)
    {
        this.sequence = sequence;
    }

    @Override
    public int length()
    {
        return sequence.length();
    }

    @Override
    public char at(int index)
    {
        return sequence.charAt(index);
    }
}