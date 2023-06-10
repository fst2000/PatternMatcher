import javax.sound.midi.Sequence;

public class SubStream implements Stream
{
    Stream a;
    Stream b;
    public SubStream(Stream a, Stream b)
    {
        this.a = a;
        this.b = b;
    }
    @Override
    public void read(Reader reader)
    {
        a.read(reader::read);
        b.read(reader::read);
    }
    
}