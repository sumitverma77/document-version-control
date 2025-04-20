package com.security.documentversioncontrol.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
@Setter
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String s3Link;

    private Date uploadDate;
}
