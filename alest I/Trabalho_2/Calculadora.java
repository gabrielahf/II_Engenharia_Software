import java.util.EmptyStackException;
import java.util.List;

public class Calculadora {
    private Pilha operadorPilha;
    private Pilha valorPilha;
    private String errorMsg;
    private int tamMax;

    public Calculadora() {
        this.operadorPilha = new Pilha();
        this.valorPilha = new Pilha();
        this.errorMsg = null;
        this.tamMax = 0;
    }

    // Verifica se o caractere é um operador
    private boolean isOperator(char op) {
        return op == '+' || op == '-' || op == '*' || op == '/' || op == '^';
    }

    // Verifica ABERTURA do par
    private boolean isOpen(char abre) {
        return abre == '(' || abre == '[' || abre == '{';
    }

    // Verifica FECHAMENTO do par
    private boolean isClose(char fecha) {
        return fecha == ')' || fecha == ']' || fecha == '}';
    }

    // Método para identificar a ordem correta das operações conforme prioridade dos cálculos
    private int prioridadeOperador(char ch) {
        switch (ch) {
            case '{':
            case '}':
                return 6;
            case '[':
            case ']':
                return 5;
            case '(':
            case ')':
                return 4;
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;
        }
    }

    // Método para realizar as operações matemáticas entre dois operandos
    private void processarOperador(int operador) {
        double op1, op2;

        try {
            op1 = valorPilha.pop();
            op2 = valorPilha.pop();
        } catch (EmptyStackException e) {
            errorMsg = "Erro de sintaxe: Operador com operandos insuficientes.";
            return;
        }

        double resultado = 0;
        switch (operador) {
            case '+':
                resultado = op2 + op1;
                break;
            case '-':
                resultado = op2 - op1;
                break;
            case '*':
                resultado = op2 * op1;
                break;
            case '^':
                resultado = Math.pow(op2, op1);
                break;
            case '/':
                if (op1 == 0) { // divisão por zero
                    errorMsg = "Divisão por zero.";
                    return;
                } else {
                    resultado = op2 / op1;
                }
                break;
            default:
                errorMsg = "Operador inválido.";
                return;
        }
        valorPilha.push(resultado);
        tamMax = Math.max(tamMax, (valorPilha.size() + 1) + (operadorPilha.size() + 1));
    }

    // Método para verificar erros de sintaxe na expressão
    private boolean verificarErros(String input) {
        Pilha pilha = new Pilha();
        for (char ch : input.toCharArray()) {
            if (isOpen(ch)) {
                pilha.push(ch);
            } else if (isClose(ch)) {
                if (pilha.isEmpty()) {
                    errorMsg = "Erro de sintaxe: '" + ch + "' não possui o par de abertura.";
                    return false;
                }
                char topo = (char) pilha.pop();
                if ((ch == ')' && topo != '(') || (ch == '}' && topo != '{') || (ch == ']' && topo != '[')) {
                    errorMsg = "Erro de sintaxe: '" + topo + "' não possui o par correspondente.";
                    return false;
                }
            } else if (!isOperator(ch) && !Character.isDigit(ch) && !Character.isWhitespace(ch)) {
                errorMsg = "Erro de sintaxe: caractere inválido '" + ch + "'.";
                return false;
            }
        }
        if (!pilha.isEmpty()) {
            errorMsg = "Erro de sintaxe: há parênteses, chaves ou colchetes sem o par de fechamento.";
            return false;
        }
        return true;
    }

    // Calcular a equação
    public void calcularEquacao(String input) {
        String[] tokens = input.split(" ");
        for (String token : tokens) {
            if (errorMsg != null) {
                break; // Para quando já tiver detectado um erro
            }
            try {
                int num = Integer.parseInt(token);
                valorPilha.push((double) num);
            } catch (NumberFormatException e) {
                char ch = token.charAt(0);
                if (isOperator(ch)) {
                    while (!operadorPilha.isEmpty() && !isOpen((char) operadorPilha.top())
                            && prioridadeOperador(ch) <= prioridadeOperador((char) operadorPilha.top())) {
                        processarOperador((int) operadorPilha.pop());
                        if (errorMsg != null) {
                            return; // Para a execução se um erro for detectado
                        }
                    }
                    operadorPilha.push(ch);
                } else if (isOpen(ch)) {
                    operadorPilha.push(ch);
                } else if (isClose(ch)) {
                    while (!operadorPilha.isEmpty() && !isOpen((char) operadorPilha.top())) {
                        processarOperador((int) operadorPilha.pop());
                        if (errorMsg != null) {
                            return;
                        }
                    }
                    if (!operadorPilha.isEmpty() && isOpen((char) operadorPilha.top())) {
                        operadorPilha.pop();
                    } else {
                        errorMsg = "Expressão desbalanceada.";
                    }
                }
            }
        }
        while (!operadorPilha.isEmpty() && !isOpen((char) operadorPilha.top())) {
            processarOperador((int) operadorPilha.pop());
            if (errorMsg != null) {
                return; // Para quando já tiver detectado um erro
            }
        }
    }

    // Processar uma lista de expressões
    public void processExpressoes(List<String> expressoes) {
        for (String expressao : expressoes) {
            errorMsg = null; // Limpa o erro para a próxima expressão
            
            if (verificarErros(expressao)) {
                calcularEquacao(expressao);
                System.out.println("Expressão: " + expressao);
                if (errorMsg == null) {
                    // Se não houver erro de sintaxe, exibe o resultado e o tamanho da pilha
                    System.out.println("Resultado: " + valorPilha.top());
                    System.out.println("Tamanho máximo da pilha: " + tamMax);
                } else {
                    // Se houver erro durante o cálculo, exibe a mensagem de erro
                    System.out.println(errorMsg);
                }
            } else {
                // Se houver erro de sintaxe, exibe a mensagem de erro
                System.out.println("Expressão: " + expressao);
                System.out.println(errorMsg);
            }
            System.out.println();
            
            // Limpa os estados para a próxima expressão
            valorPilha.clear();
            operadorPilha.clear();
            tamMax = 0;
        }
    }
}