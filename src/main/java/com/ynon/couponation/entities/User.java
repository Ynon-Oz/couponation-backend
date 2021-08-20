package com.ynon.couponation.entities;




import javax.persistence.*;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ynon.couponation.enums.UserType;
import lombok.*;
import org.springframework.validation.annotation.Validated;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
@Table(name="users")
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private long id;

	@Email
	@Column( unique = true, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;
	@JsonIgnore
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "companyID")
	private Company companyId;

	@Enumerated(EnumType.STRING)
	@Column (name = "TYPE", nullable = false)
	private UserType type;

	private boolean isActivated;



//	public User(String userName, String password, Company company, UserType type, boolean isActivated) {
//		this.userName = userName;
//		this.password = password;
//		this.company = company;
//		this.type = type;
//		this.isActivated=isActivated;
//	}



}
