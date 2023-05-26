import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchTemplate implements TextTemplate
{
    Pattern pattern;
    public PatternMatchTemplate(String pattern)
    {
        this.pattern = Pattern.compile(pattern);
    }
    public void match(CharSequence sequence, Reader reader) {
        Matcher matcher = pattern.matcher(sequence);
        if(matcher.find())
        {
            reader.read(matcher.group(0));
        }
    }
}
