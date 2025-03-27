package com.async.asyncMuseum.model;

import com.async.asyncMuseum.dto.MuseeDto;
import com.async.asyncMuseum.util.MyUtil;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="musee")  
public class Musee{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nom;
   private String description;
   private String adresse;
   private String telephone;
   private String email;
   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "musee_horaires", joinColumns = @JoinColumn(name = "musee_id"), inverseJoinColumns = @JoinColumn(name = "horaire_id"))
   private List<Horaire> horaires ;
   @OneToMany(mappedBy = "musee")
   private List<Exposition> expositions;
   @OneToMany(mappedBy = "musee")
   private List<CollectionMusee> collections;
   public MuseeDto toDto(){
      return MyUtil.convert(this,new MuseeDto());
   }

   public void setId(Long id){
      this.id=id;
   }
}
