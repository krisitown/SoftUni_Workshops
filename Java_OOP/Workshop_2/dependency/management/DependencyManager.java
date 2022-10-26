package dependency.management;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DependencyManager {
    private Map<Class, Class> implementations = new HashMap<>();
    private Map<String, Object> instances = new HashMap<>();
    public DependencyManager(Class... classPath) {
        Arrays.stream(classPath).forEach(this::loadClass);
    }

    public <T> T createInstance(String name) {
        try {
            return (T) createInstance(Class.forName(name));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public<T> T createInstance(Class<T> type) {
        String name = type.getName();
        if(instances.containsKey(name)) {
            return (T) instances.get(name);
        }

        try {
            return createInstanceIfNotExisting(name);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void loadClass(Class klass) {
        if (klass.isInterface()) {
            implementations.putIfAbsent(klass, null);
        } else {
            handleImplementation(klass);
        }
    }

    private void handleImplementation(Class klass) {
        Class[] interfaces = klass.getInterfaces();
        for (Class interfaceClass : interfaces) {
            implementations.putIfAbsent(interfaceClass, klass);
        }
        implementations.put(klass, klass);
    }

    private <T> T createInstanceIfNotExisting(String name) throws Exception {
        //1. Get the constructor of the object we want to create
        Constructor constructor = implementations.get(Class.forName(name)).getConstructors()[0];

        //2. Get the type of each parameters of the constructor
        Class[] constructorArguments = constructor.getParameterTypes();

        //3. Create an instance for each of the parameters
        Object[] arguments = Arrays.stream(constructorArguments)
                .map(this::createInstance)
                .toArray();

        //4. Invoke the constructor using the instances created in step 3
        Object instance = constructor.newInstance(arguments);

        //5. Save the instance for future calls
        instances.put(name, instance);

        return (T) instance;
    }
}
