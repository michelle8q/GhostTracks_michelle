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
 * Implementacion de patron Factory.
 * Esta clase es la creadora que declara los metodos fabrica.
 */
public abstract class IFactoryDAO {
    
    public abstract IProductosDAO crearProductosDAO();
    public abstract ITiposDAO crearTiposDAO();
    public abstract IGenerosDAO crearGenerosDAO();
    public abstract ISucursalesDAO crearSucursalesDAO();
    public abstract IAdministradoresDAO crearAdministradoresDAO();
    public abstract IClientesDAO crearClientesDAO();
    public abstract IPedidosDAO crearPedidosDAO();
}
