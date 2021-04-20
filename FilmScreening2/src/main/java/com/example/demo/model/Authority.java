package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder // tilføjer noget kode til vores kode INDEN projektet starter - tror jeg
@Entity
public class Authority
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String role;
    
    @ManyToMany(mappedBy = "authorities")
    private Set<User> user;
    
    
    
    
}
