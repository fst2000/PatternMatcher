import java.util.Scanner;

public class Program
{
    public static void main(String[] args)
    {
        CharSequencePrinter printer = new CharSequencePrinter(System.out);
        Scanner s = new Scanner(System.in);
        String text = "12312,\"gsgge\",12f,fafafaaf,123, [\"adwdawwda\", 12, 1233]";
        new SplitStream(reader -> reader.read(text), ',').read(sequence ->
        {
            Stream[] patternMatchers = new Stream[]
            {
                new PatternMatcherStream(sequence, "//d+", reader ->
                {
                    reader.read("int");
                }),
                new PatternMatcherStream(sequence, "\".*\"", reader ->
                {
                    reader.read("string");
                }),
                new PatternMatcherStream(sequence, "[.*]", new SplitStream(reader -> reader.read(sequence), ','))
            };
            for (var p : patternMatchers)
            {
                p.read(printer::print);
            }
        });
        s.close();
    }
}
