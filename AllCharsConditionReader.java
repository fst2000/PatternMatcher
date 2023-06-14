public class AllCharsConditionReader implements Reader
{
    Reader reader;
    CharacterCondition condition;
    public AllCharsConditionReader(Reader reader, CharacterCondition condition) {
        this.reader = reader;
        this.condition = condition;
    }
    @Override
    public void read(CharSequence sequence)
    {
        int length = sequence.length();
        boolean allHasCondition;
        allHasCondition = length != 0;
        for(int i = 0; i < length; i++)
        {
            allHasCondition = !condition.check(sequence.charAt(i));
        }
        if(allHasCondition) reader.read(sequence);
    }
    
}
