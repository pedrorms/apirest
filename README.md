# API Rest
Exemplo de API que contém os dados dos planetas da franquia StarWars.

##
Requisitos:
- Os planetas devem ser obtidos do banco da aplicação;
- Os planetas deve ser inserido manualmente, com os campos "Nome", "Clima" e Terreno.
- Também deve-se obter a quantidade de aparições em filmes dos planetas, através da API pública do Star Wars: [**swapi**](https://swapi.co/)

##
Funcionalidades:
- Adicionar um planeta (com nome, clima e terreno);
- Listar planetas;
- Buscar planeta por nome e ID;
- Remover planeta;

## Implementação
Projeto em Java (Framework Spring Boot)

Banco de dados H2 embedded

---

Criando um Planeta (JSON Body)
```
curl -H "Content-Type: application/json" -X POST \
-d '{"nome":"Tatooine", "clima":"Arido", "terreno":"Deserto"}' localhost:8080/api/planeta
```

Listando todos os Planetas:
```
curl localhost:8080/api/planetas
```

Buscar Planeta por ID:
```
curl localhost:8080/api/planeta/id/{id}
```

Buscar Planeta por Nome:
```
curl localhost:8080/api/planeta/nome/{nome}
```

Removendo um Planeta:
```
curl -X "DELETE" localhost:8080/api/planeta/remover/{id}
```
