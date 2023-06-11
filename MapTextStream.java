
public class MapTextStream implements TextStream
{
    TextStream source;
    TextMap map;
    
    public MapTextStream(TextStream source, TextMap map)
    {
        this.source = source;
        this.map = map;
    }
    @Override
    public void read(TextReader reader)
    {
        source.read(t -> map.map(t).read(reader));
    }
}