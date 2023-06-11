
public class ArrayTextStream implements TextStream
{
    Text[] texts;

    public ArrayTextStream(Text... texts)
    {
        this.texts = texts;
    }

    @Override
    public void read(TextReader reader)
    {
        for(int i = 0; i < texts.length; i++) reader.read(texts[i]);
    }
}