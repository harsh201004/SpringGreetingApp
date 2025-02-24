package com.springgreetingapp.greetingapp.service;

import com.springgreetingapp.greetingapp.model.Greeting;
import com.springgreetingapp.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class GreetingService {
    public String getGreetingMessage() {
        return "Hello World";
    }

    public String getPersonalizedGreeting(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName;
        } else if (firstName != null) {
            return "Hello, " + firstName;
        } else if (lastName != null) {
            return "Hello, " + lastName;
        } else {
            return "Hello World";
        }
    }

    @Autowired
    private GreetingRepository repository;

    public Greeting saveGreeting(Greeting greeting) {
        return repository.save(greeting);
    }

    public Optional<Greeting> getGreetingById(Long id) {
        return repository.findById(id);
    }

    public List<Greeting> getAllGreetings() {
        return repository.findAll();
    }

    public Greeting updateGreeting(Long id, String message) {
        return repository.findById(id).map(greeting -> {
            greeting.setMessage(message);
            return repository.save(greeting);
        }).orElse(null);
    }

    public void deleteGreeting(Long id) {
        repository.deleteById(id);
    }
}
