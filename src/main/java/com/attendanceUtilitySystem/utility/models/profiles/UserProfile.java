package com.attendanceUtilitySystem.utility.models.profiles;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@MappedSuperclass
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Long user_id;
	
	@Column(name = "name")
	private String username;
	@Column(name =  "phone_no")
	private String phoneno;
	@Column(name = "passcode")
	private String password;
	@Column(name = "email")
	private String email;
	
}
