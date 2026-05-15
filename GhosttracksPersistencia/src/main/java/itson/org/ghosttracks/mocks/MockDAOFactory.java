/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.org.ghosttracks.mocks;

import itson.org.ghosttracks.daos.IAdministradoresDAO;
import itson.org.ghosttracks.daos.IClientesDAO;
import itson.org.ghosttracks.daos.IGenerosDAO;
import itson.org.ghosttracks.daos.IPedidosDAO;
import itson.org.ghosttracks.daos.IProductosDAO;
import itson.org.ghosttracks.daos.ISucursalesDAO;
import itson.org.ghosttracks.daos.ITiposDAO;

/**
 *
 * @author cinca
 * 
 * Creador concreto
 * 
 */
public class MockDAOFactory extends FactoryDAO {

    @Override
    public IProductosDAO crearProductosDAO() {
       return new ProductosMockDAO();
    }

    @Override
    public ITiposDAO crearTiposDAO() {
        return new TiposMockDAO();
    }

    @Override
    public IGenerosDAO crearGenerosDAO() {
        return new GenerosMockDAO();
    }

    @Override
    public ISucursalesDAO crearSucursalesDAO() {
        return new SucursalesMockDAO();
    }
    @Override
    public IAdministradoresDAO crearAdministradoresDAO() {
        return new AdministradoresMockDAO();
    }
    
    @Override
    public IClientesDAO crearClientesDAO() {
        return new ClientesMockDAO();
    }
    
    @Override
    public IPedidosDAO crearPedidosDAO() {
        return new PedidosMockDAO();
    }
}
