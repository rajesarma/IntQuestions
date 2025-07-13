package com.lakshmi.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTesting {

//    Optional
//    Stream
//        filter
//        iterate
//        map
//        sort
//        reduce

    public static void main(String[] args) {
        List<String> al = Arrays.asList("A1", "A2", "B3", "4", "B4", "C3");

        /*al.forEach(System.out::print);

        al.stream()
                .filter(s -> s.startsWith("B"))
                .findFirst()
                .ifPresent(System.out::println);*/

        List<String> al1 = al.stream()
                .filter(s -> s.startsWith("A"))
                .collect(Collectors.toList());
        al1.forEach(System.out::println);

        long count = al.stream()
                .filter(s -> s.startsWith("A"))
                .count();
        System.out.println(count);

        Employee e1 = Employee.builder().name("Abc").salary(1000L).build();
        Employee e2 = Employee.builder().name("Def").salary(2000L).build();
        Employee e3 = Employee.builder().name("Ghi").salary(3000L).build();
        Employee e4 = Employee.builder().name("ijk").salary(4000L).build();

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4);
        List<Employee> employees1 = employees.stream()
                .filter(emp -> emp.getSalary() > 2000)
                .collect(Collectors.toList());

        employees1.forEach(System.out::println);

        List<String> employeesNames = employees.stream()
                .filter(emp -> emp.getSalary() > 2000)
                .map(Employee::getName)
                .collect(Collectors.toList());

        employeesNames.forEach(System.out::println);

        Map<String, Long> employees2 = employees.stream()
                .filter(emp -> emp.getSalary() > 2000)
                .collect(Collectors.toMap(Employee::getName, Employee::getSalary));

        employees2.entrySet().forEach(System.out::println);


        Stream.of("a1", "a2", "a3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);  // 3

        String s = new String("Test");

        /*Optional<String> o = Optional.of(s);
        Optional<String> o1 = Optional.empty();
        o.ifPresent(System.out::println);
        o.ifPresent(s1 -> {
                    printThis(s1);
                }
        );

        o.ifPresent(StreamTesting::printThis);*/

        /*o1.ifPresentOrElse(
                s1 -> {
                    System.out.println(s1);
                },
                () -> {
                    System.out.println("No Data");
                });*/

        /*if(o1.isPresent()) {
            ////
            System.out.println(o1.get());
        } else {
            ////
            System.out.println(o1.get());
        }*/

//        List<Employee> employees =

        // Find First
        // If present
        // maptoInt
    }

    /**
     * Method to aceept String value to pring
     * @param value takes
     */
    private static void printThis(String value) {
        System.out.println(value);
    }


}
