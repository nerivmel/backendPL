package com.backendSmaileasy.ParkinlogicBackend.entity;

import jakarta.persistence.*;

@Table(name = "Persons")
@Entity
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String doctype;
    @Column
    private String doc;

    public PersonEntity() {
    }

    public PersonEntity(String name, String email, String doctype, String doc) {
        this.name = name;
        this.email = email;
        this.doctype = doctype;
        this.doc = doc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
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
                ", doc_type='" + doctype + '\'' +
                ", doc='" + doc + '\'' +
                '}';
    }
}
