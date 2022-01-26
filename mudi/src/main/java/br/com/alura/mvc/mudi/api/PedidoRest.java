package br.com.alura.mvc.mudi.api;

import br.com.alura.mvc.mudi.controller.PedidoRepository;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("aguardando")
    public List<Pedido> getPedidosAguardando() {
        Sort sort = Sort.by("id").descending();

        PageRequest pageRequest = PageRequest.of(0, 5, sort);

        return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, pageRequest);
    }
}
