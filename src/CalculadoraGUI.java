import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
public class CalculadoraGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora Simples");
        frame.setSize(300, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
 
        JTextField textField = new JTextField();
        textField.setBounds(30, 30, 230, 40);
        frame.add(textField);
 
        JButton[] numButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
        }
 
        numButtons[1].setBounds(30, 90, 50, 50);
        numButtons[2].setBounds(90, 90, 50, 50);
        numButtons[3].setBounds(150, 90, 50, 50);
        numButtons[4].setBounds(30, 150, 50, 50);
        numButtons[5].setBounds(90, 150, 50, 50);
        numButtons[6].setBounds(150, 150, 50, 50);
        numButtons[7].setBounds(30, 210, 50, 50);
        numButtons[8].setBounds(90, 210, 50, 50);
        numButtons[9].setBounds(150, 210, 50, 50);
        numButtons[0].setBounds(90, 270, 50, 50);
 
        for (int i = 0; i < 10; i++) {
            frame.add(numButtons[i]);
        }
 
        JButton btnAdd = new JButton("+");
        JButton btnSub = new JButton("-");
        JButton btnMul = new JButton("*");
        JButton btnDiv = new JButton("/");
 
        JButton btnEquals = new JButton("=");
        JButton btnClear = new JButton("C");
 
        btnAdd.setBounds(210, 90, 50, 50);
        btnSub.setBounds(210, 150, 50, 50);
        btnMul.setBounds(210, 210, 50, 50);
        btnDiv.setBounds(210, 270, 50, 50);
        btnEquals.setBounds(30, 330, 110, 50);
        btnClear.setBounds(150, 330, 110, 50);
 
        frame.add(btnAdd);
        frame.add(btnSub);
        frame.add(btnMul);
        frame.add(btnDiv);
        frame.add(btnEquals);
        frame.add(btnClear);
 
        final StringBuilder expression = new StringBuilder();
        final double[] num1 = {0};
        final double[] num2 = {0};
        final char[] operator = { ' ' };
 
        for (int i = 0; i < 10; i++) {
            final int num = i;
            numButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + num);
                }
            });
        }
 
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1[0] = Double.parseDouble(textField.getText());
                operator[0] = '+';
                expression.append(textField.getText()).append(" + ");
                textField.setText("");
            }
        });
 
        btnSub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1[0] = Double.parseDouble(textField.getText());
                operator[0] = '-';
                expression.append(textField.getText()).append(" - ");
                textField.setText("");
            }
        });
 
        btnMul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1[0] = Double.parseDouble(textField.getText());
                operator[0] = '*';
                expression.append(textField.getText()).append(" * ");
                textField.setText("");
            }
        });
 
        btnDiv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num1[0] = Double.parseDouble(textField.getText());
                operator[0] = '/';
                expression.append(textField.getText()).append(" / ");
                textField.setText("");
            }
        });
 
        // Botão para calcular o resultado
        btnEquals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                num2[0] = Double.parseDouble(textField.getText());
                double resultado = 0;
 
                switch (operator[0]) {
                    case '+':
                        resultado = num1[0] + num2[0];
                        break;
                    case '-':
                        resultado = num1[0] - num2[0];
                        break;
                    case '*':
                        resultado = num1[0] * num2[0];
                        break;
                    case '/':
                        if (num2[0] != 0) {
                            resultado = num1[0] / num2[0];
                        } else {
                            JOptionPane.showMessageDialog(frame, "Erro: Divisão por zero não permitida.");
                            return;
                        }
                        break;
                }
                // Exibe apenas o resultado
                textField.setText(String.valueOf(resultado));
                expression.setLength(0); // Limpa a expressão após o cálculo
            }
        });
 
        // Botão para limpar o campo de texto
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                expression.setLength(0); // Limpa a expressão também
            }
        });
 
        // Exibir a janela
        frame.setVisible(true);
    }
}
 
 