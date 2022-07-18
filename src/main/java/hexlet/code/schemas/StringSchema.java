package hexlet.code.schemas;

import java.util.HashSet;
import java.util.Set;

public final class StringSchema extends BaseSchema {
    private int min = -1;
    private Set<String> cont;
    public boolean isValidForString(Object string) {
        if (string == null) {
            return isValidForNull();
        }
        String str = (String) string;
        if (this.getReq().equals("yes") && str.length() < 1) {
            return false;
        } else if (str.length() < this.min) {
            return false;
        } else {
            return this.cont == null || this.cont.size() <= 0 || containsWords(str);
        }
    }
    public boolean isValidForNull() {
        return getReq().equals("no") && this.min == -1 && cont == null;
    }
    public boolean containsWords(String str) {
        for (String word: this.cont) {
            if (!str.contains(word)) {
                return false;
            }
        }
        return true;
    }
    @Override
    public StringSchema required() {
        setReq("yes");
        return this;
    }
    public StringSchema contains(String word) {
        if (this.cont == null) {
            this.cont = new HashSet<>();
        }
        this.cont.add(word);
        return this;
    }
    public StringSchema minLength(int number) {
        this.min = number;
        return this;
    }
}
