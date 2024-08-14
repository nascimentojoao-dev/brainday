# Projeto de API de Pacientes e Laudos

Este projeto é uma API desenvolvida em Spring Boot com um painel frontend em Angular para gerenciar pacientes e laudos. O objetivo principal é fornecer uma interface simples para a administração de pacientes e laudos associados a eles.

## Tecnologias Utilizadas

- **Backend**: Spring Boot / Java
- **Frontend**: Angular / Typescript
- **Banco de Dados**: PostgreSQL
- **Autenticação**: Basic (admin/admin)
- **Estilização**: Tailwind CSS

## Funcionalidades

### Backend

- **Pacientes**:
  - Cadastrar novos pacientes
  - Atualizar informações de pacientes existentes
  - Excluir pacientes
  - Listar todos os pacientes
  - Buscar paciente por ID

- **Laudos**:
  - Adicionar laudos a pacientes existentes
  - Atualizar laudos
  - Excluir laudos
  - Listar laudos de um paciente

### Frontend

- **Autenticação**:
  - Página de login com autenticação básica
  - Redirecionamento para a página inicial após o login

- **Página Inicial**:
  - Listagem de todos os pacientes com opções para adicionar, editar e excluir pacientes
  - Navegação para a página de detalhes do paciente

- **Detalhes do Paciente**:
  - Exibição de informações detalhadas do paciente e laudos associados
  - Opção para adicionar laudos

- **Formulários**:
  - Formulário para adicionar e atualizar pacientes
  - Formulário para adicionar laudos a pacientes

## Configuração do Ambiente

O backend e o frontend estão no mesmo repositório. Siga os passos abaixo para configurar e executar ambos.

### Backend

1. Clone o repositório:
   ```bash
   git clone https://github.com/nascimentojoao-dev/brainday.git
   cd painel-api
   ```

2. Configure o banco de dados no arquivo src/main/resources/application.properties: 
  ```bash
  spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
  spring.datasource.username=usuario
  spring.datasource.password=senha
  ```

3. Importe o projeto no Eclipse:
  - Abra o Eclipse.
  - Selecione File > Import > Existing Maven Projects.
  - Selecione o diretório do projeto e conclua a importação.

4. Execute a aplicação:
  - Clique com o botão direito no projeto importado.
  - Selecione Run As > Spring Boot App.

5.  API estará disponível em http://localhost:8080. Você pode usar ferramentas como Postman, Insomnia ou curl para testar os endpoints.

### Frontend

1. No mesmo diretório do repositório clonado, navegue para o diretório do frontend:
  ```bash
  cd ../front-end
  ```

2. Instale as dependências:
  ```bash
  npm install
  ```

3. Execute o frontend:
  ```bash
  ng serve
```

## Licença

O projeto é licenciado sob a Licença MIT. Veja abaixo os detalhes da licença:

---

**MIT License**

Copyright (c) [2024] [João Nascimento]

Permissão é concedida, gratuitamente, a qualquer pessoa que obtenha uma cópia deste software e arquivos de documentação associados (o "Software"), para lidar no Software sem restrição, incluindo sem limitação os direitos de usar, copiar, modificar, mesclar, publicar, distribuir, sublicenciar e/ou vender cópias do Software, desde que as seguintes condições sejam atendidas:

A permissão acima deve ser incluída em todas as cópias ou partes substanciais do Software.

O Software é fornecido "no estado em que se encontra", sem garantia de qualquer tipo, expressa ou implícita, incluindo, mas não se limitando a, as garantias implícitas de comercialização, adequação a um propósito específico e não violação. Em nenhum caso o(s) autor(es) ou detentores de direitos autorais serão responsáveis por qualquer reclamação, dano ou outra responsabilidade, seja em uma ação de contrato, ato ilícito ou de outra forma, decorrente de ou em conexão com o Software ou o uso ou outros negócios no Software.

---
