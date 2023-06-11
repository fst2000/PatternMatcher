public class ConcatCharSequence implements CharSequence
{
    CharSequence a;
    CharSequence b;
    int aLength;
    int bLength;
    public ConcatCharSequence(CharSequence a, CharSequence b)
    {
        this.a = a;
        this.b = b;
        aLength = a.length();
        bLength = b.length();
    }

    @Override
    public char charAt(int index)
    {
        if(index < aLength) return a.charAt(index);
        else return b.charAt(index - aLength);
    }

    @Override
    public int length()
    {
        return aLength + bLength;
    }

    @Override
    public CharSequence subSequence(int arg0, int arg1)
    {
        return new RangeCharSequence(new ConcatCharSequence(a, b), arg0, arg1);
    }

}
