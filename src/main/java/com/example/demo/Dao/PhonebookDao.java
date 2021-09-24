package com.example.demo.Dao;

import java.util.List;

import com.example.demo.model.Phonebook;

public interface PhonebookDao {

	Phonebook save(Phonebook phonebook);
	
	Phonebook findbyId(String id);
	
	List<Phonebook> phonebookList();
	
	Phonebook editTable(String id, Phonebook phonebook);
	
	void deletedata(String id);
}
