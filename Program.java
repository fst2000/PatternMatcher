import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        CharSequencePrinter printer = new CharSequencePrinter(System.out);
        Scanner s = new Scanner(System.in);
        new SplitStream(s.nextLine(), ',').read(sequence ->
        {
            Stream[] patternMatchers = new Stream[]
            {
                new PatternMatcherStream(sequence, "//d+", reader ->
                {
                    reader.read("int");
                }),
                new PatternMatcherStream(sequence, "[a-zA-Z]", reader ->
                {
                    reader.read("letter");
                }),
                new PatternMatcherStream(sequence, "[.*]", new SplitStream(sequence, ','))
            };
            for (var p : patternMatchers)
            {
                p.read(printer::print);
            }
        });
        s.close();
    }
}
