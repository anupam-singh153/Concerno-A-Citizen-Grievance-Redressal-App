package com.concerno.service.impl;

import com.concerno.dto.ComplaintDTO;
import com.concerno.dto.Response;
import com.concerno.entity.Complaint;
import com.concerno.exception.OurException;
import com.concerno.repository.ComplaintRepository;
import com.concerno.repository.UserRepository;
import com.concerno.service.interfac.IComplaintService;
import com.concerno.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintService implements IComplaintService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ComplaintRepository complaintRepository;

    @Override
    public Response addNewComplaint(ComplaintDTO complainDto) {
        Response response = new Response();

        try {
            Complaint complaint = new Complaint();

            complaint.setDepartment(complainDto.getDepartment());
            complaint.setLocation(complainDto.getLocation());
            complaint.setDescription(complainDto.getDescription());
            complaint.setStatus(complainDto.getStatus());
            complaint.setConcernedCitizen(complainDto.getConcernedCitizen());
            complaint.setDateOfIncident(complainDto.getDateOfIncident());
            complaint.setMobileNumber(complainDto.getMobileNumber());

            Complaint savedComplaint = complaintRepository.save(complaint);

            response.setStatusCode(200);

            ComplaintDTO complaintDTO = Utils.mapComplaintEntityToComplaintDTO(savedComplaint);

            response.setMessage("successful");
            response.setComplaintDTO(complaintDTO);

        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error saving a complain " + e.getMessage());
        }
        return response;
    }

    @Override
    public Response getAllComplaints() {
        Response response = new Response();

        try {
            List<Complaint> complaintList = complaintRepository.findAll(Sort.by(Sort.Direction.DESC, "complainId"));
            List<ComplaintDTO> complaintDTOList = Utils.mapComplaintListEntityToComplaintListDTO(complaintList);
            response.setStatusCode(200);
            response.setMessage("successful");
            response.setComplaintList(complaintDTOList);
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error While Fetching Complaints from database " + e.getMessage());
        }
        return response;
    }

    @Override
    public Response deleteComplaint(Long complainId) {
        Response response = new Response();

        try {
            complaintRepository.findById(complainId).orElseThrow(() -> new OurException("Complaint Not Found"));
            complaintRepository.deleteById(complainId);
            response.setStatusCode(200);
            response.setMessage("successful");

        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error while deleting a Complaint " + e.getMessage());
        }
        return response;
    }

    @Override
    public Response getComplaintById(Long complainId) {
        Response response = new Response();

        try {
            Complaint complaint = complaintRepository.findById(complainId).orElseThrow(() -> new OurException("Complaint Not Found"));
            ComplaintDTO complaintDTO = Utils.mapComplaintEntityToComplaintDTO(complaint);
            response.setStatusCode(200);

            response.setMessage("successful");
            response.setComplaintDTO(complaintDTO);

        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error while Fetching a Complaint " + e.getMessage());
        }
        return response;
    }

    @Override
    public Response getAllComplaintsConcernedToArea(String area) {
        Response response = new Response();

        try {
            List<Complaint> complaintList = complaintRepository.findByLocation(area);
            List<ComplaintDTO> complaintDTOList = Utils.mapComplaintListEntityToComplaintListDTO(complaintList);
            response.setStatusCode(200);
            response.setMessage("successful");
            response.setComplaintList(complaintDTOList);

        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error While Fetching all complaints concerned to an Area" + e.getMessage());
        }
        return response;
    }

    @Override
    public Response setStatusAttributeToResolve(Long complainId) {
        Response response = new Response();

        try {
            complaintRepository.setStatusAttributeToResolve(complainId);

            response.setStatusCode(200);
            response.setMessage("successful");

        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error While updating status" + e.getMessage());
        }
        return response;
    }

    @Override
    public Response getAllComplaintsConcernedToDept(String dept) {
        Response response = new Response();

        try {
            List<Complaint> complaintList = complaintRepository.findByDepartment(dept);
            List<ComplaintDTO> complaintDTOList = Utils.mapComplaintListEntityToComplaintListDTO(complaintList);
            response.setStatusCode(200);
            response.setMessage("successful");
            response.setComplaintList(complaintDTOList);

        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error While Fetching all complaints concerned to a dept" + e.getMessage());
        }
        return response;
    }

    @Override
    public Response findAllComplaintsNotResolvedYet() {
        Response response = new Response();

        try {
            List<Complaint> complaintList = complaintRepository.findAllComplaintsNotResolvedYet();

            response.setOrigComplaintList(complaintList);
            response.setStatusCode(200);
            response.setMessage("successful");

        } catch (OurException e) {
            response.setStatusCode(404);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setMessage("Error While fetching not resolved complaints" + e.getMessage());
        }
        return response;
    }
}
