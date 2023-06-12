public class RemoveCharStream implements Stream
{
    class RemoveAtReader implements Reader
    {
        Reader reader;
        int removeAt;
        public RemoveAtReader(Reader reader, int removeAt) {
            this.reader = reader;
            this.removeAt = removeAt;
        }
        @Override
        public void read(CharSequence sequence)
        {
            reader.read(
                new ConcatCharSequence(
                    new RangeCharSequence(sequence, 0, removeAt),
                    new RangeCharSequence(sequence, removeAt + 1, sequence.length())));
        }
        
    }
    class RemoveCharReader implements Reader
    {
        Reader reader;
        public RemoveCharReader(Reader reader) {
            this.reader = reader;
        }
        @Override
        public void read(CharSequence sequence)
        {
            int length = sequence.length();
            for(int i = 0; i < length; i++)
            {
                Character s = sequence.charAt(i);
                if(s == removeCharacter) new RemoveAtReader(reader, i).read(sequence);
            }
        }
        
    }
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
            new RemoveCharReader(reader).read(sequence);
        });
    }
    
}
