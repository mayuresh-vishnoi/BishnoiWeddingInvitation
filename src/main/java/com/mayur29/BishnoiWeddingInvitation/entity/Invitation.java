package com.mayur29.BishnoiWeddingInvitation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Invitation {
    @Id
    private int id;
    private String groomName;
    private String brideName;
    private String mobileNumber;
    private int templateId;
}
