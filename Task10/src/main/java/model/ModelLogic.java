package model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ModelLogic implements Model {
    @Override
    public void createAnnotation() {
        Person person = new Person("Denys", "Horbachenko");
        Employee employee = Person.class.getAnnotation(Employee.class);

        System.out.println("Name: " + person.name);
        System.out.println("Surname: " + person.surname);
        System.out.println("Company: " + employee.company());
        System.out.println("Position: " + employee.position());
    }

    @Override
    public void invokeThreeMethods() {
        ThreeMethods threeMethods = new ThreeMethods();
        Class myClass = threeMethods.getClass();

        try {
            Method method1 = myClass.getMethod("method1", String.class);
            System.out.println(method1.invoke(threeMethods, "Hello"));
            Method method2 = myClass.getMethod("method2", int.class);
            System.out.println(method2.invoke(threeMethods, 1));

            Method method3 = myClass.getDeclaredMethod("method3");
            method3.setAccessible(true);
            method3.invoke(threeMethods);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
