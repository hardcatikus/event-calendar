package com.atomstroyrezerv.controller;

import com.atomstroyrezerv.exception.ResourceNotFoundException;
import com.atomstroyrezerv.model.Purpose;
import com.atomstroyrezerv.service.PurposeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class PurposeController {

    private final PurposeService purposeService;

    public PurposeController (PurposeService purposeService) {
        this.purposeService = purposeService;
    }

    @GetMapping("/purpose/all")
    public List<Purpose> getAllPurposes() {
        return  purposeService.findAll();
    }

    @GetMapping("/purpose/{id}")
    public ResponseEntity<Purpose> getPurposeById
            (@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(purposeService.getPurposeById(id));
    }

}
