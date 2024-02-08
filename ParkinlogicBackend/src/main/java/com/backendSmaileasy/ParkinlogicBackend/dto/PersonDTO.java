package com.backendSmaileasy.ParkinlogicBackend.dto;

public class PersonDTO {
    private String name;
    private String email;
    private String doctype;
    private String doc;

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

    public void setDocType(String doc_type) {
        this.doctype = doc_type;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public PersonDTO(String name, String email, String doctype, String doc) {
        this.name = name;
        this.email = email;
        this.doctype = doctype;
        this.doc = doc;
    }
}
