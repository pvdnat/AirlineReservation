package com.synergisticit.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
//import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
//@ToString //to avoid StackOverflowError
@Getter
@Setter
@Entity
@Table(name="role")
public class Role {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	public Long roleId;
	
	@NotEmpty
	private String roleName;
	
	@ManyToMany(mappedBy="roles")
	@JsonBackReference
	private List<User> users = new ArrayList<>();
	

}
