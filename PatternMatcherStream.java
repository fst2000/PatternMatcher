import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherStream implements Stream
{
    CharSequence sequence;
    String patternString;
    String name;
    public PatternMatcherStream(CharSequence sequence, String pattern, String name) {
        this.sequence = sequence;
        this.patternString = pattern;
        this.name = name;
    }
    @Override
    public void read(Reader reader) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(sequence);
        if(matcher.find())
        {
            reader.read(name);
        }
    }
}
