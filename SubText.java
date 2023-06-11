public class SubText implements Text
{
    Text text;
    int start;
    int end;

    public SubText(Text text, int start, int end)
    {
        this.text = text;
        this.start = start;
        this.end = end;
    }

    @Override
    public int length()
    {
        return end - start;
    }

    @Override
    public char at(int index)
    {
        return text.at(start + index);
    }
}
