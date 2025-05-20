package com.concerno.controller;

import com.concerno.dto.ComplaintDTO;
import com.concerno.dto.Response;
import com.concerno.service.interfac.IComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private IComplaintService complaintService;

    @PostMapping("/add")
    public ResponseEntity<Response> addNewComplaint(
           @RequestBody ComplaintDTO complain
    ) {

        if (complain == null) {
            Response response = new Response();
            response.setStatusCode(400);
            response.setMessage("Please provide a valid complaint");
            return ResponseEntity.status(response.getStatusCode()).body(response);
        }

        Response response = complaintService.addNewComplaint(complain);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<Response> getAllComplaints() {
        Response response = complaintService.getAllComplaints();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/complaint-by-id/{complaintId}")
    public ResponseEntity<Response> getComplaintById(@PathVariable Long complaintId) {
        Response response = complaintService.getComplaintById(complaintId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @DeleteMapping("/delete/{complaintId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response> deleteComplaint(@PathVariable Long complaintId) {
        Response response = complaintService.deleteComplaint(complaintId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/complaints-assigned-to-area/{area}")
    public ResponseEntity<Response> getAllComplaintsConcernedToArea(@PathVariable String area){

        Response response = complaintService.getAllComplaintsConcernedToArea(area);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }


    @PutMapping("/set-complaint-status-resolve/{complaintId}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Response> setStatusAttributeToResolve(@PathVariable Long complaintId){

        Response response = complaintService.setStatusAttributeToResolve(complaintId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/complaints-not-resolved")
    public ResponseEntity<Response> findAllComplaintsNotResolvedYet() {
        Response response = complaintService.findAllComplaintsNotResolvedYet();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/complaints-assigned-to-dept/{dept}")
    public ResponseEntity<Response> getAllComplaintsConcernedToDept(@PathVariable String dept) {
        Response response = complaintService.getAllComplaintsConcernedToDept(dept);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
