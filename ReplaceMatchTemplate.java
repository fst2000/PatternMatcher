
public class ReplaceMatchTemplate implements TextTemplate
{
    TextTemplate pattern;
    CharSequence name;

    public ReplaceMatchTemplate(TextTemplate pattern, CharSequence name)
    {
        this.pattern = pattern;
        this.name = name;
    }

    @Override
    public void match(CharSequence sequence, Reader reader)
    {
        pattern.match(sequence, text -> reader.read(name));
    }
}