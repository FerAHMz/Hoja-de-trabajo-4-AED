import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Calculadora calculadora = Calculadora.getInstance(); // Singleton

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            UVGStack<?> stack = null;
            while (stack == null) {
                System.out.println("Seleccione el tipo de pila a utilizar (arrayList, vector, linkedList):");
                String stackType = scanner.nextLine();
                try {
                    stack = StackFactory.getStack(stackType);
                } catch (IllegalArgumentException e) {
                    System.out.println("Tipo de pila no reconocido. Por favor, elija uno de 'arrayList', 'vector', o 'linkedList'.");
                }
            }
            
            // Ya no se solicita el nombre del archivo, se usa "datos.txt" directamente
            leerYEvaluarExpresiones("datos.txt");
        }
    }

    private static void leerYEvaluarExpresiones(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    // Convierte la expresión de infix a postfix
                    String expresionPostfix = calculadora.convertirInfixAPostfix(line);
                    // Evalúa la expresión postfix
                    int resultado = calculadora.evaluarPostfix(expresionPostfix);
                    System.out.println("El resultado de evaluar '" + line + "' es: " + resultado);
                } catch (ArithmeticException e) {
                    System.err.println("Error matemático en la expresión: " + line + " - " + e.getMessage());
                } catch (Exception e) {
                    System.err.println("Error al procesar la expresión: " + line + " - " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }   
}
