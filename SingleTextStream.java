
public class SingleTextStream implements TextStream
{
    Text text;

    public SingleTextStream(Text text)
    {
        this.text = text;
    }

    @Override
    public void read(TextReader reader)
    {
        reader.read(text);
    }
}