package lr9_2.Repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lr9_2.DTO.Card;
import lr9_2.DTO.Employee;

@SpringBootTest
public class CardRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private CardRepo cardRepo;

    @Test
    public void GetCardId_Card_CalledGetCardIdToCheckCardtData() {
        // Arrange
        Employee employee = new Employee("Anna", "Willington", null, null, null, null, null, null);
        Card card = new Card(false, null);
        employee.setCard(card);

        // Act
        employeeRepo.save(employee);
        cardRepo.save(card);

        Integer expectedCardId = employee.getCard().getCardId();
        Integer actualCardId = cardRepo.findById(card.getCardId()).get().getCardId();

        // Assert
        assertEquals(expectedCardId, actualCardId);
    }
}