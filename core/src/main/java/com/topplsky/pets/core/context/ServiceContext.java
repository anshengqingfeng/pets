package com.topplsky.pets.core.context;

import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class ServiceContext {

    public static final String USER_ID = "userId";
    public static final String LOGIN_TOKEN = "loginToken";
    public static final String REQUESTED_API = "requestedAPI";

    private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    public static void dispose() {
        if (threadLocal.get() != null) {
            threadLocal.remove();
        }
    }

    public static int size() {
        if (threadLocal.get() == null) {
            threadLocal.set(Maps.newHashMap());
        }
        return threadLocal.get().size();
    }

    public static boolean isEmpty() {
        if (threadLocal.get() == null) {
            threadLocal.set(Maps.newHashMap());
        }
        return threadLocal.get().isEmpty();
    }

    public static boolean containsKey(String key) {
        if (threadLocal.get() == null) {
            threadLocal.set(Maps.newHashMap());
        }
        return threadLocal.get().containsKey(key);
    }

    public static boolean containsValue(Object value) {
        if (threadLocal.get() == null) {
            threadLocal.set(Maps.newHashMap());
        }
        return threadLocal.get().containsValue(value);
    }

    public static Object get(String key) {
        if (threadLocal.get() == null) {
            threadLocal.set(Maps.newHashMap());
        }
        return threadLocal.get().get(key);
    }

    public static Object put(String key, Object value) {
        if (threadLocal.get() == null) {
            threadLocal.set(Maps.newHashMap());
        }
        return threadLocal.get().put(key, value);
    }

    public static Object remove(String key) {
        if (threadLocal.get() == null) {
            threadLocal.set(Maps.newHashMap());
        }
        return threadLocal.get().remove(key);
    }

    public static void putAll(Map<? extends String, ?> m) {
        if (threadLocal.get() == null) {
            threadLocal.set(Maps.newHashMap());
        }
        threadLocal.get().putAll(m);
    }

    public static void clear() {
        if (threadLocal.get() == null) {
            threadLocal.set(Maps.newHashMap());
        }
        threadLocal.get().clear();
    }

    public static Set<String> keySet() {
        if (threadLocal.get() == null) {
            threadLocal.set(Maps.newHashMap());
        }
        return threadLocal.get().keySet();
    }

    public static Collection<Object> values() {
        if (threadLocal.get() == null) {
            threadLocal.set(Maps.newHashMap());
        }
        return threadLocal.get().values();
    }

    public static Set<Map.Entry<String, Object>> entrySet() {
        if (threadLocal.get() == null) {
            threadLocal.set(Maps.newHashMap());
        }
        return threadLocal.get().entrySet();
    }
}
