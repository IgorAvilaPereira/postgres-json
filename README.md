# postgres-json

O repositório [**postgres-json**](https://github.com/IgorAvilaPereira/postgres-json) demonstra como manipular dados em formato **JSON** e **JSONB** no **PostgreSQL** utilizando **Java**, com foco especial em como ler, gravar e processar esse tipo de dado dentro de aplicações Java.

### ✅ Funcionalidades principais:

* **Armazenamento de dados em JSON/JSONB** em colunas de tabelas PostgreSQL.
* **Consulta e manipulação** de campos JSON usando SQL.
* Integração com **Java** para leitura e gravação de dados JSON no banco.
* Uso da biblioteca **Gson** para manipular objetos Java e convertê-los para JSON (e vice-versa).
* Demonstra práticas como **exclusão de campos na serialização** (com Gson).
* Serve como estudo ou exemplo para aplicações que precisam de **flexibilidade de dados** sem um esquema fixo, como logs, configurações ou atributos dinâmicos.

### 🛠️ Tecnologias utilizadas:

* **Java**
* **PostgreSQL**
* **Gson** (biblioteca Java para JSON)
* **JDBC** (para conexão com o banco de dados)

### 📚 Casos de uso possíveis:

* Sistemas que precisam armazenar **dados semi-estruturados** no banco.
* Aplicações que desejam **consultar e filtrar dados JSON diretamente via SQL**.
* Projetos que exigem **flexibilidade no schema de dados**, como plataformas de eventos, metadados, etc.

### Referências

* https://www.postgresqltutorial.com/postgresql-tutorial/postgresql-json/

* https://www.enterprisedb.com/blog/processing-postgresql-json-jsonb-data-java

* https://www.baeldung.com/gson-exclude-fields-serialization
