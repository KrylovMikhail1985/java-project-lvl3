package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    private Map<String, BaseSchema> shape;
    public boolean isValidForMap(Object obj) {
        if (this.getReq().equals("no") && this.getSiz() == 0 && this.shape == null) {
            return true;
        }
        if (obj instanceof Map && this.shape != null) {
            Map<Object, Object> map = (Map<Object, Object>) obj;
            return isValidWithShape(map);
        }
        if (this.getReq().equals("yes") && !(obj instanceof Map)) {
            return false;
        }
        Map<Object, Object> map = (Map<Object, Object>) obj;
        if (this.getSiz() > 0 && this.getSiz() != map.size()) {
            return false;
        }
        return true;
    }
    public BaseSchema shape(Map<String, BaseSchema> map) {
        this.shape = map;
        return this;
    }
    public boolean isValidWithShape(Map<Object, Object> map) {
        Map<String, BaseSchema> shapeMap = this.shape;
        for (Map.Entry<Object, Object> pair: map.entrySet()) {
            if (shapeMap.containsKey(pair.getKey())) {
                // вытаскиваем схему из shape по ключю и проверяем соответствует ли значение указанной схеме
                BaseSchema sss = shapeMap.get(pair.getKey());
                if (!sss.isValid(pair.getValue())) {
                    return false;
                }
            }
        }
        return true;
    }
}
