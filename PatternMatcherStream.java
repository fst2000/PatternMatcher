import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherStream implements Stream
{
    CharSequence sequence;
    String patternString;
    Stream output;
    public PatternMatcherStream(CharSequence sequence, String pattern, Stream output) {
        this.sequence = sequence;
        this.patternString = pattern;
        this.output = output;
    }
    @Override
    public void read(Reader reader) {
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(sequence);
        if(matcher.find())
        {
            output.read(reader);
        }
    }
}
