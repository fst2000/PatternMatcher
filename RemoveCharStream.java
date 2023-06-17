public class RemoveCharStream implements Stream
{
    class RangeReader implements Reader
    {
        Reader reader;
        int start;
        int end;
        public RangeReader(Reader reader, int start, int end) {
            this.reader = reader;
            this.start = start;
            this.end = end;
        }
        @Override
        public void read(CharSequence sequence)
        {
            reader.read(new RangeCharSequence(sequence, start, end));
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
            int start = 0;
            for(int i = 0; i < length; i++)
            {
                Character s = sequence.charAt(i);
                if(s == removeCharacter)
                {
                    reader.read(new RangeCharSequence(sequence, start, i - 1));
                    start = i + 1;
                }
                else if( i == length - 1) reader.read(new RangeCharSequence(sequence, start, i));
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
