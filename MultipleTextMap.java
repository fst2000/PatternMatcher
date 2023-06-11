
public class MultipleTextMap implements TextMap
{
    TextMap[] maps;

    public MultipleTextMap(TextMap... maps)
    {
        this.maps = maps;
    }

    @Override
    public TextStream map(Text text)
    {
        return reader ->
        {
            for(TextMap map : maps) map.map(text).read(reader);
        };
    }
}