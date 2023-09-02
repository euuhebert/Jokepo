package jogo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PPT {
	
	private static int contUser = 0;
    private static int contCPU = 0;

	
    public static void main(String[] args) {
    	
    	
        
        JFrame frame = new JFrame("Pedra, Papel ou Tesoura");
        JPanel panel = new JPanel();

        String options[] = {"Pedra", "Papel", "Tesoura"};

        // Cria os objetos no programa
        JLabel jogador = new JLabel("Usuário: ");
        JLabel cpu = new JLabel("CPU: ");
        JLabel pointPlayer = new JLabel();
        JLabel pointCPU = new JLabel();
        JComboBox<String> escolha = new JComboBox<>(options);
        JButton jogarButton = new JButton("JOGAR");
        JLabel label = new JLabel("Escolha:");
        JLabel computadorLabel = new JLabel("O computador escolheu: ");
        JLabel logic = new JLabel();

        // Define as configurações do frame
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Adiciona ação ao botão "JOGAR"
        jogarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int escolhaIndex = escolha.getSelectedIndex();
                

                String[] choices = {"Pedra", "Papel", "Tesoura"};
                int computerChoiceIndex = generateRandomIndex(choices.length);
                String computerChoice = choices[computerChoiceIndex];

                computadorLabel.setText("O computador escolheu: " + computerChoice);
                
                if (escolhaIndex == computerChoiceIndex) {
                    logic.setText("Empatou");
                } else if (escolhaIndex == 0 && computerChoiceIndex == 1) {
                    logic.setText("Você perdeu!");
                    contCPU += 1;
                } else if (escolhaIndex == 0 && computerChoiceIndex == 2) {
                    logic.setText("Você ganhou!");
                    contUser += 1;
                } else if (escolhaIndex == 1 && computerChoiceIndex == 0) {
                    logic.setText("Você ganhou!");
                    contUser += 1;
                } else if (escolhaIndex == 1 && computerChoiceIndex == 2) {
                    logic.setText("Você perdeu!");
                    contCPU += 1;
                } else if (escolhaIndex == 2 && computerChoiceIndex == 0) {
                    logic.setText("Você perdeu!");
                    contCPU += 1;
                } else if (escolhaIndex == 2 && computerChoiceIndex == 1) {
                    logic.setText("Você ganhou!");
                    contUser += 1;
                }

                pointPlayer.setText(String.valueOf(contUser));
                pointCPU.setText(String.valueOf(contCPU));
                
                if (contUser ==10 || contCPU ==10) {
                	String winnerMessage;
                	if (contUser ==10) {
                		winnerMessage = "Usuário Ganhou!";
                	} else {
                		winnerMessage = "CPU Ganhou!";
                	}
                	
                	 JOptionPane.showMessageDialog(null, winnerMessage, "Resultado Final", JOptionPane.INFORMATION_MESSAGE);
                	 contUser = 0;
                	 contCPU = 0;
                	 pointPlayer.setText("0");
                	 pointCPU.setText("0");
                }
            }
        });

        // Define layout 
        panel.setLayout(null);
        jogador.setBounds(0, 0, 100, 30);
        cpu.setBounds(0, 20, 100, 30);
        pointPlayer.setBounds(50, 0, 20, 30);
        pointCPU.setBounds(50, 20, 20, 30);
        label.setBounds(310, 70, 100, 30);
        escolha.setBounds(380, 70, 100, 30);
        jogarButton.setBounds(280, 200, 250, 70);
        computadorLabel.setBounds(280, 150, 300, 30);
        logic.setBounds(370, 300, 100, 50);

        panel.add(jogador);
        panel.add(pointPlayer);
        panel.add(cpu);
        panel.add(pointCPU);
        panel.add(label);
        panel.add(escolha);
        panel.add(jogarButton);
        panel.add(computadorLabel);
        panel.add(logic);

        // Adiciona o painel ao frame
        frame.add(panel);
        frame.setVisible(true);
    }

    private static int generateRandomIndex(int maxIndex) {
        Random random = new Random();
        return random.nextInt(maxIndex);
    }
}