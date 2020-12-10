package com.lundstad.employees.service;

import com.lundstad.employees.db.tables.tables.daos.EmployeeDao;
import com.lundstad.employees.db.tables.tables.pojos.Employee;
import com.lundstad.employees.db.tables.tables.records.EmployeeRecord;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

import static com.lundstad.employees.db.tables.tables.Employee.EMPLOYEE;
import static com.lundstad.employees.db.tables.tables.EmployeeAddress.EMPLOYEE_ADDRESS;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao employeeDao;

    @Autowired
    private final DSLContext dsl;
    private final TransactionTemplate transactionTemplate;
    private com.lundstad.employees.db.tables.tables.Employee employee;


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
    public Employee createEmployee(com.lundstad.employees.model.Employee modelEmployee) {
        EmployeeRecord rc = dsl.insertInto(EMPLOYEE)
                .set(EMPLOYEE.FIRSTNAME, modelEmployee.getFirstname())
                .set(EMPLOYEE.LASTNAME, modelEmployee.getLastname())
                .set(EMPLOYEE.EMAIL, modelEmployee.getEmail())
                .returning()
                .fetchOne();


//Denne virker setter permanent inn i db
//        EmployeeRecord record = dsl.newRecord(EMPLOYEE);
//        record.setFirstname(modelEmployee.getFirstname());
//        record.setLastname((modelEmployee.getLastname()));
//        record.setEmail(modelEmployee.getEmail());
//        record.insert();

//Denne virker også setter inn i db permanent
//        int record = dsl.insertInto(Tables.EMPLOYEE,Tables.EMPLOYEE.FIRSTNAME, EMPLOYEE.LASTNAME, EMPLOYEE.EMAIL)
//                .values(modelEmployee.getFirstname(), modelEmployee.getLastname(), modelEmployee.getEmail())
//                .returning(Tables.EMPLOYEE.FIRSTNAME)
//                .execute();
//
//Denne virker, men i dette tilfellet returnerer heller resultat fra record
//        Result<Record> result = dsl.select()
//                 .from(EMPLOYEE)
//                 .where(Tables.EMPLOYEE.FIRSTNAME.eq(modelEmployee.getFirstname()))
//                 .fetch();
         return rc.into(Employee.class);

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
