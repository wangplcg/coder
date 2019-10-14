package cn.com.im.protocol;

/**
 * Description:
 * User: wangpl
 * Date: 2019-08-11
 * Time: 22:28
 */

public enum SerializerEnum {

    JSON(1, JSONSerializer.class);

    private int serializerId;

    private Class serializerType;

    public int getSerializerId() {
        return serializerId;
    }

    public Class getSerializerType() {
        return serializerType;
    }

    SerializerEnum(int serializerId, Class serializerType) {
        this.serializerId = serializerId;
        this.serializerType = serializerType;
    }

    public static SerializerEnum getById(int id) {
        SerializerEnum[] values = SerializerEnum.values();
        for (SerializerEnum serializer : values) {
            if (id == serializer.serializerId) {
                return serializer;
            }
        }
        return null;
    }
}
