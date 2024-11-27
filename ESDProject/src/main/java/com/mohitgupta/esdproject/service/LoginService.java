package com.mohitgupta.esdproject.service;

import com.mohitgupta.esdproject.entity.Department;
import com.mohitgupta.esdproject.entity.Employee;
import com.mohitgupta.esdproject.entity.Login;
import com.mohitgupta.esdproject.dto.LoginMessage;
import com.mohitgupta.esdproject.repository.DepartmentRepository;
import com.mohitgupta.esdproject.repository.EmployeeRepository;
import com.mohitgupta.esdproject.repository.PlacementRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

//    @Autowired
    private EmployeeRepository employeeRepository;

    private DepartmentRepository departmentRepository;

    public LoginService(PlacementRepository placementRepository, EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }
    public LoginMessage loginEmployee(Login login) {
        Employee userFromRequest = employeeRepository.findByEmail(login.getEmail());
        if(userFromRequest!=null){
            String passwordFromRequest=login.getPassword();
            String passwordFromAdmin=userFromRequest.getPassword();
//            boolean isPwdRight=(passwordFromRequestpasswordFromAdmin);
            if(passwordFromRequest.equals(passwordFromAdmin)){
                Optional<Employee> emp= employeeRepository.findByEmailAndPassword(login.getEmail(),passwordFromAdmin);

                if(emp.isPresent()){
                    Long Id = emp.get().getDepartment().getDomainId();
                    Optional<Department> dept = departmentRepository.findById(Id);
                    if(dept.isPresent()){
                        if(dept.get().getName().equals("outreach")){
                            return new LoginMessage("Login Success",true);
                        }
                        else{
                            return new LoginMessage("Login failed You are not from out reach Department",false);
                        }
                    }
                    else{
                        return  new LoginMessage("Login Failed",false);
                    }

                }
                else{
                    return new LoginMessage("Login failed",false);
                }
            }
            else {
                return new LoginMessage("Password not match", false);
            }
        }
        else{
            return new LoginMessage("Email not exits",false);
        }
    }
    public void saveUser(Employee userData) {
//        String encodedPassword=this.passwordEncoder.encode(userData.getPassword());
//        userData.setPassword((encodedPassword));
        employeeRepository.save(userData);
    }
}
