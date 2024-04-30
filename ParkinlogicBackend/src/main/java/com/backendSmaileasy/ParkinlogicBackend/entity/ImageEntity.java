package com.backendSmaileasy.ParkinlogicBackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recursos")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(columnDefinition = "oid")
    private byte[] datosImagen;

    @Column
    private String nombre;

    @Column
    private String facility;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getDatosImagen() {
        return datosImagen;
    }

    public void setDatosImagen(byte[] datosImagen) {
        this.datosImagen = datosImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public ImageEntity(Long id, byte[] datosImagen, String nombre, String facility) {
        this.id = id;
        this.datosImagen = datosImagen;
        this.nombre = nombre;
        this.facility = facility;
    }

    public ImageEntity() {
    }
}