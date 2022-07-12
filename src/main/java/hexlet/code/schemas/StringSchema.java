package hexlet.code.schemas;

import hexlet.code.Validator;
import java.util.Arrays;
import java.util.List;

public class StringSchema extends Validator {
    @Override
    public final boolean isValid(String str) {
        boolean result;
        if (str == null) {
            result = isValidForNull();
        } else {
            result = isValidForString(str);
        }
//        str == null ? result = isValidForNull() : result = isValidForString(str);
        return result;
    }
    public final boolean isValidForNull() {
        if (this.getReq().equals("yes")) {
            return false;
        } else if (this.getMin() >= 0) {
            return false;
        } else {
            return this.getCont() == null;
        }
    }
    public final boolean isValidForString(String str) {
        if (this.getReq().equals("yes") && str.length() < 1) {
            return false;
        } else if (str.length() <= this.getMin()) {
            return false;
        } else {
            return this.getCont() == null || this.getCont().size() <= 0 || containsWords(str);
        }
    }
    public final boolean containsWords(String str) {
        String[] array = str.split(" ");
        List<String> listOfWords = Arrays.asList(array);
        return listOfWords.containsAll(this.getCont());
    }
}
