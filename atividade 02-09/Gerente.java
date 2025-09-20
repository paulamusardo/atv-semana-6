public class Gerente extends Funcionario implements Bonificavel {
    private double bonusGerencia;
    private int equipeGerenciada;
    
    // Construtor
    public Gerente(String nome, String cpf, double salario, int equipeGerenciada) {
        super(nome, cpf, salario, "Gerente");
        this.equipeGerenciada = equipeGerenciada;
        this.bonusGerencia = 0.15; // 15% de bônus por gerência
    }
    
    // Getters e setters específicos do Gerente
    public double getBonusGerencia() {
        return bonusGerencia;
    }
    
    public void setBonusGerencia(double bonusGerencia) {
        this.bonusGerencia = bonusGerencia;
    }
    
    public int getEquipeGerenciada() {
        return equipeGerenciada;
    }
    
    public void setEquipeGerenciada(int equipeGerenciada) {
        this.equipeGerenciada = equipeGerenciada;
    }
    
    // Implementação do método abstrato da classe Funcionario
    @Override
    public double calcularSalarioTotal() {
        return salario + calcularBonus();
    }
    
    // Implementação do método da interface Bonificavel
    @Override
    public double calcularBonus() {
        // Bônus baseado no salário e no tamanho da equipe
        double bonusSalario = salario * bonusGerencia;
        double bonusEquipe = equipeGerenciada * 100; // R$ 100 por pessoa na equipe
        return bonusSalario + bonusEquipe;
    }
    
    // Método específico do Gerente
    public void gerenciarEquipe() {
        System.out.println("Gerente " + nome + " está gerenciando uma equipe de " + equipeGerenciada + " pessoas.");
    }
    
    // Sobrescrita do método exibirInformacoes para incluir dados específicos do Gerente
    @Override
    public void exibirInformacoes() {
        System.out.println("=== INFORMAÇÕES DO GERENTE ===");
        super.exibirInformacoes();
        System.out.println("Equipe Gerenciada: " + equipeGerenciada + " pessoas");
        System.out.println("Percentual de Bônus: " + (bonusGerencia * 100) + "%");
        exibirBonus();
        System.out.println("=============================");
    }
}
