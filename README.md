# Detalhamento de Requisitos Peleja Representações

## Entidades

### 1. Representante
- **Atributos**: `id`, `nome`, `cnpj`, `razao_social`, `endereco_id`
- **Regras de Negócio**:
  - Um representante deve ter um CNPJ válido e único.
  - O endereço deve ser informado.
  - Deve ser possível listar os funcionários, representados e clientes vinculados a cada representante.

### 2. Endereço
- **Atributos**: `id`, `estado`, `cep`, `cidade`, `rua`, `bairro`, `numero`
- **Regras de Negócio**:
  - O CEP deve ser validado no formato correto.
  - O estado deve ser um código de dois caracteres (ex.: "SP").
  - Um endereço pode ser vinculado a um representante ou cliente.

### 3. Representados
- **Atributos**: `id`, `nome`, `cnpj`
- **Regras de Negócio**:
  - O CNPJ deve ser válido e único.
  - Deve estar vinculado a um ou mais representantes.

### 4. Funcionário
- **Atributos**: `id`, `nome`, `cpf`, `cargo_id`
- **Regras de Negócio**:
  - O CPF deve ser válido e único.
  - Um funcionário deve estar vinculado a um cargo e a um representante.

### 5. Cargo
- **Atributos**: `id`, `nome`
- **Regras de Negócio**:
  - Um cargo pode ser associado a múltiplos funcionários.

### 6. Cliente
- **Atributos**: `id`, `nome`, `telefone`, `email`, `endereco_id`
- **Regras de Negócio**:
  - O email deve ser válido e único.
  - O telefone deve seguir um padrão de formatação.
  - Deve estar vinculado a um representante e ter um endereço associado.

## Funcionalidades
- Cadastro, listagem, atualização e exclusão de representantes, funcionários, cargos, representados, clientes e endereços.
- Validação de CNPJ e CPF ao cadastrar ou atualizar representantes, representados e funcionários.
- Associar múltiplos funcionários, representados e clientes a um representante.
- Consultar a lista de clientes e representados vinculados a um representante.

# Modelo Entidade-Relacionamento (MER)

## Entidades e Relacionamentos

### Representante
- Relacionamento:
  - "1:N" com **Funcionário** (um representante pode ter vários funcionários).
  - "1:N" com **Representados** (um representante pode representar vários representados).
  - "1:N" com **Cliente** (um representante pode ter vários clientes).
  - "1:1" com **Endereço** (um representante possui um endereço).

### Funcionário
- Relacionamento:
  - "N:1" com **Cargo** (um cargo pode ser atribuído a vários funcionários).

### Cliente
- Relacionamento:
  - "1:1" com **Endereço** (um cliente possui um endereço).

## Diagrama Conceitual

```plaintext
[Representante] 1—n [Funcionário]
[Representante] 1—n [Representados]
[Representante] 1—n [Cliente]
[Representante] 1—1 [Endereço]
[Funcionário] n—1 [Cargo]
[Cliente] 1—1 [Endereço]
