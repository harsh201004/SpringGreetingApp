package com.springgreetingapp.greetingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.springgreetingapp.greetingapp.service.GreetingService;
import com.springgreetingapp.greetingapp.model.Greeting;
import java.util.*;
@RestController
@RequestMapping("/greetings")
public class GreetingController {

    //Work for UC1

    // GET request - returns a greeting message
    @GetMapping("/hello")
    public String getGreeting() {
        return "{\"message\": \"Hello, World!\"}";
    }

    // POST request - accepts a name and returns a personalized greeting
    @PostMapping("/hello")
    public String createGreeting(@RequestParam String name) {
        return "{\"message\": \"Hello, " + name + "!\"}";
    }

    // PUT request - updates a greeting message (simulated)
    @PutMapping("/hello")
    public String updateGreeting(@RequestParam String newMessage) {
        return "{\"message\": \"Updated greeting: " + newMessage + "\"}";
    }

    // DELETE request - deletes a greeting message (simulated)
    @DeleteMapping("/hello")
    public String deleteGreeting() {
        return "{\"message\": \"Greeting deleted successfully!\"}";
    }

    //Work for UC2

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/message")
    public String getGreeting1() {
        return "{\"message\": \"" + greetingService.getGreetingMessage() + "\"}";
    }

    //Work for UC3
    @GetMapping("/personalized")
    public String getPersonalizedGreeting(@RequestParam(required = false) String firstName,
                                          @RequestParam(required = false) String lastName) {
        return "{\"message\": \"" + greetingService.getPersonalizedGreeting(firstName, lastName) + "\"}";
    }

    //Work for UC4
    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody Greeting greeting) {
        return greetingService.saveGreeting(greeting);
    }

    //Work for UC5
    @GetMapping("/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }

    //Work for UC6
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    //Work with UC7
    @PutMapping("/update/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestParam String message) {
        return greetingService.updateGreeting(id, message);
    }

    //Work for UC8
    @DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return "Greeting deleted successfully!";
    }
}
