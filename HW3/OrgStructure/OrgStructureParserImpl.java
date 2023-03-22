package HW3.OrgStructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class OrgStructureParserImpl implements OrgStructureParser {

    @Override
    public Employee parseStructure(File csvFile) throws IOException {
        Map<Long, Employee> employees = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(";");

                Long id = Long.parseLong(fields[0]);
                Long bossId = tryParseLong(fields[1]);
                String name = fields[2];
                String position = fields[3];

                Employee employee = new Employee();
                employee.setId(id);
                employee.setBossId(bossId);
                employee.setName(name);
                employee.setPosition(position);

                employees.put(id, employee);
            }
        }

        // employee - boss
        for (Employee employee : employees.values()) {
            Long bossId = employee.getBossId();
            if (bossId != null) {
                Employee boss = employees.get(bossId);
                if (boss != null) {
                    employee.setBoss(boss);
                    boss.getSubordinate().add(employee);
                }
            }
        }

        // Boss
        List<Employee> topLevelBosses = employees.values().stream().filter(e -> e.getBossId() == null)
                .collect(Collectors.toList());
        if (topLevelBosses.size() != 1) {
            throw new IllegalStateException("Босс: " + topLevelBosses.size());
        }

        return topLevelBosses.get(0);
    }

    private Long tryParseLong(String s) {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}