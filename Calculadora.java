import java.util.Stack;

public class Calculadora {
    private static Calculadora instance;

    private Calculadora() {}

    public static synchronized Calculadora getInstance() {
        if (instance == null) {
            instance = new Calculadora();
        }
        return instance;
    }

    public int evaluarPostfix(String expresion) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
    
            if (Character.isDigit(c)) {
                stack.push(c - '0'); // Convierte el char a int y lo apila
            } else {
                int val1 = stack.pop();
                int val2 = stack.pop();
    
                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                }
            }
        }
        return stack.pop(); // Retorna el resultado final
    }
    

    public String convertirInfixAPostfix(String expresion) {
        String resultado = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expresion.length(); ++i) {
            char c = expresion.charAt(i);

            // Si el carácter es un operando, añádelo al resultado
            if (Character.isLetterOrDigit(c)) {
                resultado += c;
            } 
            // Si es un paréntesis izquierdo, apílalo
            else if (c == '(') {
                stack.push(c);
            } 
            // Si es un paréntesis derecho, desapila hasta encontrar el paréntesis izquierdo
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    resultado += stack.pop();
                stack.pop();
            } 
            // Un operador es encontrado
            else {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
                    resultado += stack.pop();
                }
                stack.push(c);
            }
        }

        // Desapila todos los operadores restantes
        while (!stack.isEmpty()) {
            if(stack.peek() == '(')
                return "Expresión Inválida";
            resultado += stack.pop();
        }
        return resultado;
    }

    // Método para retornar la precedencia de los operadores
    static int Prec(char ch) {
        switch (ch) {
        case '+':
        case '-':
            return 1;

        case '*':
        case '/':
            return 2;
        }
        return -1;
    }
}
