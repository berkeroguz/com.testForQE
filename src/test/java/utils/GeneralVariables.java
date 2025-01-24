package utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class GeneralVariables {

    public static ThreadLocal<ConcurrentMap<String, String>> variableMapList = ThreadLocal.withInitial(ConcurrentHashMap::new);

    public static void saveValue(String key, String value) {
        variableMapList.get().put(key, value);
        Log.info("' "+ value + " ' ifadesi '" + " " + key + " ' olarak saklaniyor");
    }

    public static String getValue(String key) {
        return variableMapList.get().get(key);
    }
}
