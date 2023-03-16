package com.atomstroyrezerv.controller;

import com.atomstroyrezerv.exception.ResourceNotFoundException;
import com.atomstroyrezerv.model.Purpose;
import com.atomstroyrezerv.response.DeleteResponse;
import com.atomstroyrezerv.service.PurposeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/purpose/add")
    public Purpose createPurpose(@RequestBody Purpose purpose){
        return purposeService.save(purpose);
    }

    @DeleteMapping("/purpose/{id}")
    public ResponseEntity<DeleteResponse> deletePurposeById
            (@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        purposeService.deletePurpose(id);
        return ResponseEntity.ok(new DeleteResponse("Purpose with id:" + id + " was deleted"));
    }

}
