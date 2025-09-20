import java.util.ArrayList;
import java.util.List;

public class SistemaGerenciamentoFuncionarios {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GERENCIAMENTO DE FUNCIONÁRIOS ===");
        System.out.println();
        
        // Criando uma lista polimórfica de funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        
        // Criando objetos de diferentes tipos
        Gerente gerente1 = new Gerente("Ana Silva", "123.456.789-00", 8000.0, 5);
        Gerente gerente2 = new Gerente("Carlos Santos", "987.654.321-00", 9500.0, 8);
        
        Estagiario estagiario1 = new Estagiario("Maria Oliveira", "456.789.123-00", 1200.0, 
                                               "Universidade Federal", 3, true);
        Estagiario estagiario2 = new Estagiario("João Pereira", "789.123.456-00", 1000.0, 
                                               "Instituto Tecnológico", 6, false);
        
        // Adicionando funcionários à lista polimórfica
        funcionarios.add(gerente1);
        funcionarios.add(gerente2);
        funcionarios.add(estagiario1);
        funcionarios.add(estagiario2);
        
        // DEMONSTRAÇÃO DE POLIMORFISMO
        System.out.println("1. DEMONSTRAÇÃO DE POLIMORFISMO - Método exibirInformacoes():");
        System.out.println("================================================================");
        
        // Polimorfismo: chamando o mesmo método em objetos de tipos diferentes
        for (Funcionario funcionario : funcionarios) {
            funcionario.exibirInformacoes();
        }
        
        System.out.println("\n2. DEMONSTRAÇÃO DE POLIMORFISMO - Método calcularSalarioTotal():");
        System.out.println("==================================================================");
        
        // Polimorfismo: calculando salário total para diferentes tipos de funcionário
        double totalSalarios = 0;
        for (Funcionario funcionario : funcionarios) {
            double salarioTotal = funcionario.calcularSalarioTotal();
            System.out.println(funcionario.getNome() + " (" + funcionario.getCargo() + 
                             "): R$ " + String.format("%.2f", salarioTotal));
            totalSalarios += salarioTotal;
        }
        
        System.out.println("\nTOTAL DE SALÁRIOS DA EMPRESA: R$ " + String.format("%.2f", totalSalarios));
        
        System.out.println("\n3. DEMONSTRAÇÃO DE POLIMORFISMO - Interface Bonificavel:");
        System.out.println("=========================================================");
        
        // Polimorfismo com interface: todos os funcionários implementam Bonificavel
        List<Bonificavel> funcionariosBonificaveis = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Bonificavel) {
                funcionariosBonificaveis.add((Bonificavel) funcionario);
            }
        }
        
        double totalBonus = 0;
        for (Bonificavel bonificavel : funcionariosBonificaveis) {
            double bonus = bonificavel.calcularBonus();
            System.out.println("Bônus calculado: R$ " + String.format("%.2f", bonus));
            totalBonus += bonus;
        }
        
        System.out.println("\nTOTAL DE BÔNUS DA EMPRESA: R$ " + String.format("%.2f", totalBonus));
        
        System.out.println("\n4. MÉTODOS ESPECÍFICOS DAS CLASSES FILHAS:");
        System.out.println("==========================================");
        
        // Chamando métodos específicos de cada tipo
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Gerente) {
                Gerente gerente = (Gerente) funcionario;
                gerente.gerenciarEquipe();
            } else if (funcionario instanceof Estagiario) {
                Estagiario estagiario = (Estagiario) funcionario;
                estagiario.estudar();
            }
        }
        
        System.out.println("\n5. RELATÓRIO FINANCEIRO DA EMPRESA:");
        System.out.println("====================================");
        gerarRelatorioFinanceiro(funcionarios);
        
        System.out.println("\n=== FIM DO SISTEMA ===");
    }
    
    // Método que demonstra polimorfismo em uma função auxiliar
    public static void gerarRelatorioFinanceiro(List<Funcionario> funcionarios) {
        double totalSalariosBase = 0;
        double totalBonus = 0;
        double totalSalariosComBonus = 0;
        int quantidadeGerentes = 0;
        int quantidadeEstagiarios = 0;
        
        for (Funcionario funcionario : funcionarios) {
            totalSalariosBase += funcionario.getSalario();
            totalSalariosComBonus += funcionario.calcularSalarioTotal();
            
            if (funcionario instanceof Bonificavel) {
                Bonificavel bonificavel = (Bonificavel) funcionario;
                totalBonus += bonificavel.calcularBonus();
            }
            
            if (funcionario instanceof Gerente) {
                quantidadeGerentes++;
            } else if (funcionario instanceof Estagiario) {
                quantidadeEstagiarios++;
            }
        }
        
        System.out.println("Quantidade de Gerentes: " + quantidadeGerentes);
        System.out.println("Quantidade de Estagiários: " + quantidadeEstagiarios);
        System.out.println("Total de Salários Base: R$ " + String.format("%.2f", totalSalariosBase));
        System.out.println("Total de Bônus: R$ " + String.format("%.2f", totalBonus));
        System.out.println("Total de Salários com Bônus: R$ " + String.format("%.2f", totalSalariosComBonus));
        System.out.println("Economia com Bônus vs Salários Fixos: R$ " + 
                          String.format("%.2f", (totalSalariosComBonus - totalSalariosBase)));
    }
}
