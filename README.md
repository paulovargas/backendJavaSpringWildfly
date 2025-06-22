# Server WildFly

Projeto Java com Spring Boot para gestão de operações bancárias - empacotado como WAR e preparado para execução no servidor de aplicações **WildFly**.

## 📦 Tecnologias e Dependências

- **Spring Boot 2.7.6**
    - Spring Web
    - Spring Data JPA
    - JDBC
- **Banco de Dados**
    - H2 (testes ou desenvolvimento local)
- **Swagger/OpenAPI** – Documentação automática com `springdoc-openapi-ui`
- **WildFly 21** – Servidor de aplicação para deploy do WAR
- **Java 11**
- **Maven** – Gerenciamento de dependências e build

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

## 🚀 Deploy no WildFly

O projeto é empacotado como `.war` e automaticamente copiado para o diretório de deployments do WildFly após o build com:

```bash
mvn install
```

O plugin `maven-antrun-plugin` está configurado para copiar o arquivo WAR para:

```
C:/wildfly-21.0.0.Final/standalone/deployments
```

> ⚠️ Certifique-se de ajustar o caminho conforme a instalação do seu WildFly.

## 📄 Documentação da API

A documentação da API está disponível automaticamente após o deploy:

```
http://127.0.0.1:8080/fiesc-bank/swagger-ui/index.html

```

## ✅ Pré-requisitos

- Java 11
- Maven 3.6+
- WildFly 21 (ou superior)
- MySQL Server (opcionalmente configurado)

## 🛠️ Build Manual

```bash
mvn clean install
```

O `.war` será gerado em:

```
target/fiesc-bank.war
```

---

## 📌 Autor

**Paulo Vargas**  

# backendJavaSpringWildfly
