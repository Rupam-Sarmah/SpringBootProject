package com.example.march;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class SearchService {
	
	private final EmployeeRepo empRepo;
	private final RestTemplate restTemplate;
	
	@Autowired
	public SearchService(EmployeeRepo empRepo, RestTemplate restTemplate) {
		this.empRepo=empRepo;
		this.restTemplate = restTemplate;
	}
	
	public String searchByEmployeeId(int id) {
		Optional<Employee> emp= empRepo.findById(id);
		StringBuilder sb = new StringBuilder();
		if(emp.isPresent()) {
			
			Employee em = emp.get();
			sb.append("Name ").append(em.getName()).append(" and Department Id Is: ").append(em.getDepartmentid());
			//int id=em.get
			
		}else {
			sb.append("Not Found");
		}
		return sb.toString();
	}
	
	public void saveEmp(EmployeeVO empVo) {
		Employee emp = new Employee();
		emp.setName(empVo.getName());
		emp.setDepartmentid(empVo.getDepartmentid());
		empRepo.save(emp);
	}
	public boolean deleteEmp(int id) {
		if(empRepo.existsById(id)) {
			empRepo.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	public boolean updateEmp(int id, EmployeeVO empVo) {
		if(empRepo.existsById(id)) {
			Employee emp = empRepo.findById(id).orElse(null);
			if(emp == null) {
				emp.setName(empVo.getName());
				emp.setDepartmentid(empVo.getDepartmentid());
				empRepo.save(emp);
				return true;
			}
		}
		return false;
	}
	public void fetchandsave(int id) {
		String apiUrl = "https://jsonplaceholder.typicode.com/users/1";
		 EmployeeDTO employeeDTO = restTemplate.getForObject(apiUrl, EmployeeDTO.class);
		 String name = employeeDTO.getName();
		 int empId =employeeDTO.getId();
		 System.out.println("Name for "+id+ " is :"+name+" and departId: "+empId);
	}

}
