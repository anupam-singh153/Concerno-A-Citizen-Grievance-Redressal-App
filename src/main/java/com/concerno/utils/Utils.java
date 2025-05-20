package com.concerno.utils;

import com.concerno.dto.ComplaintDTO;
import com.concerno.dto.UserDTO;
import com.concerno.entity.Complaint;
import com.concerno.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    // Map User Entity to UserDTO
    public static UserDTO mapUserEntityToUserDTO(User user) {
        if (user == null) return null; // Null check for safety

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setEmail(user.getEmail()); // Fixed incorrect mapping
        userDTO.setRole(user.getRole()); // Fixed incorrect mapping
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }

    // Map Complaint Entity to ComplaintDTO
    public static ComplaintDTO mapComplaintEntityToComplaintDTO(Complaint complaint) {
        if (complaint == null) return null; // Null check for safety

        ComplaintDTO complaintDTO = new ComplaintDTO();

        complaintDTO.setComplainId(complaint.getComplainId());
        complaintDTO.setDepartment(complaint.getDepartment());
        complaintDTO.setLocation(complaint.getLocation());
        complaintDTO.setDescription(complaint.getDescription());
        complaintDTO.setMobileNumber(complaint.getMobileNumber());
        complaintDTO.setConcernedCitizen(complaint.getConcernedCitizen());
        complaintDTO.setStatus(complaint.getStatus());

        return complaintDTO;
    }

    // Map List of User Entities to List of UserDTOs
    public static List<UserDTO> mapUserListEntityToUserListDTO(List<User> userList) {
        if (userList == null || userList.isEmpty()) return List.of(); // Handle null or empty lists
        return userList.stream()
                .map(Utils::mapUserEntityToUserDTO)
                .collect(Collectors.toList());
    }

    // Map List of Complaint Entities to List of ComplaintDTOs
    public static List<ComplaintDTO> mapComplaintListEntityToComplaintListDTO(List<Complaint> complaintList) {
        if (complaintList == null || complaintList.isEmpty()) return List.of(); // Handle null or empty lists
        return complaintList.stream()
                .map(Utils::mapComplaintEntityToComplaintDTO)
                .collect(Collectors.toList());
    }
}
