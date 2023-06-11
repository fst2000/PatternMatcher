
public class FirstTextStream implements TextStream
{
    TextStream stream;
    
    public FirstTextStream(TextStream stream)
    {
        this.stream = stream;
    }

    class FirstTextReader implements TextReader
    {
        boolean hadItem;
        TextReader reader;

        public FirstTextReader(TextReader reader)
        {
            this.reader = reader;
        }

        @Override
        public void read(Text text)
        {
            if(!hadItem) reader.read(text);
            hadItem = true;
        }
    }

    @Override
    public void read(TextReader reader)
    {
        stream.read(new FirstTextReader(reader));
    }
}