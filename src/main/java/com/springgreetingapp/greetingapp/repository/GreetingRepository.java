package com.springgreetingapp.greetingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springgreetingapp.greetingapp.model.Greeting;
public interface GreetingRepository extends JpaRepository<Greeting, Long> {}

