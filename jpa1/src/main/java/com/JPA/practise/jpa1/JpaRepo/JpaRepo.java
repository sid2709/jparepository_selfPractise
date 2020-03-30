package com.JPA.practise.jpa1.JpaRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.JPA.practise.jpa1.bean.PersonBean;

public interface JpaRepo extends JpaRepository<PersonBean, Integer> {

	List<PersonBean> findAllByLocation(String location);

	@Query("from PersonBean where location=?1 order by name")
	List<PersonBean> findByLocationSorted(String location);

	@Query("from PersonBean where name=?1 and location=?2")
	List<PersonBean> findByName(String name, String location);

}
