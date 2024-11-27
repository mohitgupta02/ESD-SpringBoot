package com.mohitgupta.esdproject.service;

import com.mohitgupta.esdproject.entity.Department;
import com.mohitgupta.esdproject.entity.Employee;
import com.mohitgupta.esdproject.entity.Login;
import com.mohitgupta.esdproject.dto.LoginMessage;
import com.mohitgupta.esdproject.helper.JWTHelper;
import com.mohitgupta.esdproject.repository.DepartmentRepository;
import com.mohitgupta.esdproject.repository.EmployeeRepository;
import com.mohitgupta.esdproject.repository.PlacementRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    @Autowired
    private JWTHelper jwtHelper;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public LoginService(PlacementRepository placementRepository, EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }
    public LoginMessage loginEmployee(Login login) {
        Employee userFromRequest = employeeRepository.findByEmail(login.getEmail());
        if(userFromRequest!=null){
            String passwordFromRequest=login.getPassword();
            String passwordFromAdmin=userFromRequest.getPassword();
            if(passwordFromRequest.equals(passwordFromAdmin)){
                Optional<Employee> emp= employeeRepository.findByEmailAndPassword(login.getEmail(),passwordFromAdmin);

                if(emp.isPresent()){
                    Long Id = emp.get().getDepartment().getDomainId();
                    Optional<Department> dept = departmentRepository.findById(Id);
                    if(dept.isPresent()){
                        if(dept.get().getName().equals("outreach")){
                            String token = jwtHelper.generateToken(login.getEmail());
                            return new LoginMessage(token,true);
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

}
