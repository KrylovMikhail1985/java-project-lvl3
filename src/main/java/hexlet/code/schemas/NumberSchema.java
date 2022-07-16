package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.stream.Collectors;

public final class NumberSchema extends BaseSchema {
    private String pos = "no";
    private ArrayList<Integer> range;
    public boolean isValidForNumber(Object obj) {
        if (obj == null) {
            return isValidForNull();
        }
        if ((getReq().equals("yes") || range != null || this.pos.equals("yes")) && !(obj instanceof Integer)) {
            return false;
        }
        int number = 0;
        if (obj instanceof Integer) {
            number = (int) obj;
        }
        if (getReq().equals("yes") && number < 0) {
            return false;
        }
        if (this.pos.equals("yes") && number < 1) {
            return false;
        } else {
            return this.range == null
                    || (this.range.get(0) <= number && this.range.get(1) >= number);
        }
    }
    public boolean isValidForNull() {
        return getReq().equals("no") && this.range == null;
    }
    public NumberSchema positive() {
        this.pos = "yes";
        return this;
    }
    @Override
    public NumberSchema required() {
        setReq("yes");
        return this;
    }
    public NumberSchema range(int number1, int number2) {
        if (range != null) {
            range.clear();
        } else {
            this.range = new ArrayList<>();
        }
        range.add(number1);
        range.add(number2);
        ArrayList<Integer> ar = (ArrayList<Integer>) range.stream()
                .sorted()
                .collect(Collectors.toList());
        this.range = ar;
        return this;
    }
}
