package hexlet.code;

import hexlet.code.schemas.StringSchema;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
@Getter
public class Validator {
    @Getter
    private String req = "no";
    private int min = -1;
    private Set<String> cont;

//    public Validator() {
//    }
    public Validator required() {
        this.req = "yes";
        return this;
    }
    public final Validator minLength(int number) {
        this.min = number;
        return this;
    }
    public final Validator contains(String word) {
        if (cont == null) {
            this.cont = new HashSet<>();
        }
        this.cont.add(word);
        return this;
    }
    public final StringSchema string() {
        return new StringSchema();
    }
    protected boolean isValid(String str) {
        return true;
    }
}
