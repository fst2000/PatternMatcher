public class Program
{
    public static void main(String[] args)
    {
        CharSequencePrinter printer = new StreamCharSequencePrinter(System.out);
        String text = "123, wadwad, 155waddaw2, 12";
        Stream stream = new SplitStream(new RemoveCharStream(reader -> reader.read(text), ' '), ',');
        stream.read(printer::print);
        printer.print("\n");
    }
}
