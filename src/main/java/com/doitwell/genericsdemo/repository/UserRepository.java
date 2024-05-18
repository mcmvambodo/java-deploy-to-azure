package com.doitwell.genericsdemo.repository;

import com.doitwell.genericsdemo.model.Admin;
import com.doitwell.genericsdemo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Admin,Long> {
}
