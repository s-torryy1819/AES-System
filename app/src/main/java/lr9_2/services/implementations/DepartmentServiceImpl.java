package lr9_2.services.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lr9_2.DTO.Department;
import lr9_2.Repositories.DepartmentRepo;
import lr9_2.services.interfaces.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepo departmentRepo;

    public DepartmentServiceImpl(DepartmentRepo departmentRepo) {
        super();
        this.departmentRepo = departmentRepo;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public Department createDepartment(Department card) {
        return departmentRepo.save(card);
    }

    @Override
    public Department getDepartmentById(Integer id) throws Exception {
        Optional<Department> card = departmentRepo.findById(id);

        if (!card.isPresent()) {
            throw new NoSuchElementException("Department with id: " + id + " was not found.");
        }

        return card.get();
    }
}
