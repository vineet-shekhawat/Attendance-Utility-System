package com.attendanceUtilitySystem.utility.models.profiles;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Component
@MappedSuperclass
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile implements Serializable {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private String user_id;

	@Column(name = "name")
	private String username;
	@Column(name =  "phone_no")
	private String phoneno;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(name = "passcode")
	private String password;

	@Column(name = "email")
	private String email;
	
}
