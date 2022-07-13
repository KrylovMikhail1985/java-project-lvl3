package hexlet.code.schemas;

import hexlet.code.Validator;

public class BaseSchema extends Validator {
    @Override
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
        if (this.getReq().equals("yes")) {
            return false;
        } else if (this.getMin() >= 0) {
            return false;
        } else if (this.getCont() != null) {
            return false;
        } else if (this.getPos().equals("yes")) {
            return false;
        } else if (this.getSiz() > 0) {
            return false;
        } else {
            return this.getArray() == null;
        }
    }
}
