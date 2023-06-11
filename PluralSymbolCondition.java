
public class PluralSymbolCondition implements SymbolCondition
{
    char[] symbols;

    public PluralSymbolCondition(char... symbols)
    {
        this.symbols = symbols;
    }

    @Override
    public boolean match(char c)
    {
        for(char symbol : symbols)
        {
            if(c == symbol) return true;
        }
        return false;
    }
}