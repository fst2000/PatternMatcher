
public class EqualsTextCondition implements TextCondition
{
    Text source;

    public EqualsTextCondition(Text source)
    {
        this.source = source;
    }

    @Override
    public boolean match(Text text)
    {
        int length = text.length();

        if(source.length() != length) return false;

        for(int i = 0; i < length; i++)
        {
            if(source.at(i) != text.at(i)) return false;
        }
        return true;
    }
}