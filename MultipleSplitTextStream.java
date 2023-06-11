
public class MultipleSplitTextStream implements TextStream
{
    TextStream stream;

    public MultipleSplitTextStream(Text text, char... separators)
    {
        stream = new SingleTextStream(text);
        for(char separator : separators)
        {
            stream = new MapTextStream(stream, t -> new SplitTextStream(t, separator));
        }
    }

    @Override
    public void read(TextReader reader)
    {
        stream.read(reader);
    }
}