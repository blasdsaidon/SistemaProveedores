/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinosCosas.sistemaProveedores.repositorios;


import com.vinosCosas.sistemaProveedores.entidades.Pago;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author blasd
 */
@Repository
public interface PagoRepo extends JpaRepository<Pago, Long> {
    
//    @Query("SELECT p FROM Pago p WHERE p.proveedor_id = :idProveedor")
//    public List<Pago> BuscarPorProveedor(@Param("proveedor") Long idProveedor);
}
