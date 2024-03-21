<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>CRUD Cliente</title>
    <link rel="stylesheet" href="./css/style.css" />
</head>
<body>
<div>
    <header>
        <jsp:include page="menu.jsp"/>
    </header>
</div>
<main>
    <form action="cliente" method="post">
        <div>
            <label for="cpf">CPF</label>
            <input type="number" placeholder="cpf" name="cpf" id="cpf" value="${cliente.cpf}" />
            <input type="submit" value="Buscar" name="botao" />
        </div>
        <div>
            <label for="nome">Nome</label>
            <input type="text" placeholder="Nome" name="nome" id="nome" value="${cliente.nome}" />
        </div>
        <div>
            <label for="email">E-mail</label>
            <input type="text" placeholder="email" name="email" id="email" value="${cliente.email}" />
        </div>
        <div>
            <label for="limite_credito">Limite de Crédito</label>
            <input
                    type="number"
                    step="0.01"
                    placeholder="limite_credito"
                    name="limite_credito"
                    id="limite_credito"
                    value="${cliente.limite_credito}"
            />
        </div>
        <div>
            <label for="data_nasc">Data de Nascimento</label>
            <input type="date" name="data_nasc" id="data_nasc" value="${cliente.dt_nasc}" />
        </div>
        <div>
            <input type="submit" value="Cadastrar" name="botao" />
            <input type="submit" value="Alterar" name="botao" />
            <input type="submit" value="Excluir" name="botao" />
        </div>
        <div>
            <input type="submit" value="Listar" name="botao" />
        </div>
        <div>
            <table>
                <thead>
                <th>CPF</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Limite</th>
                <th>Dt. Nasc</th>
                <th>ação</th>
                </thead>
                <tbody>
                <c:if test="${ not empty clientes }">
                    <c:forEach items="${clientes}" var="c">
                        <tr>
                            <td> <c:out value="${c.cpf}"/> </td>
                            <td> <c:out value="${c.nome}"/> </td>
                            <td> <c:out value="${c.email}"/> </td>
                            <td> <c:out value="${c.limite_credito}"/> </td>
                            <td> <c:out value="${c.dt_nasc}"/> </td>
                            <td>
                                <p> <a href="">Editar</a> </p>
                                <p> <a href="">Excluir</a> </p>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
    </form>
</main>
</body>
</html>
