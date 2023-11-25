package lr9_2.Repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lr9_2.DTO.Employee;
import lr9_2.DTO.Position;

@SpringBootTest
public class PositionRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private PositionRepo positionRepo;

    @Test
    public void GetPositionId_Position_CalledGetPositionIdToCheckPositionData() {
        // Arrange
        Employee employee = new Employee("Anna", "Willington", null, null, null, null, null, null);
        Position position = new Position("SEO");
        employee.setPosition(position);

        // Act
        employeeRepo.save(employee);
        positionRepo.save(position);

        Integer expectedPositionId = employee.getPosition().getPositionId();
        Integer actualPositionId = positionRepo.findById(employee.getPosition().getPositionId()).get().getPositionId();

        // Assert
        assertEquals(expectedPositionId, actualPositionId);
    }
}