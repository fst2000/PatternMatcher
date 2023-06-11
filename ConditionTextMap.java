
public class ConditionTextMap implements TextMap
{
    TextCondition condition;
    TextMap map;

    public ConditionTextMap(TextCondition condition, TextMap map)
    {
        this.condition = condition;
        this.map = map;
    }

    @Override
    public TextStream map(Text text)
    {
        if(condition.match(text)) return map.map(text);
        else return new EmptyTextStream();
    }
}