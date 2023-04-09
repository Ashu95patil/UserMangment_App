package com.codewithashu.user.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.codewithAshu.blog.entity.Comment;
import com.codewithAshu.blog.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_details")
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "user_fname")
	private String firstName;

	@Column(name = "user_lname")
	private String lastName;

	@Column(name = "user_email")
	private String email;

	@Column(name = "user_password")
	private String password;

	@Column(name = "user_phno")
	private Long phno;

	@Column(name = "user_dob")
	private Date dob;

	@Column(name = "user_gender")
	private String gender;

	@Column(name = "user_country")
	private String country;

	@Column(name = "user_state")
	private String state;

	@Column(name = "user_city")
	private String city;

	@Column(name = "create_date", updatable = false)
	@CreationTimestamp
	private LocalDate createdate;

	@Column(name = "update_date", insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;

	@Column(name = "isactive_switch")
	private String isactive;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Department> departments;

}
