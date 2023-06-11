
public class TextCharSequence implements CharSequence
{
    Text text;

    public TextCharSequence(Text text)
    {
        this.text = text;
    }

    @Override
    public int length()
    {
        return text.length();
    }

    @Override
    public char charAt(int index)
    {
        return text.at(index);
    }

    @Override
    public CharSequence subSequence(int start, int end)
    {
        return new TextCharSequence(new SubText(text, start, end));
    }
}