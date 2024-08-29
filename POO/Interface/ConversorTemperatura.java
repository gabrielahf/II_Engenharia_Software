public interface ConversorTemperatura {
    /**
     * Retorna o nome da escala de origem
     * @return nome da escala de origem
     */
    public String nomeOrigem();

    /**
     * Retorna o nome da escala de destino
     * @return nome da escala de destino
     */
    public String nomeDestino();

    /**
     * Retorna o simbolo da escala de origem
     * @return simbolo da escala de origem
     */
    public char simboloOrigem();

    /**
     * Retorna o simbolo da escala de destino
     * @return simbolo da escala de destino
     */
    public char simboloDestino();

    /**
     * Converte a temperatura de origem na temperatura de destino
     * @param temperatura temperatura de origem
     * @return temperatura convertida
     */
    public double converteTemperatura(double temperatura);

}
