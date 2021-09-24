package com.example.demo.DaoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.demo.Dao.PhonebookDao;
import com.example.demo.model.Phonebook;

@Repository
public class PhonebookDaoImpl implements PhonebookDao {

	@Autowired
	MongoTemplate mongoTemplete;

	@Override
	public Phonebook save(Phonebook phonebook) {
		try {
			mongoTemplete.save(phonebook);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return phonebook;
	}

	@Override
	public Phonebook findbyId(String id) {
		Phonebook data = null;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(id));
			data = mongoTemplete.findOne(query, Phonebook.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public Phonebook editTable(String id, Phonebook phonebook) {

		Phonebook data = findbyId(id);

		data.setFirstName(phonebook.getFirstName());
		data.setLastName(phonebook.getLastName());
		data.setEmailID(phonebook.getEmailID());
		data.setPhoneNumber(phonebook.getPhoneNumber());

		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(id));

			Update update = new Update();
			update.set("FirstName", data.getFirstName());
			update.set("LastName", data.getLastName());
			update.set("EmailID", data.getEmailID());
			update.set("PhoneNumber", data.getPhoneNumber());

			data = mongoTemplete.findAndModify(query, update, Phonebook.class);

			Query query1 = new Query();
			query1.addCriteria(Criteria.where("_id").is(id));

			data = mongoTemplete.findOne(query1, Phonebook.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<Phonebook> phonebookList() {

		List<Phonebook> list = null;

		try {
			list = mongoTemplete.findAll(Phonebook.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void deletedata(String id) {
		try {

			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(id));
			mongoTemplete.findAndRemove(query, Phonebook.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
