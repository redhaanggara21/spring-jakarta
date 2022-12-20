package com.basicspring.springbootscratch.controller;
import com.basicspring.springbootscratch.exception.ResourceNotFoundException;
import com.basicspring.springbootscratch.model.Snack;
import com.basicspring.springbootscratch.repository.SnackRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/v1")
public class SnackController {

    @Autowired
    private SnackRepository snackRepository;

    @GetMapping("/snack")
    public List<Snack> getAll() {
        return snackRepository.findAll();
    }

    @GetMapping("/snack/{id}")
    public ResponseEntity<Snack> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Snack employee = snackRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("snack not found for this id :: " + id));
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/snack")
    public Snack create(@Valid @RequestBody Snack snack) {
        return snackRepository.save(snack);
    }

    @PutMapping("/snack/{id}")
    public ResponseEntity<Snack> update(
            @PathVariable(value = "id") Long id,
            @Valid @RequestBody Snack snack
    ) throws ResourceNotFoundException {
        Snack snacks = snackRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("snack not found for this id :: " + id));
        snacks.setName(snack.getName());
        snacks.setIdCategory(snack.getIdCategory());
        snacks.setStock(snack.getStock());
        snacks.setIdSupplier(snack.getIdSupplier());
        snacks.setPrice(snack.getPrice());
        snacks.setUpdatedAt(new Date());
        final Snack updatedSnack = snackRepository.save(snack);
        return ResponseEntity.ok(updatedSnack);
    }

    @DeleteMapping("/snack/{id}")
    public Map<String, Boolean> deleteE(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Snack snack = snackRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Snack not found for this id :: " + id));
        snackRepository.delete(snack);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
