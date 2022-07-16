package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
@Getter
@Setter
public class BaseSchema {
    private String req = "no";
    private String pos = "no";
    private int min = -1;
    private ArrayList<Integer> array;
    private Set<String> cont;
    private int siz = 0;
    public final boolean isValid(Object obj) {
        boolean result;
        if (obj == null) {
            result = isValidForNull();
        } else if (this instanceof NumberSchema) {
            result = ((NumberSchema) this).isValidForNumber(obj);
        } else if (this instanceof MapSchema) {
            result = ((MapSchema) this).isValidForMap(obj);
        } else {
            result = ((StringSchema) this).isValidForString(obj);
        }
        return result;
    }
    public final boolean isValidForNull() {
        boolean result;
        if (req.equals("yes")) {
            result = false;
        } else if (min > 0) {
            result = false;
        } else if (cont != null) {
            result = false;
        } else if (siz > 0) {
            result = false;
        } else {
            result = array == null;
        }
        return result;
    }
    public final BaseSchema required() {
        this.req = "yes";
        return this;
    }
    public final BaseSchema positive() {
        this.pos = "yes";
        return this;
    }
    public final BaseSchema contains(String word) {
        if (cont == null) {
            this.cont = new HashSet<>();
        }
        cont.add(word);
        return this;
    }
    public final BaseSchema minLength(int number) {
        this.min = number;
        return this;
    }
    public final BaseSchema sizeof(int number) {
        this.siz = number;
        return this;
    }
    public final BaseSchema range(int number1, int number2) {
        if (array != null) {
            array.clear();
        } else {
            this.array = new ArrayList<>();
        }
        array.add(number1);
        array.add(number2);
        ArrayList<Integer> ar = (ArrayList<Integer>) array.stream()
                .sorted()
                .collect(Collectors.toList());
        this.array = ar;
        return this;
    }
}
