package com.synergisticit.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
//@ToString
@Getter
@Setter
@Entity
@Table(name="user")
public class User {
	
	@Id
	@NotNull
     public Long userId;
     
	 @NotEmpty
	 @Column(name="name")
     String username;
     
	 @NotEmpty
     String password;
     
	 @Email
	 @NotEmpty
     String email;
     
	 private String mobileNo;
	 
     @ManyToMany(fetch=FetchType.EAGER)
     @JoinTable(
    	name="user_role",
        joinColumns = { @JoinColumn(name="user_id")},
        inverseJoinColumns = {@JoinColumn(name="role_id")}
    		 
    		 )
     @JsonBackReference
     List<Role> roles = new ArrayList<>();
        
}
