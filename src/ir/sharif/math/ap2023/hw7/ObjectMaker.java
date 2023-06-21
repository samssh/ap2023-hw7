package ir.sharif.math.ap2023.hw7;


import java.lang.reflect.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class ObjectMaker {
    private static final List<Class<?>> primitiveClasses = Arrays.asList(
            boolean.class,
            short.class,
            byte.class,
            int.class,
            long.class,
            float.class,
            double.class,
            String.class
    );
    private final URLClassLoader classLoader;

    public ObjectMaker(URL... urls) {
        classLoader = new URLClassLoader(urls);
    }

    public Object makeObject(Map<String, Object> values, String className) throws ReflectiveOperationException {
        Class<?> clazz = classLoader.loadClass(className);
        Object result = makeObject0(values, clazz);
        fillPaths(result, result, "");
        return result;
    }

    private Method getMethodAsConstructor(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (Modifier.isStatic(method.getModifiers())) {
                UseAsConstructor annotation = method.getAnnotation(UseAsConstructor.class);
                if (annotation != null) {
                    return method;
                }
            }
        }
        return null;
    }

    private String getFieldName(Field field) {
        Name nameAnnotation = field.getAnnotation(Name.class);
        return nameAnnotation == null ? field.getName() : nameAnnotation.name();
    }

    private List<Field> getAllFields(Class<?> clazz) {
        List<Field> result = new LinkedList<>();
        while (clazz.getSuperclass() != null) {
            result.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return result;
    }

    private Object makeObject0(Object object, Class<?> clazz) throws ReflectiveOperationException {
        if (primitiveClasses.contains(clazz)) {
            return object; // no need to parsing
        } else if (clazz.isArray()) {
            List<?> list = (List<?>) object;
            Class<?> componentsType = clazz.getComponentType();
            Object result = Array.newInstance(componentsType, list.size());
            int i = 0;
            for (Object o : list) {
                Array.set(result, i, makeObject0(o, componentsType));
                i++;
            }
            return result;
        } else {
            Map<?, ?> values = (Map<?, ?>) object;
            Object result;
            Method alternativeConstructor = getMethodAsConstructor(clazz);
            if (alternativeConstructor != null) {
                UseAsConstructor annotation = alternativeConstructor.getAnnotation(UseAsConstructor.class);
                Object[] args = Arrays.stream(annotation.args()).map(values::get).toArray();
                alternativeConstructor.setAccessible(true);
                result = alternativeConstructor.invoke(null, args);
            } else {
                Constructor<?> constructor = clazz.getDeclaredConstructor();
                constructor.setAccessible(true);
                result = constructor.newInstance();
            }
            clazz = result.getClass();
            for (Field field : getAllFields(clazz)) {
                if (Modifier.isStatic(field.getModifiers())) continue;
                // make field accessible
                field.setAccessible(true);
                Field modifiersField = Field.class.getDeclaredField("modifiers");
                modifiersField.setAccessible(true);
                modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
                String name = getFieldName(field);
                if (values.containsKey(name))
                    field.set(result, makeObject0(values.get(name), field.getType()));
            }
            return result;
        }
    }

    private List<String> makePath(String currentPath, String annotationPath) {
        List<String> result = new LinkedList<>(Arrays.asList(currentPath.split("/")));
        for (String name : annotationPath.split("/")) {
            if ("..".equals(name)) result.remove(result.size() - 1);
            else result.add(name);
        }
        return result;
    }

    private Object getValueByName(Object object, String name) throws ReflectiveOperationException {
        for (Field field : object.getClass().getDeclaredFields()) {
            String fieldName = getFieldName(field);
            if (fieldName.equals(name)) {
                field.setAccessible(true);
                return field.get(object);
            }
        }
        throw new NoSuchFieldException("no field with name " + name + "for class " + object.getClass());
    }

    private Object getObjectFromPath(Object root, List<String> path) throws ReflectiveOperationException {
        Object result = root;
        for (String name : path) {
            if (name.length() == 0)
                continue;
            if (result == null) {
                throw new NullPointerException();
            }
            result = getValueByName(result, name);
        }
        return result;
    }

    private void fillPaths(Object root, Object object, String currentPath) throws ReflectiveOperationException {
        for (Field field : getAllFields(object.getClass())) {
            if (Modifier.isStatic(field.getModifiers())) continue;
            String name = getFieldName(field);
            field.setAccessible(true);
            SetValue annotation = field.getAnnotation(SetValue.class);
            if (annotation == null) {
                if (!primitiveClasses.contains(field.getType()))
                    fillPaths(root, field.get(object), currentPath + "/" + name);
                continue;
            }
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            field.set(object, getObjectFromPath(root, makePath(currentPath, annotation.path())));
        }
    }

}
