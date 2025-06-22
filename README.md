# Fiesc Bank

Projeto Java com Spring Boot para gestão de operações bancárias — empacotado como WAR e preparado para execução no servidor de aplicações **WildFly**.

---

## 📦 Tecnologias e Dependências

- **Spring Boot 2.7.6**
  - Spring Web
  - Spring Data JPA
  - JDBC
- **Banco de Dados**
  - MariaDB (via datasource JNDI configurado no WildFly)
- **Swagger/OpenAPI** – Documentação automática com `springdoc-openapi-ui`
- **WildFly 21** – Servidor de aplicação para deploy do WAR
- **Java 11**
- **Maven** – Gerenciamento de dependências e build

---

## 📁 Estrutura do Projeto

O projeto segue a estrutura padrão de aplicações Spring Boot:

```
src/
├── main/
│   ├── java/
│   │   └── com/paulovargas/fiescbank/...
│   ├── resources/
│   │   ├── application.properties
│   │   └── ...
├── test/
│   └── java/...
```

---

## 🚀 Deploy no WildFly

O projeto é empacotado como `.war` e automaticamente copiado para o diretório de deployments do WildFly após o build com:

```bash
mvn clean install
```

O plugin `wildfly-maven-plugin` está configurado para fazer o deploy automático via management API do WildFly.

⚠️ **Antes de rodar o deploy, configure o datasource MariaDB no WildFly conforme abaixo.**

---

## ⚙️ Configuração do MariaDB no WildFly

1. **Instale o driver MariaDB no WildFly** (via módulo ou console admin).
2. **Configure um datasource JNDI com o nome:**  
   `java:/jdbc/fiescdb`
3. Exemplo de configuração no `standalone.xml`:

```xml
<datasource jndi-name="java:/jdbc/fiescdb" pool-name="FiescBankDS" enabled="true" use-java-context="true">
  <connection-url>jdbc:mariadb://localhost:3306/fiescdb</connection-url>
  <driver>mariadb</driver>
  <security>
    <user-name>root</user-name>
    <password>sua_senha</password>
  </security>
</datasource>

<drivers>
  <driver name="mariadb" module="org.mariadb.jdbc">
    <driver-class>org.mariadb.jdbc.Driver</driver-class>
  </driver>
</drivers>
```

---

## 📄 Configuração do Spring Boot

O `application.properties` está configurado para usar o datasource JNDI do WildFly:

```properties
spring.datasource.jndi-name=java:/jdbc/fiescdb
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MariaDBDialect
spring.jpa.show-sql=true
```

---

## 📄 Documentação da API

A documentação da API estará disponível automaticamente após o deploy:

```
http://127.0.0.1:8080/fiesc-bank/swagger-ui/index.html
```

---

## ▶️ Como iniciar o WildFly localmente

1. Navegue até o diretório da instalação do WildFly:

```bash
cd C:/wildfly-21.0.0.FIESC/bin
```

2. Execute o script para iniciar o servidor:

```cmd
standalone.bat
```

3. Aguarde o servidor iniciar (vai rodar na porta 8080 por padrão).

4. Console de administração disponível em:

```
http://localhost:9990/
```

Para parar o servidor, use Ctrl+C na janela do terminal.

---

## ✅ Pré-requisitos

- Java 11
- Maven 3.6+
- WildFly 21 (ou superior)
- MariaDB Server rodando e banco `fiescdb` criado

---

## 🛠️ Build e Deploy Manual

```bash
mvn clean install
```

O arquivo `.war` será gerado em:

```
target/fiesc-bank.war
```

---

## 📌 Autor

**Paulo Vargas**
