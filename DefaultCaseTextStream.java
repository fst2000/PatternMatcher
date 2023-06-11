
public class DefaultCaseTextStream implements TextStream
{
    TextStream stream;
    Text defaultCase;
    
    public DefaultCaseTextStream(TextStream stream, Text defaultCase)
    {
        this.stream = stream;
        this.defaultCase = defaultCase;
    }

    class DefaultCaseTextReader implements TextReader
    {
        boolean hadItem;
        TextReader reader;

        public DefaultCaseTextReader(TextReader reader)
        {
            this.reader = reader;
        }

        @Override
        public void read(Text text)
        {
            hadItem = true;
            reader.read(text);
        }

        void finalCheck()
        {
            if(!hadItem) reader.read(defaultCase);
        }
    }

    @Override
    public void read(TextReader reader)
    {
        DefaultCaseTextReader dreader = new DefaultCaseTextReader(reader);
        stream.read(dreader);
        dreader.finalCheck();
    }
}