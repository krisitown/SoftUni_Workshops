package generator;

import data.FullTimeEmployee;

public abstract class EmployeeGenerator {
    private static long ID_COUNTER = 1;

    public FullTimeEmployee generate(Double salary) {
        return new FullTimeEmployee(ID_COUNTER++, getTitle(), salary);
    }

    protected abstract String getTitle();
}
