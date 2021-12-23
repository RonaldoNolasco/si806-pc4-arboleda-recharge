package com.arboleda.arboledarecharge.repository;

import com.arboleda.arboledarecharge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
