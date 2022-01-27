package br.com.alura.mvc.mudi.api;

import br.com.alura.mvc.mudi.controller.PedidoRepository;
import br.com.alura.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mvc.mudi.model.Oferta;
import br.com.alura.mvc.mudi.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Oferta criarOferta(RequisicaoNovaOferta requisicao){

        Optional<Pedido> pedidoreq = pedidoRepository.findById(requisicao.getPedidoId());

        if(!pedidoreq.isPresent()){
            return null;
        }
        Pedido pedido = pedidoreq.get();
        Oferta oferta = requisicao.toOferta();
        oferta.setPedido(pedido);
        pedido.getOfertas().add(oferta);
        pedidoRepository.save(pedido);
        return oferta;





    }
}
