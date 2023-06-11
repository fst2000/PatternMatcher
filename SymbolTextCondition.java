
public class SymbolTextCondition implements TextCondition
{
    SymbolCondition condition;

    public SymbolTextCondition(SymbolCondition condition)
    {
        this.condition = condition;
    }
    public SymbolTextCondition(char symbol)
    {
        this.condition = c -> c == symbol;
    }

    @Override
    public boolean match(Text text)
    {
        int length = text.length();
        for(int i = 0; i < length; i++)
        {
            if(!condition.match(text.at(i))) return false;
        }
        return true;
    }
}