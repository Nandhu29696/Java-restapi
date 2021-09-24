package com.example.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.PhonebookService;
import com.example.demo.model.Phonebook;

@RestController
@CrossOrigin
@RequestMapping

public class PhonebookController {

	@Autowired
	PhonebookService service;
	
	@PostMapping("/add")
	public Map<String, Object> saveData(@RequestBody Phonebook phonebook) {
		return service.savePhonebook(phonebook);
	}
	
	@GetMapping("/singledata/{id}")
	public Map<String, Object> singledate(@PathVariable String id){
		return service.findPhonebookId(id);
	}
	
	@PostMapping("/updatedata/{id}")
	public Map<String, Object> updatedata(@PathVariable String id, @RequestBody Phonebook phonebook){
		return service.updatePhonebook(phonebook, id);
	}
	
	@GetMapping("/data")
	public Map<String, Object> listdata(){
		return service.listPhonebook();
	}
	
	@GetMapping("/delete/{id}")
	public Map<String, Object> deletedata(@PathVariable String id){ 
		return service.deletedata(id);
	}
}

