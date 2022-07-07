package hexlet.code;

import hexlet.code.schemas.StringSchema;
import java.util.HashSet;
import java.util.Set;

public class Validator {

    protected boolean req = false;
    protected int min = -1;
    protected Set<String> cont;

    public Validator() {
    }
    public final  Validator required() {
        this.req = true;
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
    public boolean isValid(String str) {
//        System.out.println("это Valid из Валидатора");
        return true;
    }
}
