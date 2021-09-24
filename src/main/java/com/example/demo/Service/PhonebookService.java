package com.example.demo.Service;

import java.util.Map;

import com.example.demo.model.Phonebook;

public interface PhonebookService {

	Map<String, Object> savePhonebook(Phonebook phonebook);
	
	Map<String, Object> findPhonebookId(String id);
	
	Map<String, Object> updatePhonebook(Phonebook phonebook, String id);
	
	Map<String, Object> listPhonebook();
	
	Map<String, Object> deletedata(String id);
}
