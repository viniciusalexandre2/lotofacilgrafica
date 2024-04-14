import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class LotoFacil {

    private static char letraPremiada = 'V'; // Letra premiada
    private static Random random = new Random();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("LOTOFÁCIL");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("Menu LOTOFÁCIL:");
        panel.add(label);

        JButton button1 = new JButton("faça uma aposta de 0 a 100.");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarDe0a100();
            }
        });
        panel.add(button1);

        JButton button2 = new JButton("faça uma apostar de A à Z.");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarDeAaZ();
            }
        });
        panel.add(button2);

        JButton button3 = new JButton("selecione um numero par ou ímpar.");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apostarParOuImpar();
            }
        });
        panel.add(button3);

        JButton buttonExit = new JButton("Sair");
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(buttonExit);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static void apostarDe0a100() {
        int numeroEscolhido = Integer.parseInt(JOptionPane.showInputDialog("Digite um número de 0 a 100: "));
        if (numeroEscolhido < 0 || numeroEscolhido > 100) {
            JOptionPane.showMessageDialog(null, "Aposta inválida.");
        } else {
            int numeroSorteado = random.nextInt(101);
            if (numeroEscolhido == numeroSorteado) {
                JOptionPane.showMessageDialog(null, "Você ganhou R$ 1.000,00 reais.");
            } else {
                JOptionPane.showMessageDialog(null, "Que pena! O número sorteado foi: " + numeroSorteado);
            }
        }
    }

    private static void apostarDeAaZ() {
        String letraInput = JOptionPane.showInputDialog("Digite uma letra de A à Z: ");
        char letraEscolhida = letraInput.toUpperCase().charAt(0);
        if (Character.isLetter(letraEscolhida)) {
            if (letraEscolhida == letraPremiada) {
                JOptionPane.showMessageDialog(null, "Você ganhou R$ 500,00 reais.");
            } else {
                JOptionPane.showMessageDialog(null, "Que pena! A letra sorteada foi: " + letraPremiada);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Aposta inválida.");
        }
    }

    private static void apostarParOuImpar() {
        int numeroDigitado = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro: "));
        if (numeroDigitado % 2 == 0) {
            JOptionPane.showMessageDialog(null, "Você ganhou R$ 100,00 reais.");
        } else {
            JOptionPane.showMessageDialog(null, "Que pena! O número digitado é ímpar e a premiação foi para números pares.");
        }
    }
}

