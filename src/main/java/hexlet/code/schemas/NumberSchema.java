package hexlet.code.schemas;
public class NumberSchema extends BaseSchema {
    public final boolean isValidForNumber(Object obj) {
        if (!(obj instanceof Integer)) {
            return false;
        }
        int number = (int) obj;
        if (this.getPos().equals("yes") && number < 1) {
            return false;
        } else {
            return this.getArray() == null
                    || (this.getArray().get(0) <= number && this.getArray().get(1) >= number);
        }
    }
}
