package com.arboleda.arboledarecharge.repository;

import com.arboleda.arboledarecharge.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
