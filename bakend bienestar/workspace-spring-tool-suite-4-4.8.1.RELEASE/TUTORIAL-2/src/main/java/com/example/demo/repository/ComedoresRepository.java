package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Comedores;

@Repository
public interface ComedoresRepository  extends JpaRepository<Comedores, Long> {

}
