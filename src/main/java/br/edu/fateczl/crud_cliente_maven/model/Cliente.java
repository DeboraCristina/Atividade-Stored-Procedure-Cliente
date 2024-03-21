package br.edu.fateczl.crud_cliente_maven.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Cliente
{
    String cpf, nome, email;
    Double limite_credito;
    Date dt_nasc;
}
