# Uitlizando o banco de dados

## Por que Docker?
Ao usar Docker diminuímos o tempo de deployment do banco de dados e garantimos, com mais facilidade, que todos estão trabalhando na mesma base de dados.

## Como inicializar o banco de dados?
Com alguns simples comandos você consegue ter um banco de dados MySQL rodando no container.

Primeiro, precisamos fazer o build da imagem customizada definida no Dockerfile.
Para isso, garanta que você está em [db](./) e use o comando:
```bash
# docker build -t db/mysql .
```

Agora, para começar o container, faça:
```bash
# docker run --name mysql-db -d db/mysql
```

Por fim, para acessá-lo, utilzamos:
```bash
# docker exec -it mysql-db bash
```

# Dentro do Container
Como já estamos dentro do container, podemos acessar nosso banco de dados criado com [init.sql](./init.sql) através do comando:
```bash
# mysql -uroot -pmysql-root
```

# Dentro do banco de dados
Para checar que o banco de dados está funcionando, podemos checar se VoceAluga se encontra nas base de dados com ```show databases;```.
Podemos analisar VoceAluga também:
```
mysql> use VoceAluga;
mysql> show tables; # deve aparecer Cliente
mysql> select * from Cliente; # deve aparecer que está vazio
```
