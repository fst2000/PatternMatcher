public class IntMatchStream implements Stream
{
    Stream stream;
    public IntMatchStream(Stream stream)
    {
        this.stream = stream;
    }
    @Override
    public void read(Reader reader)
    {
        stream.read(sequence ->
        {
            int length = sequence.length();
            int count = 0;
            for(int i = 0; i < length; i++)
            {
                char c = sequence.charAt(i);
                if(Character.isDigit(c)) count ++;
            }
            if(count == length) reader.read("int");
        });
    }
    
}
