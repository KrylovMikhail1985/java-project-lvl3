package hexlet.code.schemas;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseSchema {
    private String req = "no";
    public boolean isValid(Object obj) {
        boolean result;
//        if (this instanceof NumberSchema) {
//            result = ((NumberSchema) this).isValidForNumber(obj);
        if (this instanceof MapSchema) {
            result = ((MapSchema) this).isValidForMap(obj);
        } else {
            result = ((StringSchema) this).isValidForString(obj);
        }
        return result;
    }

    /**
     * Method for setting required index from yes to no.
     * @return is same class
     */
    public BaseSchema required() {
        this.req = "yes";
        return this;
    }
}
