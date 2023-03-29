package com.week5.homework.persistence.repository;

import com.week5.homework.persistence.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User,String>, CrudRepository<User,String> {
}
