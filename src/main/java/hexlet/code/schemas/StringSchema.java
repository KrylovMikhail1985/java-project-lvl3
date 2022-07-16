package hexlet.code.schemas;

import java.util.Arrays;
import java.util.List;

public class StringSchema extends BaseSchema {
    public final boolean isValidForString(Object string) {
        String str = (String) string;
        if (this.getReq().equals("yes") && str.length() < 1) {
            return false;
        } else if (str.length() < this.getMin()) {
            return false;
        } else {
            return super.getCont() == null || super.getCont().size() <= 0 || containsWords(str);
        }
    }
    public final boolean containsWords(String str) {
        String[] array = str.split(" ");
        List<String> listOfWords = Arrays.asList(array);
        return listOfWords.containsAll(this.getCont());
    }
}
