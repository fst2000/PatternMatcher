
public class ConditionPrinter implements Printer
{
    TextCondition condition;
    Printer yesPrinter;
    Printer noPrinter;
    
    public ConditionPrinter(TextCondition condition, Printer yesPrinter, Printer noPrinter)
    {
        this.condition = condition;
        this.yesPrinter = yesPrinter;
        this.noPrinter = noPrinter;
    }
    @Override
    public void print(Text text)
    {
        (condition.match(text) ? yesPrinter : noPrinter).print(text);
    }
}