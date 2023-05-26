import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        CharSequencePrinter printer = new CharSequencePrinter(System.out);
        Scanner s = new Scanner(System.in);
        new SplitStream(s.nextLine(), ',').read(sequence ->
        {
            PatternMatcherStream[] patternMatchers = new PatternMatcherStream[]
            {
                new PatternMatcherStream(sequence, "//d+", "int"),
                new PatternMatcherStream(sequence, "[a-zA-Z]", "letter")
            };
            for (var p : patternMatchers)
            {
                p.read(printer::print);
            }
        });
    }
}
