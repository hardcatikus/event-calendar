package com.atomstroyrezerv.service;

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

}
