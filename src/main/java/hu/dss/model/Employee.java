package hu.dss.model;

import java.util.Arrays;

public enum Employee {
    Ü1("Ü1"),
    Ü2("Ü2"),
    Ü3("Ü3");

    private final String id;

    Employee(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static Employee getEmployeeById(String id) {
        return Arrays.stream(Employee.values())
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
