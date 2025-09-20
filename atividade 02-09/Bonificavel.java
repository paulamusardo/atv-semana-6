public interface Bonificavel {
    /**
     * Método que calcula o bônus do funcionário
     * @return valor do bônus calculado
     */
    double calcularBonus();
    
    /**
     * Método que aplica o bônus ao salário
     * @return salário com bônus aplicado
     */
    default double aplicarBonus() {
        return calcularBonus();
    }
    
    /**
     * Método que exibe informações sobre o bônus
     */
    default void exibirBonus() {
        System.out.println("Bônus calculado: R$ " + String.format("%.2f", calcularBonus()));
    }
}
