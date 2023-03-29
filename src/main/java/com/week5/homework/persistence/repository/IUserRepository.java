package com.week5.homework.persistence.repository;

import com.week5.homework.persistence.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<Users,String>, CrudRepository<Users,String> {
}
