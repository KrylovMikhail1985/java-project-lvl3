package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    public boolean isValidForMap(Object obj) {
        if (this.getReq().equals("no")) {
            return true;
        } else if (!(obj instanceof Map)) {
            return false;
        }
        if (this.getSiz() == 0) {
            return true;
        }
        Map<Object, Object> map = (Map<Object, Object>) obj;
        return this.getSiz() <= map.size();
    }
}
