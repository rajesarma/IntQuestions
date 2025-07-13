package interviews.hcl;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class SumTwoNumbersEqualsTarget {
	
	// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	// You may assume that each input would have exactly one solution, and you may not use the same element twice.

	public static void main(String[] args) {

        HashMap<Customer, String> dobMap = new HashMap<>();
        Customer customer1 = new Customer();
        customer1.setName("abc");
        customer1.setAge(65);
        Customer customer2 = new Customer();
        customer2.setName("def");
        customer2.setAge(55);
        Customer customer3 = new Customer();
        customer3.setName("def");
        customer3.setAge(55);

        dobMap.put(customer1, "1982-08-01");
        dobMap.put(customer2, "1972-08-01");
        dobMap.put(customer3, "1952-08-01");

        HashMap<Customer, Double> amountMap = new HashMap<>();

        amountMap.put(customer1, 1000.00);
        amountMap.put(customer2, 2000.00);
        amountMap.put(customer3, 4000.00);

        Map<Customer, Double> outPutMap = calculateInterest(dobMap, amountMap);

        System.out.println(outPutMap);

	}

	public static TreeMap<Customer, Double> calculateInterest(HashMap<Customer, String> dobMap, HashMap<Customer, Double> amountMap) {

        TreeMap<Customer, Double> outPutMap = new TreeMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);

        dobMap.entrySet()
                .forEach(e -> {
                            if(amountMap.containsKey(e.getKey())) {
                                String dob = e.getValue();

                                LocalDate dobDate = LocalDate.parse(dob, formatter);
                                int age = Period.between(dobDate, LocalDate.now()).getYears();
                                System.out.print(age + " years ");

                                double updateAmount = 0;
                                double balanceAmount = amountMap.get(e.getKey());
                                if(age > 60) {
                                    updateAmount = balanceAmount + (balanceAmount * 0.1);
                                } else if(age > 40) {
                                    updateAmount = balanceAmount + (balanceAmount * 0.05);
                                } else {
                                    updateAmount = balanceAmount + (balanceAmount * 0.04);
                                }
                                outPutMap.putIfAbsent(e.getKey(), updateAmount);
                            }
                        }
                        );
        return outPutMap;
    }


    static class Customer implements Comparable{
	    private String name;
	    private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Object o)
        {
            if(this.age == ((Customer)o).age)
                return 0;
            else if (this.age <((Customer)o).age)
                return 1;
            else
                return -1;
        }
    }

}
