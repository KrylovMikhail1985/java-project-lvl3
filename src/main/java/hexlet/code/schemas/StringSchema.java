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
        if (req) {
            return false;
        } else if (min >= 0) {
            return false;
        } else {
            return cont == null;
        }
    }
    public final boolean isValidForString(String str) {
        if (req && str.length() < 1) {
            return false;
        } else if (str.length() <= min) {
            return false;
        } else {
            return cont == null || cont.size() <= 0 || containsWords(str);
        }
    }
    public final boolean containsWords(String str) {
        String[] array = str.split(" ");
        List<String> listOfWords = Arrays.asList(array);
        return listOfWords.containsAll(cont);
    }
}
