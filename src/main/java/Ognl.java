import java.util.Collection;
import java.util.Map;

public class Ognl {

    /**
     * 可以用于判断String,Long,Integer,Map,Array,Collection是否为空
     * 
     * @param o Object
     * @return
     */
    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof String && ((String) o).trim().length() == 0) {
            return true;
        }
        if (o instanceof Map && ((Map<?, ?>) o).isEmpty()) {
            return true;
        }
        if (o.getClass().isArray() && ((Object[]) o).length == 0) {
            return true;
        }
        if (o instanceof Collection && ((Collection<?>) o).isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 可以用于判断String,Long,Integer,Map,Array,Collection是否不为空
     * 
     * @param o Object
     * @return
     */
    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }

    /**
     * 可以用于判断是否为数值类型
     * 
     * @param o Object
     * @return
     */
    public static boolean isNumber(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Number) {
            return true;
        }
        if (o instanceof String) {
            try {
                Double.parseDouble((String) o);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }

    /**
     * 可以用于判断是否不为数值类型
     * 
     * @param o Object
     * @return
     */
    public static boolean isNotNumber(Object o) {
        return !isNumber(o);
    }

}
