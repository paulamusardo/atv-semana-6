public abstract class Funcionario {
    protected String nome;
    protected String cpf;
    protected double salario;
    protected String cargo;
    
    // Construtor
    public Funcionario(String nome, String cpf, double salario, String cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.cargo = cargo;
    }
    
    // Métodos getters e setters
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public double getSalario() {
        return salario;
    }
    
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    // Método abstrato que deve ser implementado pelas classes filhas
    public abstract double calcularSalarioTotal();
    
    // Método concreto que pode ser sobrescrito pelas classes filhas
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Cargo: " + cargo);
        System.out.println("Salário Base: R$ " + String.format("%.2f", salario));
        System.out.println("Salário Total: R$ " + String.format("%.2f", calcularSalarioTotal()));
        System.out.println("-------------------");
    }
}
