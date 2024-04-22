package com.example.march;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {
	private final SearchService searchService;
	
	@Autowired
	public SearchController(SearchService searchService) {
		this.searchService = searchService;
	}
	
	@GetMapping("/byId")
	public String employeebyId(@RequestBody(required=false) int id) {
		return searchService.searchByEmployeeId(id);
	}
	
	@PostMapping("/addEmp")
	public ResponseEntity<String> addemployee(@RequestBody EmployeeVO empVO){
		searchService.saveEmp(empVO);		
		return ResponseEntity.status(HttpStatus.CREATED).body("Employee Added");
	}
	
	@DeleteMapping("/deleteEmp")
	public ResponseEntity<String> deleteEmployee(@RequestBody(required=false) int id){
		boolean delete = searchService.deleteEmp(id);
		if(delete) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Employee removed Successfully");
		}else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("SOmething went wrong");
		}
	}
	@PutMapping("/updateEmp/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody EmployeeVO empVO){
		boolean update = searchService.updateEmp(id, empVO);
		if(update) {
			return ResponseEntity.status(HttpStatus.FOUND).body("Emp Updated");
		}else {
			return ResponseEntity.status(HttpStatus.FOUND ).body("Emp Not Updated");
		}
				
	}
	@PostMapping("/fetchNewEmployee/{id}")
	public String fetchFromExternal(@PathVariable int id){
		searchService.fetchandsave(id);
		return "working";
	}

}
