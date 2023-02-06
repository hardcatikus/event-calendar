package com.atomstroyrezerv.service;

import com.atomstroyrezerv.exception.ResourceNotFoundException;
import com.atomstroyrezerv.model.Purpose;
import com.atomstroyrezerv.repository.PurposeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurposeService {

    private final PurposeRepository purposeRepository;

    public PurposeService (PurposeRepository purposeRepository) {
        this.purposeRepository = purposeRepository;
    }

    public List<Purpose> findAll() {
        return purposeRepository.findAll();
    }

    public Purpose getPurposeById(Integer id) throws ResourceNotFoundException {
        Purpose purpose = purposeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Purpose was not found for id:" + id));
        return purpose;
    }

    public Purpose save(Purpose purpose){
        return purposeRepository.save(purpose);
    }

}
