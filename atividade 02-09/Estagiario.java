public class Estagiario extends Funcionario implements Bonificavel {
    private String instituicaoEnsino;
    private int mesesContrato;
    private boolean bolsaEstudo;
    
    // Construtor
    public Estagiario(String nome, String cpf, double salario, String instituicaoEnsino, 
                     int mesesContrato, boolean bolsaEstudo) {
        super(nome, cpf, salario, "Estagiário");
        this.instituicaoEnsino = instituicaoEnsino;
        this.mesesContrato = mesesContrato;
        this.bolsaEstudo = bolsaEstudo;
    }
    
    // Getters e setters específicos do Estagiario
    public String getInstituicaoEnsino() {
        return instituicaoEnsino;
    }
    
    public void setInstituicaoEnsino(String instituicaoEnsino) {
        this.instituicaoEnsino = instituicaoEnsino;
    }
    
    public int getMesesContrato() {
        return mesesContrato;
    }
    
    public void setMesesContrato(int mesesContrato) {
        this.mesesContrato = mesesContrato;
    }
    
    public boolean isBolsaEstudo() {
        return bolsaEstudo;
    }
    
    public void setBolsaEstudo(boolean bolsaEstudo) {
        this.bolsaEstudo = bolsaEstudo;
    }
    
    // Implementação do método abstrato da classe Funcionario
    @Override
    public double calcularSalarioTotal() {
        return salario + calcularBonus();
    }
    
    // Implementação do método da interface Bonificavel
    @Override
    public double calcularBonus() {
        double bonus = 0;
        
        // Bônus por tempo de contrato (R$ 50 por mês)
        bonus += mesesContrato * 50;
        
        // Bônus adicional se tem bolsa de estudo
        if (bolsaEstudo) {
            bonus += 200; // R$ 200 de bônus por ter bolsa de estudo
        }
        
        // Bônus por performance (baseado no salário)
        bonus += salario * 0.05; // 5% do salário base
        
        return bonus;
    }
    
    // Método específico do Estagiario
    public void estudar() {
        System.out.println("Estagiário " + nome + " está estudando na " + instituicaoEnsino + ".");
    }
    
    // Método para calcular tempo restante de contrato
    public int tempoRestanteContrato() {
        // Assumindo que o contrato padrão é de 12 meses
        return Math.max(0, 12 - mesesContrato);
    }
    
    // Sobrescrita do método exibirInformacoes para incluir dados específicos do Estagiario
    @Override
    public void exibirInformacoes() {
        System.out.println("=== INFORMAÇÕES DO ESTAGIÁRIO ===");
        super.exibirInformacoes();
        System.out.println("Instituição de Ensino: " + instituicaoEnsino);
        System.out.println("Meses de Contrato: " + mesesContrato);
        System.out.println("Tempo Restante: " + tempoRestanteContrato() + " meses");
        System.out.println("Bolsa de Estudo: " + (bolsaEstudo ? "Sim" : "Não"));
        exibirBonus();
        System.out.println("=================================");
    }
}
