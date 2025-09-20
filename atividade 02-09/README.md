# Sistema de Gerenciamento de Funcionários

Este projeto implementa um sistema completo para gerenciar funcionários de uma empresa, aplicando os conceitos fundamentais de Programação Orientada a Objetos (POO).

## Conceitos Implementados

### 1. Hierarquia de Classes
- **Classe Abstrata**: `Funcionario` - define a estrutura base para todos os funcionários
- **Classes Filhas**: 
  - `Gerente` - herda de Funcionario
  - `Estagiario` - herda de Funcionario

### 2. Interface
- **Interface**: `Bonificavel` - define o contrato para cálculo de bônus
- Implementada pelas classes `Gerente` e `Estagiario`

### 3. Polimorfismo
O programa principal demonstra polimorfismo de várias formas:
- Chamando o mesmo método (`exibirInformacoes()`, `calcularSalarioTotal()`) em objetos de tipos diferentes
- Usando interfaces para tratar objetos de forma uniforme
- Aplicando casting para acessar métodos específicos das classes filhas

### 4. Testes
O sistema cria vários objetos e testa todos os métodos para verificar o comportamento correto.

## Estrutura do Projeto

```
├── Funcionario.java                    # Classe abstrata base
├── Bonificavel.java                   # Interface para bônus
├── Gerente.java                       # Classe filha - Gerente
├── Estagiario.java                    # Classe filha - Estagiário
├── SistemaGerenciamentoFuncionarios.java # Programa principal
└── README.md                          # Documentação
```

## Funcionalidades

### Classe Funcionario (Abstrata)
- Atributos: nome, CPF, salário, cargo
- Método abstrato: `calcularSalarioTotal()`
- Método concreto: `exibirInformacoes()`

### Interface Bonificavel
- Método: `calcularBonus()`
- Método default: `aplicarBonus()`
- Método default: `exibirBonus()`

### Classe Gerente
- Herda de `Funcionario`
- Implementa `Bonificavel`
- Atributos específicos: equipe gerenciada, percentual de bônus
- Cálculo de bônus: 15% do salário + R$ 100 por pessoa na equipe

### Classe Estagiario
- Herda de `Funcionario`
- Implementa `Bonificavel`
- Atributos específicos: instituição de ensino, meses de contrato, bolsa de estudo
- Cálculo de bônus: R$ 50 por mês + R$ 200 se tem bolsa + 5% do salário

## Como Executar

1. Compile todos os arquivos:
```bash
javac *.java
```

2. Execute o programa principal:
```bash
java SistemaGerenciamentoFuncionarios
```

## Exemplo de Saída

O programa demonstra:
- Polimorfismo com métodos da classe base
- Polimorfismo com interfaces
- Métodos específicos das classes filhas
- Relatório financeiro completo da empresa

## Demonstração de POO

### Herança
- `Gerente` e `Estagiario` herdam de `Funcionario`
- Reutilização de código e estrutura comum

### Polimorfismo
- Mesmo método comporta-se diferente em cada classe filha
- Tratamento uniforme de objetos através de interfaces

### Encapsulamento
- Atributos privados com métodos getter/setter
- Controle de acesso aos dados

### Abstração
- Classe abstrata define estrutura sem implementação completa
- Interface define contrato sem implementação
