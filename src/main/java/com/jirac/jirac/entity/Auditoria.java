package com.jirac.jirac.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
@SoftDelete(columnName = "deletado")
public abstract class Auditoria {
    @CreationTimestamp
    private LocalDateTime dataCriacao;
    @UpdateTimestamp
    private LocalDateTime dataModificacao;

    public Auditoria() {
    }

    public Auditoria(LocalDateTime dataCriacao, LocalDateTime dataModificacao) {
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

}
