package com.example.demo.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Bme280;

@Repository
public interface Bme280Repository extends JpaRepository<Bme280, LocalDate>{

}
