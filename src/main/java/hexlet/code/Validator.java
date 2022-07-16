package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Set;

@Getter
@Setter
public class Validator {
    private String req = "no";
    private String pos = "no";
    private int min = -1;
    private ArrayList<Integer> array;
    private Set<String> cont;
    private int siz = 0;

    public final StringSchema string() {
        return new StringSchema();
    }
    public final NumberSchema number() {
        return new NumberSchema();
    }
    public final MapSchema map() {
        return new MapSchema();
    }

//    @Override
//    public  String toString() {
//        return "req = " + req + "; pos = " + pos + "; min =" + min;
//    }
}
