import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class poupanca {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Poupex");
        frame.setSize(400, 230);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); 
        frame.getContentPane().setBackground(new Color(255,192,203)); 

        Font fonte = new Font("Arial", Font.PLAIN, 12);

        // Label e campo: Juros
        JLabel labelJuros = new JLabel("Juros ao mês %:");
        labelJuros.setFont(fonte);
        labelJuros.setBounds(20, 20, 120, 25);
        labelJuros.setForeground(Color.DARK_GRAY);

        JTextField campoJuros = new JTextField();
        campoJuros.setBounds(150, 20, 200, 25);
        campoJuros.setBackground(Color.WHITE);
        campoJuros.setForeground(Color.BLACK); 

        // Label e campo: Anos
        JLabel labelAnos = new JLabel("Num. de anos:");
        labelAnos.setFont(fonte);
        labelAnos.setBounds(20, 55, 120, 25);
        labelAnos.setForeground(Color.DARK_GRAY);

        JTextField campoAnos = new JTextField();
        campoAnos.setBounds(150, 55, 200, 25);
        campoAnos.setBackground(Color.WHITE);

        // Label e campo: Depósito
        JLabel labelDeposito = new JLabel("Depósito mensal R$:");
        labelDeposito.setFont(fonte);
        labelDeposito.setBounds(20, 90, 130, 25);
        labelDeposito.setForeground(Color.DARK_GRAY);

        JTextField campoDeposito = new JTextField();
        campoDeposito.setBounds(150, 90, 200, 25);
        campoDeposito.setBackground(Color.WHITE);

        // Label e resultado
        JLabel labelResultado = new JLabel("Total poupado R$:");
        labelResultado.setFont(fonte);
        labelResultado.setBounds(20, 125, 120, 25);
        labelResultado.setForeground(Color.DARK_GRAY);

        JLabel campoResultado = new JLabel("0.00");
        campoResultado.setFont(fonte);
        campoResultado.setBounds(150, 125, 200, 25);
        campoResultado.setForeground(Color.BLACK);

        // Botão
        JButton button = new JButton("OK");
        button.setFont(fonte);
        button.setBounds(150, 160, 80, 30);
        button.setBackground(new Color(255,105,180)); 
        button.setForeground(Color.WHITE); // 

        // Ação do botão
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double juros = Double.parseDouble(campoJuros.getText()) / 100.0;
                    int anos = Integer.parseInt(campoAnos.getText());
                    double deposito = Double.parseDouble(campoDeposito.getText());

                    int meses = anos * 12;
                    double total = 0.0;

                    for (int i = 0; i < meses; i++) {
                        total = (total + deposito) * (1 + juros);
                    }

                    campoResultado.setText(String.format("%.2f", total));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erro: preencha tudo certo.");
                }
            }
        });

        frame.add(labelJuros);
        frame.add(campoJuros);
        frame.add(labelAnos);
        frame.add(campoAnos);
        frame.add(labelDeposito);
        frame.add(campoDeposito);
        frame.add(labelResultado);
        frame.add(campoResultado);
        frame.add(button);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
