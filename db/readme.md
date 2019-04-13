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
# Deploying
Antes de colocar em produção, é recomendável utilizar o script ```mysql_secure_installation``` para garantir algumas questões de segurança básica.

# Conexão com o banco de dados
Para fazer com que o programa faça a conexão com o banco de dados de forma correta, utilize variáveis de ambiente para fazer a configuração dos dados necessários sem que disponível no código o usuário e senha.

## Definindo variáveis de ambiente
As variáveis de ambiente no Linux podem ser definidas usando o padrão KEY=VALUE. Assim, configure trocando os `values` de acordo.
```bash
$ MYSQL_REMOTE_IP=<ip>
$ MYSQL_REMOTE_USER=<user>
$ MYSQL_REMOTE_PASSWORD=<password>
```

## Liberando acesso ao seu usuário pela instância da AWS
Como temos um servidor mysql rodando na AWS, basta conectarmo-nos a ele e nos garantir os privilégios necessários.
- Conecte-se à instância com `ssh -i key.pem ec2-user@$MYSQL_REMOTE_IP`. Você verá que o terminal mudou e agora você se encontra dentro da instância mencionada.
- Utilize-se do comando `mysql -h localhost --protocol=tcp -u $MYSQL_REMOTE_USER -p` para fazer a conexão com o banco de dados. Digite a senha definida em `$MYSQL_REMOTE_PASSWORD` na sequência.
- Agora que nos encontramos em contato direto com o banco de dados, podemos nos dar os devidos privilégios com os comandos `GRANT ALL PRIVILEGES ON *.* TO '$MYSQL_REMOTE_USER'@'<seu_ip_externo' WITH GRANT OPTION; FLUSH PRIVILEGES;`. E pronto, basta acessar o banco de dados agora.