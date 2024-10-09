public class Calculadora {
 
    public double somar(double num1, double num2) {
        return num1 + num2;
    }
 
    public double subtrair(double num1, double num2) {
        return num1 - num2;
    }
 
    public double multiplicar(double num1, double num2) {
        return num1 * num2;
    }
 
    public double dividir(double num1, double num2) throws IllegalArgumentException {
        if (num2 == 0) {
            throw new IllegalArgumentException("Erro: Divisão por zero não permitida.");
        }
        return num1 / num2;
    }
}