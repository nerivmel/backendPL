package com.backendSmaileasy.ParkinlogicBackend.entity;

import jakarta.persistence.*;

@Table(name = "Persons")
@Entity
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String docType;
    @Column
    private String doc;

    public PersonEntity() {
    }

    public PersonEntity(String name, String email, String docType, String doc) {
        this.name = name;
        this.email = email;
        this.docType = docType;
        this.doc = doc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String doc_type) {
        this.docType= docType;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", doc_type='" + docType + '\'' +
                ", doc='" + doc + '\'' +
                '}';
    }
}
