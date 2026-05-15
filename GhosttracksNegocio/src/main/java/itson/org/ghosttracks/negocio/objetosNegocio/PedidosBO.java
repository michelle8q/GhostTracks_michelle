package itson.org.ghosttracks.negocio.objetosNegocio;

import itson.ghosttracks.interfaces.IPersistencia;
import itson.org.ghosttracks.dtos.PedidoDTO;
import itson.org.ghosttracks.entidades.Pedido;
import itson.org.ghosttracks.entidades.ProductoPedido;
import itson.org.ghosttracks.enums.EstadoPedidoDTO;
import itson.org.ghosttracks.enums.EstadoPedido;
import itson.org.ghosttracks.exceptions.PersistenciaException;
import itson.org.ghosttracks.fachadas.PersistenciaFachada;
import itson.org.ghosttracks.negocio.interfaces.IPedidosBO;
import itson.org.ghosttracks.negocio.mappers.PedidoAdapter;
import itson.org.ghosttracks.negocio.objetosNegocio.Excepciones.NegocioException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidosBO implements IPedidosBO {
    IPersistencia persistencia;

    public PedidosBO() {
       persistencia = PersistenciaFachada.getInstance();
    }
    @Override
    public PedidoDTO generarPedido(PedidoDTO pedidoDto) throws NegocioException {

        try {

            Pedido entidadPedido = PedidoAdapter.toEntity(pedidoDto);
            entidadPedido.setFechaPedido(LocalDateTime.now());
            entidadPedido.setEstado(EstadoPedido.PAGADO);
            if (entidadPedido.getProductosPedido() != null) {
                for (ProductoPedido detalle : entidadPedido.getProductosPedido()) {
                    detalle.setPedido(entidadPedido);
                }
            }

            Pedido pedidoGuardado = persistencia.guardarPedido(entidadPedido);
            return PedidoAdapter.toDTO(pedidoGuardado);
        } catch (PersistenciaException e) {
            throw new NegocioException("OcurriÃ³ un error al intentar registrar su pedido: " + e.getMessage());
        }
    }
    
    @Override
    public PedidoDTO actualizarEstadoPedido(Long idPedido, EstadoPedidoDTO nuevoEstadoDTO) throws NegocioException {
        try {
            EstadoPedido estadoDominio = EstadoPedido.valueOf(nuevoEstadoDTO.name());
            Pedido pedidoActualizado = persistencia.actualizarEstado(idPedido, estadoDominio);
            return PedidoAdapter.toDTO(pedidoActualizado);

        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudo actualizar el estado del pedido: " + e.getMessage());
        }
    }

    @Override
    public List<PedidoDTO> obtenerTodosLosPedidos() throws NegocioException {
        try {
            List<Pedido> pedidosEntidad = persistencia.consultarTodos();
            List<PedidoDTO> pedidosDTO = new ArrayList<>();

            for (Pedido p : pedidosEntidad) {
                PedidoDTO dto = PedidoAdapter.toDTO(p);
                pedidosDTO.add(dto);
            }

            return pedidosDTO;
            
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener la lista de pedidos: " + e.getMessage());
        }
    }
    
}