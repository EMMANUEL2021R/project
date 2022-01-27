package com.efunzo.services.epellation.model.response;

	import com.efunzo.services.epellation.domaine.Role;

public class EpellationUserResponse {
	
		private Long id;
		
		private String lastName;
		
		private String firstName;
		
		private String userName;
		
		private String password;
		
		private String email;
		
		private String phoneNumber;
		
		private Role role;
		
		private Integer schoolLevel;
		
		public EpellationUserResponse() {
	
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

		public Integer getSchoolLevel() {
			return schoolLevel;
		}

		public void setSchoolLevel(Integer schoolLevel) {
			this.schoolLevel = schoolLevel;
		}

		@Override
		public String toString() {
			return "EpellationUserResponse [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName
					+ ", userName=" + userName + ", password=" + password + ", email=" + email + ", phoneNumber="
					+ phoneNumber + ", role=" + role + ", schoolLevel=" + schoolLevel + "]";
		}



	}



