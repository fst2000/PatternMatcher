
public class SymbolText implements Text
{
    char symbol;

    public SymbolText(char symbol)
    {
        this.symbol = symbol;
    }

    @Override
    public int length()
    {
        return 1;
    }

    @Override
    public char at(int index)
    {
       return symbol; 
    }
}