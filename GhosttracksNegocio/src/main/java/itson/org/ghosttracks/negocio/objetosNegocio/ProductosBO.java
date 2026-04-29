/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.negocio.objetosNegocio;

import itson.org.ghosttracks.daos.IProductosDAO;
import itson.org.ghosttracks.dtos.ProductoDTO;
import itson.org.ghosttracks.entidades.Producto;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import itson.org.ghosttracks.mocks.ProductosMockDAO;
import itson.org.ghosttracks.negocio.interfaces.IProductosBO;
import itson.org.ghosttracks.negocio.mappers.ProductoAdapter;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cinca
 */
public class ProductosBO implements IProductosBO {

    private final IProductosDAO productosDAO;

    public ProductosBO() {
        this.productosDAO = new ProductosMockDAO();
    }

    @Override
    public List<ProductoDTO> obtenerTodos() throws NegocioException {
        try {
            List<Producto> productosEntidad = productosDAO.obtenerTodos();
            List<ProductoDTO> productosDTO = new ArrayList<>();

            for (Producto p : productosEntidad) {
               ProductoDTO dto = ProductoAdapter.toDTO(p);
               productosDTO.add(dto);
            }
            
            return productosDTO;
            
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al consultar el catálogo de productos: " + e.getMessage());
        }
    }

    @Override
    public ProductoDTO obtenerProductoPorId(Long id) throws NegocioException {

        try {
            Producto productoDominio = productosDAO.buscarPorId(id);
            return ProductoAdapter.toDTO(productoDominio);

        } catch (PersistenciaException e) {
            throw new NegocioException("No pudimos recuperar la información del producto: " + e.getMessage());
        }
    }
    
    @Override
    public ProductoDTO buscarProductoPorNombre(String nombre) throws NegocioException {

        try {
            Producto productoDominio = productosDAO.buscarPorNombre(nombre);
            return ProductoAdapter.toDTO(productoDominio);

        } catch (PersistenciaException e) {
            throw new NegocioException("No pudimos recuperar la información del producto: " + e.getMessage());
        }
    }
    
}
