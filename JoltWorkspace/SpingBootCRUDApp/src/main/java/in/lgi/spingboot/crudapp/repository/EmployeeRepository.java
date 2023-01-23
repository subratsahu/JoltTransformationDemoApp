package in.lgi.spingboot.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.lgi.spingboot.crudapp.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}