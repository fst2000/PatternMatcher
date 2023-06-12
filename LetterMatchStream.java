public class LetterMatchStream implements Stream
{
    Stream stream;
    public LetterMatchStream(Stream stream) {
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
                if(Character.isLetter(c)) count ++;
            }
            if(count == length) reader.read("letter");
        });
    }
    
}
