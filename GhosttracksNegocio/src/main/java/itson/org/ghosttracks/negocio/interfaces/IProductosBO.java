/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.interfaces;

import itson.org.ghosttracks.dtos.ProductoDTO;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author cinca
 */
public interface IProductosBO {
    public abstract List<ProductoDTO> obtenerTodos() throws NegocioException;
    public abstract ProductoDTO obtenerProductoPorId(Long id) throws NegocioException;
    public abstract ProductoDTO buscarProductoPorNombre(String nombre) throws NegocioException;
    public ProductoDTO eliminarProducto(ProductoDTO producto) throws NegocioException;
    public ProductoDTO crearProducto(ProductoDTO producto) throws NegocioException;
    public ProductoDTO actualizarProducto(ProductoDTO producto) throws NegocioException;
    
}
