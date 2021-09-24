package com.example.demo.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.PhonebookDao;
import com.example.demo.Service.PhonebookService;
import com.example.demo.model.Phonebook;

@Service
public class PhonebookServiceImpl implements PhonebookService {

	@Autowired
	PhonebookDao familyDao;

	@Override
	public Map<String, Object> savePhonebook(Phonebook phonebook) {

		Map<String, Object> result = new HashMap<>();

		Phonebook data = familyDao.save(phonebook);

		result.put("message", "data saved");
		result.put("data", data);

		return result;
	}

	@Override
	public Map<String, Object> updatePhonebook(Phonebook phonebook, String id) {

		Map<String, Object> result = new HashMap<>();

		Phonebook update = familyDao.editTable(id, phonebook);

		result.put("message", "updated");
		result.put("updatedData", update);

		return result;
	}

	@Override
	public Map<String, Object> findPhonebookId(String id) {

		Map<String, Object> result = new HashMap<>();

		Phonebook singlemember = familyDao.findbyId(id);

		result.put("message", "updated");
		result.put("singlemember data", singlemember);

		return result;
	}

	@Override
	public Map<String, Object> listPhonebook() {
		Map<String, Object> result = new HashMap<>();

		List<Phonebook> list = familyDao.phonebookList();

		result.put("message", "list family");
		result.put("listData", list);
		return result;
	}

	@Override
	public Map<String, Object> deletedata(String id) {
		Map<String, Object> result = new HashMap<>();
		familyDao.deletedata(id);
		result.put("message", "deleted");
		return result;
	}

}
