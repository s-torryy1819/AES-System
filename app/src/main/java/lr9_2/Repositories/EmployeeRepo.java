package lr9_2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lr9_2.DTO.Employee;

@EnableJpaRepositories
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}