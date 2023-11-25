package lr9_2.services.interfaces;

import java.util.List;

import lr9_2.DTO.Department;

public interface DepartmentService {

    List<Department> getAllDepartments();

    Department createDepartment(Department department);

    Department getDepartmentById(Integer id) throws Exception;
}
