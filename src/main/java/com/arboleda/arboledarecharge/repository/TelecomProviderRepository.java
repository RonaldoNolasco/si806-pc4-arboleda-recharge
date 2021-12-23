package com.arboleda.arboledarecharge.repository;

import com.arboleda.arboledarecharge.model.TelecomProvider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelecomProviderRepository extends JpaRepository<TelecomProvider, Long> {

    List<TelecomProvider> findByNameContaining(String name);
}
