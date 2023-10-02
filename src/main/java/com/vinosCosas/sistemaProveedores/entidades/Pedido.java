
 
package com.vinosCosas.sistemaProveedores.entidades;



import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;





@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRecepcion;
    private double monto;
    @ManyToOne
    private Proveedor proveedor;

    public Pedido() {
    }

    public Pedido(Long id, Date fechaRecepcion, double monto, Proveedor proveedor) {
        this.id = id;
        this.fechaRecepcion = fechaRecepcion;
        this.monto = monto;
        this.proveedor = proveedor;
    }

    public Long getId() {
        return id;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public double getMonto() {
        return monto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", fechaRecepcion=" + fechaRecepcion + ", monto=" + monto + ", proveedor=" + proveedor + '}';
    }
    
    
}
