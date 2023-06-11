public class SplitTextStream implements TextStream
{
    Text text;
    char separator;
    
    public SplitTextStream(Text text, char separator)
    {
        this.text = text;
        this.separator = separator;
    }

    @Override
    public void read(TextReader reader)
    {
        int start = 0;
        boolean noSplit = true;
        int length = text.length();
        for(int i = 0; i < length; i++)
        {
            if(separator == text.at(i))
            {
                reader.read(new SubText(text, start, i));
                reader.read(new SymbolText(separator));
                start = i + 1;
                noSplit = false;
            }
        }
        if(noSplit) reader.read(text);
        else if(start < length) reader.read(new SubText(text, start, length));
    }
}