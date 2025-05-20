# Concerno: A Citizen Grievance Redressal App

**Concerno** is a public grievance redressal system designed to simplify and streamline how citizens report issues to their local government. Built using Spring Boot, the application allows citizens to raise complaints without any login while offering a secure admin panel to manage those complaints effectively.

---

## ✅ Key Features

* **No login required for Citizens**: Anyone can file a complaint quickly.
* **Secure Admin Portal**: Admins can view, filter, update, and delete complaints securely.
* **Filter and Sort**: View complaints by status (Pending, Resolved), department, or location.
* **Complaint Tracking**: Each complaint has a unique auto-generated ID and can be tracked easily.

---

## 🧱 Tech Stack

* **Java 17**
* **Spring Boot 3.x**
* **Spring Security** (for admin authentication)
* **Spring Data JPA**
* **H2/MySQL** (Database)
* **Maven** (Build tool)

---

## 🗂️ Complaint Fields

Each complaint includes the following attributes:

* `complaintId`: Auto-generated unique ID
* `description`: Description of the issue
* `status`: Current status (Pending / Resolved / Postponed)
* `department`: Department responsible for resolving it
* `dateOfIncident`: When the issue occurred
* `concernedCitizen`: Name of the complainant
* `mobileNumber`: Contact for further communication
* `location`: Geographical location or area

---

## 🔒 Security

* Admin access is protected using Spring Security.
* Only admins can:

  * Update complaint status
  * Delete complaints
  * Filter and view complaint statistics

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/concerno.git
cd concerno
```

### 2. Build the Project

```bash
mvn clean install
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

### 4. Access Endpoints

* File Complaint: `POST /api/complaints`
* View All: `GET /api/public/complaints`
* Admin Login: `POST /api/admin/login`
* Update Status: `PUT /api/admin/complaints/{id}/status`
* Delete Complaint: `DELETE /api/admin/complaints/{id}`

---

## 📊 Future Enhancements

* PDF summary generation
* Email/SMS notifications for complaints
* Department-wise dashboard analytics
* Mobile app integration

---

## 📘 License

This project is licensed under the MIT License.

---

## 👤 Author

Built with 💡 by \[Anupam Singh Chandravanshi] - Java Developer | Spring Boot Enthusiast
