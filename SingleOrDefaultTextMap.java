
public class SingleOrDefaultTextMap implements TextMap
{
    TextMap map;
    Text defaultCase;
    
    public SingleOrDefaultTextMap(TextMap map, Text defaultCase)
    {
        this.map = map;
        this.defaultCase = defaultCase;
    }
    @Override
    public TextStream map(Text text)
    {
        return new DefaultCaseTextStream(new FirstTextStream(map.map(text)), defaultCase);
    }
}