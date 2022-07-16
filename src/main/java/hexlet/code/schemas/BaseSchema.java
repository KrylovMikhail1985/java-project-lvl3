package hexlet.code.schemas;

import hexlet.code.Validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class BaseSchema extends Validator {
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
        if (this.getReq().equals("yes")) {
            result = false;
        } else if (this.getMin() >= 0) {
            result = false;
        } else if (this.getCont() != null) {
            result = false;
//        } else if (this.getPos().equals("yes")) {
//            result = false;
        } else if (this.getSiz() > 0) {
            result = false;
        } else {
            result = this.getArray() == null;
        }
        return result;
    }
    public final BaseSchema required() {
        setReq("yes");
        return this;
    }
    public final BaseSchema positive() {
        setPos("yes");
        return this;
    }
    public final BaseSchema contains(String word) {
        if (getCont() == null) {
            setCont(new HashSet<>());
        }
        getCont().add(word);
        return this;
    }
    public final BaseSchema minLength(int number) {
        setMin(number);
        return this;
    }
    public final BaseSchema sizeof(int number) {
        setSiz(number);
        return this;
    }
    public final BaseSchema range(int number1, int number2) {
        if (getArray() != null) {
            getArray().clear();
        } else {
            setArray(new ArrayList<>());
        }
        getArray().add(number1);
        getArray().add(number2);
        ArrayList<Integer> ar = (ArrayList<Integer>) getArray().stream()
                .sorted()
                .collect(Collectors.toList());
        setArray(ar);
        return this;
    }
}
