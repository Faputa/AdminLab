package adminlab.util;

import java.lang.reflect.Method;

/**
 * 枚举工具类
 * 
 * @author zhangyin
 */
public interface EnumUtil<T> {

    T getValue();

    /**
     * value转枚举
     * 
     * @param <E>   枚举类型
     * @param <T>   value类型
     * @param clazz 枚举类
     * @param value value
     * @return 枚举对象
     * @throws RuntimeException
     */
    static <E extends Enum<E> & EnumUtil<T>, T> E valueOf(Class<E> clazz, T value) {
        try {
            Method getValueMethod = clazz.getDeclaredMethod("getValue");
            Object[] objects = (Object[]) clazz.getMethod("values").invoke(null);
            for (Object object : objects) {
                if (java.util.Objects.equals(value, getValueMethod.invoke(object))) {
                    return clazz.cast(object);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
