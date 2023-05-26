
public class MultipleTextTemplate implements TextTemplate
{
    TextTemplate[] templates;

    public MultipleTextTemplate(TextTemplate[] templates)
    {
        this.templates = templates;
    }

    @Override
    public void match(CharSequence sequence, Reader reader)
    {
        for(TextTemplate template : templates) template.match(sequence, reader);
    }
}