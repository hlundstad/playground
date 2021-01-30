package com.lundstad.employees.service;

import com.lundstad.employees.db.tables.tables.daos.EmployeeDao;
import com.lundstad.employees.db.tables.tables.pojos.Employee;
import com.lundstad.employees.db.tables.tables.pojos.EmployeeAddress;
import com.lundstad.employees.db.tables.tables.records.EmployeeRecord;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Map;

import static com.lundstad.employees.db.tables.tables.Employee.EMPLOYEE;
import static com.lundstad.employees.db.tables.tables.EmployeeAddress.EMPLOYEE_ADDRESS;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao employeeDao;

//    @Autowired
    private final DSLContext dsl;
    final TransactionTemplate transactionTemplate;
    com.lundstad.employees.db.tables.tables.Employee employee;

//    @Autowired
    public EmployeeServiceImpl(DSLContext dsl, Configuration jooqConfiguration,
                               TransactionTemplate transactionTemplate) {
        this.employeeDao = new EmployeeDao(jooqConfiguration);
        this.dsl = dsl;
        this.transactionTemplate = transactionTemplate;
    }

    public List<Employee> getEmployees(){
        return this.employeeDao.findAll();
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
    public Employee updateEmployee(Employee updateEmployee) {
//        Fungerer, men oppdaterer hele raden
//        this.employeeDao.update(employee);

//        Virker
//        EmployeeRecord rc = dsl.update(EMPLOYEE)
//                .set(EMPLOYEE.FIRSTNAME, employee.getFirstname())
//                .set(EMPLOYEE.LASTNAME, employee.getLastname())
//                .set(EMPLOYEE.EMAIL, employee.getEmail())
//                .returning()
//                .fetchOne();

        Employee originalEmployee = employeeDao.findById(updateEmployee.getId());

        if ( updateEmployee.getFirstname()!=null)
            originalEmployee.setFirstname(updateEmployee.getFirstname());
        if ( updateEmployee.getLastname()!=null)
            originalEmployee.setLastname(updateEmployee.getLastname());
        if ( updateEmployee.getEmail()!=null)
            originalEmployee.setEmail(updateEmployee.getEmail());

        this.employeeDao.update(originalEmployee);
        return employeeDao.findById(originalEmployee.getId());

    }

    @Override
    public void deleteEmployee(int id) {
        this.employeeDao.deleteById(id);
    }


    @Override
    public Employee getEmployee(int id) {
        return this.employeeDao.findById(id);
    }

    @Override
    public Map<Employee, List<EmployeeAddress>> getEmployeesAndAdresses() {
        return dsl.select()
                .from(EMPLOYEE.join(EMPLOYEE_ADDRESS)
                        .on(EMPLOYEE.ID.eq(EMPLOYEE_ADDRESS.EMPLOYEE_ID)))
                .fetchGroups(
                        r -> r.into(EMPLOYEE).into(Employee.class),
                        r -> r.into(EMPLOYEE_ADDRESS).into(EmployeeAddress.class)
                );
    }

    @Override
    public Map<Employee, List<EmployeeAddress>> getEmployeesAndAdresses(Integer id) {
        return dsl.select()
                .from(EMPLOYEE.join(EMPLOYEE_ADDRESS)
                        .on(EMPLOYEE.ID.eq(EMPLOYEE_ADDRESS.EMPLOYEE_ID)))
                .where(EMPLOYEE.ID.eq(id))
                .fetchGroups(
                        r -> r.into(EMPLOYEE).into(Employee.class),
                        r -> r.into(EMPLOYEE_ADDRESS).into(EmployeeAddress.class)
                        );

    }

    //============For enkel testing av Parameteriserte tester  ==================
    public   boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }






}
