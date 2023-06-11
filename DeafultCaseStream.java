public class DeafultCaseStream implements Stream
{
    class DefaultCaseReader implements Reader
    {
        Reader reader;
        boolean hasRead;
        public DefaultCaseReader(Reader reader) {
            this.reader = reader;
        }
        @Override
        public void read(CharSequence sequence)
        {
            reader.read(sequence);
            hasRead = true;
        }
        void finalCheck()
        {
            if(!hasRead) reader.read(defaultCase);
        }
    }
    Stream stream;
    CharSequence defaultCase;
    public DeafultCaseStream(Stream stream, CharSequence defaultCase)
    {
        this.stream = stream;
        this.defaultCase = defaultCase;
    }
    @Override
    public void read(Reader reader)
    {
       DefaultCaseReader defaultCaseReader = new DefaultCaseReader(reader);
       stream.read(defaultCaseReader);
       defaultCaseReader.finalCheck();
    }
    
}
