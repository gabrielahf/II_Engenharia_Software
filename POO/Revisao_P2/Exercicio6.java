
//O trecho de código a seguir é válido? Argumente a sua resposta.

    Jogador j = new Jogador(Origem.NACIONAL,1000) { // a classe jogador é abstrata
        @Override
        public double calculaImposto() {
            return 500; // não está efetuando o calculo
        }
    };

//versão correta
    Jogador j = new Jogador(Origem.NACIONAL,1000) {
        public double calculaImposto() {
            switch (origem) {
                case NACIONAL:
                    return salario * 0.25;
                case INTERNACIONAL:
                    return salario * 0.5;
                default:
                    throw new IllegalArgumentException("Origem de imposto inválida: " + origem);
            }
        }
    };

