public class SingleCharSequence implements CharSequence
{
    char c;
    public SingleCharSequence(char c)
    {
        this.c = c;
    }
    @Override
    public char charAt(int index) {
        return c;
    }

    @Override
    public int length() {
        return 1;
    }

    @Override
    public CharSequence subSequence(int arg0, int arg1) {
        return this;
    }

}