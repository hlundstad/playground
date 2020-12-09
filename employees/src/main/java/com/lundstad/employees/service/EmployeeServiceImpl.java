package com.lundstad.employees.service;

import com.lundstad.employees.db.tables.tables.daos.EmployeeDao;
import com.lundstad.employees.db.tables.tables.pojos.Employee;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

import static com.lundstad.employees.db.tables.tables.Employee.EMPLOYEE;
import static com.lundstad.employees.db.tables.tables.EmployeeAddress.EMPLOYEE_ADDRESS;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao employeeDao;

//    @Autowired
    private final DSLContext dsl;
    private final TransactionTemplate transactionTemplate;


    public EmployeeServiceImpl(DSLContext dsl, Configuration jooqConfiguration,
                               TransactionTemplate transactionTemplate) {
        this.employeeDao = new EmployeeDao(jooqConfiguration);
        this.dsl = dsl;
        this.transactionTemplate = transactionTemplate;
    }

    public List<Employee> getEmployees(){
        return this.employeeDao.findAll();
    }



    public void insertBook(Employee employee){
//        context
//                .insertInto(Tables.EMPLOYEES, Tables.EMPLOYEE.FIRSTNAME, Tables.EMPLOYEE.LASTNAME,
//                        Tables.EMPLOYEE.EMAIL)
//                .values(employee.getFirstName(), employee.getLastName(),employee.getEmail())
//                .execute();
    }

    @Override
    @Transactional
    public Employee createEmployee(Employee newEmployee) {
        this.employeeDao.insert(newEmployee);
        System.out.println(newEmployee.getId());
        return newEmployee;

    }

    @Override
    public Employee updateEmployee(int id, Employee employee) {
        this.employeeDao.update(employee);
        return employee;

    }

    @Override
    public void deleteEmployee(int id) {
        this.employeeDao.deleteById(id);
    }
//
//    @Override
//    public Collection<Employee> getEmployees() {
//        return null;
//    }

    @Override
    public Employee getEmployee(int id) {
        return this.employeeDao.findById(id);
    }

    @Override
    public Result<?>  getEmployeesAndAdresses() {
        Result<?> result =dsl.select()
                .from(EMPLOYEE.join(EMPLOYEE_ADDRESS)
                        .on(EMPLOYEE.ID.eq(EMPLOYEE_ADDRESS.ID)))
                .fetch();

        return result;
    }
}
