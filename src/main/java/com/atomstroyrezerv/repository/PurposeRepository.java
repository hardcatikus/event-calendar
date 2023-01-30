package com.atomstroyrezerv.repository;

import com.atomstroyrezerv.model.Purpose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurposeRepository extends JpaRepository<Purpose, Integer> {
}
