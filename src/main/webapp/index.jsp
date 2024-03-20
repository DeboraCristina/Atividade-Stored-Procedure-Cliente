<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
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
    <a>Home</a>
    <a>Cliente</a>
  </header>
</div>
<main>
  <form action="" method="post">
    <div>
      <label for="cpf">CPF</label>
      <input type="number" placeholder="cpf" name="cpf" id="cpf" />
      <input type="submit" value="Buscar" name="botao" id="botao" />
    </div>
    <div>
      <label for="nome">Nome</label>
      <input type="text" placeholder="Nome" name="nome" id="nome" />
    </div>
    <div>
      <label for="email">E-mail</label>
      <input type="text" placeholder="email" name="email" id="email" />
    </div>
    <div>
      <label for="limite_credito">Limite de Crédito</label>
      <input
              type="number"
              step="0.01"
              placeholder="limite_credito"
              name="limite_credito"
              id="limite_credito"
      />
    </div>
    <div>
      <label for="data_nasc">Data de Nascimento</label>
      <input type="date" name="data_nasc" id="data_nasc" />
    </div>
    <div>
      <input type="submit" value="Cadastrar" name="botao" id="botao" />
      <input type="submit" value="Alterar" name="botao" id="botao" />
      <input type="submit" value="Excluir" name="botao" id="botao" />
    </div>
    <div>
      <input type="submit" value="Listar" name="botao" id="botao" />
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
        <!-- TODO: Table Body -->
        <td>12345678912</td>
        <td>Francisca</td>
        <td>Francisca@gmail.com</td>
        <td>100.90</td>
        <td>01-04-2001</td>
        <td>
          <a href="">Editar</a>
          <a href="">Excluir</a>
        </td>
        <!-- TODO: Table Body -->
        </tbody>
      </table>
    </div>
  </form>
</main>
</body>
</html>