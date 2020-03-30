package com.JPA.practise.jpa1.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.JPA.practise.jpa1.JpaRepo.JpaRepo;
import com.JPA.practise.jpa1.bean.PersonBean;

@RestController
public class MyRestController {

	@Autowired
	JpaRepo repo;

	String testing = "/hello";

	@GetMapping("/hello")
	public String Test() {
		return "Hello";
	}

	@GetMapping("/findAll")
	public List<PersonBean> findAll() {
		List<PersonBean> myList = repo.findAll();
		return myList;
	}

	@GetMapping("/findById/{id}")
	public PersonBean findById(@PathVariable int id) {
		PersonBean person = repo.findById(id).orElse(new PersonBean());
		return person;
	}

	@GetMapping("/findByLocation/{location}")
	public List<PersonBean> findByLocation(@PathVariable String location) {
		List<PersonBean> myList = repo.findAllByLocation(location);
		return myList;
	}

	@GetMapping("/findByLocationSorted/{location}")
	public List<PersonBean> findByLocationSorted(@PathVariable String location) {
		List<PersonBean> myList = repo.findByLocationSorted(location);
		return myList;
	}

	@GetMapping("/findByName/{name}/{location}")
	public List<PersonBean> findByName(@PathVariable String name, @PathVariable String location) {
		List<PersonBean> myList = repo.findByName(name, location);
		return myList;
	}

	@PostMapping("/add")
	public String addPerson(@RequestBody PersonBean personBean) {
		repo.save(personBean);
		return personBean.getName() + " successfully added";
	}
	
	@DeleteMapping("/delete")
	public String deletePerson(@RequestBody PersonBean personBean) {
		repo.delete(personBean);
		return personBean.getName() + " successfully deleted";
	}

	@PutMapping("/update")
	public String updatePerson(@RequestBody PersonBean personBean) {
		if(repo.existsById(personBean.getId())==true) {
			repo.save(personBean);
		}
		else {
			return null;
		}
		
		return personBean.getName() + " successfully updated";
	}
}
