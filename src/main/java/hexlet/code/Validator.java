package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class Validator {
    @Getter
    private String req = "no";
    private String pos = "no";
    private int min = -1;
    private ArrayList<Integer> array;
    private Set<String> cont;
    private int siz = 0;

    /**
     * @return yes if required on
     */
    public Validator required() {
        this.req = "yes";
        return this;
    }
    public final Validator minLength(int number) {
        this.min = number;
        return this;
    }
    public final Validator sizeOf(int number) {
        this.siz = number;
        return this;
    }
    public final Validator contains(String word) {
        if (cont == null) {
            this.cont = new HashSet<>();
        }
        this.cont.add(word);
        return this;
    }
    public final Validator positive() {
        this.pos = "yes";
        return this;
    }
    public final Validator range(int number1, int number2) {
        if (this.array != null) {
            this.array.clear();
        } else {
            this.array = new ArrayList<>();
        }
        this.array.add(number1);
        this.array.add(number2);
        this.array = (ArrayList<Integer>) this.array.stream()
                .sorted()
                .collect(Collectors.toList());
        return this;
    }
    public final StringSchema string() {
        return new StringSchema();
    }
    public final NumberSchema number() {
        return new NumberSchema();
    }
    public final MapSchema mapShema() {
        return new MapSchema();
    }

    /**
     * @param obj some Object for checking
     * @return true if all terms will be true
     */
    public boolean isValid(Object obj) {
        return true;
    }
}
