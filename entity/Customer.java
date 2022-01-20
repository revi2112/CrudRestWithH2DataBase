package com.example.springboot.h2crud.springbootfirst.entity;
import java.util.Date;

 

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.Table;

 

import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;

 

import lombok.Getter;

import lombok.Setter;

import lombok.ToString;

@Entity
@Table(name = "tbl_customer")
@ToString
@Setter
@Getter
public class Customer {
              @Id
              @GeneratedValue(strategy= GenerationType.IDENTITY)
              private Long id;
              private String name;
              public String getName() {

               return name;

              }
              public void setName(String name) {
            	  this.name = name;
              }
              public int getAge() {

                   return age;

              }
              public void setAge(int age) {

                   this.age = age;

              }
              public String getLocation() {

                    return location;

              }
              public void setLocation(String location) {

                   this.location = location;

              }
              private int age;
              private String location;

              @CreationTimestamp
              @Column(name = "created_at")
              private Date createdAt;

            
              @UpdateTimestamp
              @Column(name = "updated_at")
              private Date updatedAt;

}