package HW3.OrgStructure;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class OrgStructureParserTest {
    public static void main(String[] args) {
        File csvFile = new File("HW3/OrgStructure/csvFile.csv");
        OrgStructureParser parser = new OrgStructureParserImpl();
        try {
            Employee topLevelEmployee = parser.parseStructure(csvFile);

            printEmployee(topLevelEmployee);
        } catch (IOException e) {
            System.out.println("При чтении файла произошла ошибка: " + e.getMessage());
        }
    }

    private static void printEmployee(Employee employee) {
        System.out.println("id:" + employee.getId() + " name: " + employee.getName() + " position: "
                + employee.getPosition() + " bossId: " + employee.getBossId() + " boss: " + employee.getBoss());
        List<Employee> subordinates = employee.getSubordinate();
        for (Employee subordinate : subordinates) {
            printEmployee(subordinate);
        }
    }
}