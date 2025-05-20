package com.concerno.repository;

import com.concerno.dto.ComplaintDTO;
import com.concerno.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    Optional<Complaint> findById(Long complainId);

    List<Complaint> findByDepartment(String department); // Correct method name for Spring Data JPA

    @Query("SELECT c FROM Complaint c WHERE c.status <> 'Resolved'")
    List<Complaint> findAllComplaintsNotResolvedYet(); // Corrected JPQL

    @Transactional
    @Modifying
    @Query("UPDATE Complaint c SET c.status = 'Resolved' WHERE c.complainId = :complainId")
    void setStatusAttributeToResolve(Long complainId); // Fixing wrong entity fields

    List<Complaint> findByLocation(String location); // No need for native query here
}
