package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Oferta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RequisicaoNovaOferta {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Long pedidoId;

    private String valor;

    private String datadaEntrega;

    private String comentario;


    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDatadaEntrega() {
        return datadaEntrega;
    }

    public void setDatadaEntrega(String datadaEntrega) {
        this.datadaEntrega = datadaEntrega;
    }

    public String getComentarios() {
        return comentario;
    }

    public void setComentarios(String comentarios) {
        this.comentario = comentarios;
    }

    public Oferta toOferta() {
        Oferta oferta = new Oferta();
        oferta.setComentario(this.comentario);
        oferta.setValor(new BigDecimal(this.valor));
        oferta.setDataDaEntrega(LocalDate.parse(this.datadaEntrega,formatter));
        return oferta;

    }
}
