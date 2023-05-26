public class Program
{
    public static void main(String[] args)
    {
        Printer printer = new JoinPrinter(new OutputStreamPrinter(System.out), ", ");
        String input = "1,2,a,b,c";

        TextTemplate template = new MultipleTextTemplate(new TextTemplate[]
        {
            new ReplaceMatchTemplate(new PatternMatchTemplate("\\d+"), "int"),
            new ReplaceMatchTemplate(new PatternMatchTemplate("[a-zA-Z]+"), "string"),
        });

        new SplitStream(input, ',').read(sequence ->
        {
            template.match(sequence, printer::print);
        });
    }
}
