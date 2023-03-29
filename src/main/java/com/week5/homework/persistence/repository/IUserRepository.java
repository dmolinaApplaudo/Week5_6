package com.week5.homework.persistence.repository;

import com.week5.homework.persistence.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepository extends PagingAndSortingRepository<User,Long>, CrudRepository<User,Long> {
}
