
public class MultipleTextStream implements TextStream
{
    TextStream[] streams;

    public MultipleTextStream(TextStream... streams) {
        this.streams = streams;
    }

    @Override
    public void read(TextReader reader)
    {
        for(TextStream stream : streams) stream.read(reader);
    }
}