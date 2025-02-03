package stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

/*Q8. Custom Collector for Aggregation Write a custom collector to
aggregate employee salaries into a department-wise total.*/
public class Q8Stream {
    public static void main(String[] args) {
        //list of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Krushit", "JAVA", 15000),
                new Employee("D.Shah", "HR", 12000),
                new Employee("Diven", ".NET", 15000),
                new Employee("Vinay", "JAVA", 15000)
        );

        //
        Map<String, Integer> departmentWiseSalary = employees.parallelStream()
                .collect(Collector.of(
                        HashMap::new,
                        (hashMap, employee) -> {
                            hashMap.merge(employee.getDepartment(), employee.getSalary(), Integer::sum);
                        },
                        (map1, map2) -> { //for parallel stream
                            map2.forEach((k, v) -> map1.merge(k, v, Integer::sum));
                            return map1;
                        }

                ));

        System.out.println(departmentWiseSalary);
    }
}
