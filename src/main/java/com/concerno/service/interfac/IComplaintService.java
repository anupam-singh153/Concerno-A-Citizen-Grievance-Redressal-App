package com.concerno.service.interfac;

import com.concerno.dto.ComplaintDTO;
import com.concerno.dto.Response;

public interface IComplaintService {

    Response addNewComplaint(ComplaintDTO complain);

    Response getAllComplaints();

    Response deleteComplaint(Long complainId);

    Response getComplaintById(Long complainId);

    Response getAllComplaintsConcernedToArea(String area);

    Response setStatusAttributeToResolve(Long complainId);

    Response getAllComplaintsConcernedToDept(String dept);

    Response findAllComplaintsNotResolvedYet();
}
