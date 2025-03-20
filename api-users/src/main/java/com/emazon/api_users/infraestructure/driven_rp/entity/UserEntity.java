package com.emazon.api_users.infraestructure.driven_rp.entity;

import java.util.Date;

import com.emazon.api_users.domain.model.RoleEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity  {


     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "namee", nullable = false, unique = true)
    private String name;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "document",nullable=false)
    private String idDocument;
    @Column(name = "cel",nullable=false)
    private String celular;
    @Column(name = "date_of_birth",nullable=false)
    private Date dateOfBirth;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "passwordd", nullable = false)
    private String password;
    @Column (name="rol", nullable =false)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
   

 
  
    
}
