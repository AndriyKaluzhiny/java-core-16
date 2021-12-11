package ua.lviv.lgs;

import java.lang.reflect.*;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Bus> cl = Bus.class;

        // minimum 1

        // get Name
        String name = cl.getName();
        System.out.println("Name of class: " + name);

        // get package
        Package p = cl.getPackage();
        System.out.println("Package is: " + p);

        // get Fields
        Field[] f = cl.getDeclaredFields();
        System.out.println("Fields: " + Arrays.toString(f));

        // get SuperClass
        Class<? super Bus> superclass = cl.getSuperclass();
        System.out.println("SuperClass for class " + cl.getName() + " " + "is" + " " + superclass);

        // get modifiers
        int modifier = cl.getModifiers();
        String mText = Modifier.toString(modifier);
        System.out.println("Class modifiers are: " + mText + " int: " + modifier);

        // isStatic
        System.out.println("Is static: " + Modifier.isStatic(modifier));

        // isPublic
        System.out.println("Is public: " + Modifier.isPublic(modifier));

        // constructor length
        Constructor<?>[] busConstructor = cl.getConstructors();
        System.out.println("Constructor size is: " + (busConstructor.length + 1));

        // get constructor's params types
        Constructor<?> busConstructor1 = busConstructor[0];

        Class<?>[] params = busConstructor1.getParameterTypes();

        for (int i = 0; i < params.length; i++) {
            Class<?> class1 = params[i];
            System.out.println("Constructor params are: " + class1);
        }

        // get constructor by params
        Constructor<Bus> constructor = cl.getConstructor(int.class, double.class, String.class, int.class);
        System.out.println(constructor);

        //maximum 1
        Bus bus = constructor.newInstance(250, 23.5, "Electron", 24);

        System.out.println("Before reset nameOfCompany: " + bus);

        System.out.println(" ");

        Field companyField = cl.getDeclaredField("nameOfCompany");
        companyField.set(bus, "Bogdan");
        System.out.println(" ");
        System.out.println("Bus(After reset): "+ bus);

        //maximum 2
        Method[] methods = cl.getMethods();

        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }
        System.out.println(" ");
        methods[5].invoke(bus, 13);

        System.out.println(bus);
    }
}
