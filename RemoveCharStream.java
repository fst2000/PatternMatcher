public class RemoveCharStream implements Stream
{
    Stream stream;
    Character removeCharacter;
    
    public RemoveCharStream(Stream stream, Character removeCharacter) {
        this.stream = stream;
        this.removeCharacter = removeCharacter;
    }

    @Override
    public void read(Reader reader)
    {
        stream.read(sequence ->
        {
            int length = sequence.length();
            for(int i = 0; i < length; i++)
            {
                Character s = sequence.charAt(i);
                if(s != removeCharacter) reader.read(new SingleCharSequence(s));
            }
        });
    }
    
}
