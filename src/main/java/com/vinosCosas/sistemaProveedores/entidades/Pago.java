/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinosCosas.sistemaProveedores.entidades;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author blasd
 */
@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String fechaPago;
    private double montoPago;
    @ManyToOne
    private Proveedor proveedor; 

    public Pago() {
    }

    public Pago(Long id, String fechaPago, double montoPago, Proveedor proveedor) {
        this.id = id;
        this.fechaPago = fechaPago;
        this.montoPago = montoPago;
        this.proveedor = proveedor;
    }

    public Long getId() {
        return id;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public double getMontoPago() {
        return montoPago;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void setMontoPago(double montoPago) {
        this.montoPago = montoPago;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Pago{" + "id=" + id + ", fechaPago=" + fechaPago + ", montoPago=" + montoPago + ", proveedor=" + proveedor + '}';
    }
    
    
}
