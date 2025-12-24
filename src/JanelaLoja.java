import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JanelaLoja {
    private JFrame janela;
    private JButton botaoPocao;
    private JButton botaoEspada;
    private JButton botaoArmadura;
    private Carrinho carrinho;
    private JLabel labelValorTotal;
    private JLabel labelValorTotalDesconto;
    private static final int LARGURA_JANELA = 480;
    private static final int ALTURA_JANELA = 220;
    private static final int LARGURA_BOTAO = 200;
    private static final int ALTURA_BOTAO = 30;

    public JanelaLoja() {
        carrinho = new Carrinho();
        janela = new JFrame("Loja de Itens");

        janela.setSize(LARGURA_JANELA, ALTURA_JANELA);
        janela.setLayout(null);

        botaoPocao = new JButton("Poção de Vida (50G)");
        botaoPocao.setBounds(20, 20, LARGURA_BOTAO, ALTURA_BOTAO);
        janela.add(botaoPocao);

        botaoEspada = new JButton("Espada de Ferro (300G)");
        botaoEspada.setBounds(20, 60, LARGURA_BOTAO, ALTURA_BOTAO);
        janela.add(botaoEspada);

        botaoArmadura = new JButton("Armadura Leve (450G)");
        botaoArmadura.setBounds(20, 100, LARGURA_BOTAO, ALTURA_BOTAO);
        janela.add(botaoArmadura);

        JLabel labelTotal = new JLabel("Total: ");
        labelTotal.setBounds(240, 40, 120, 30);
        janela.add(labelTotal);

        labelValorTotal = new JLabel("0G");
        labelValorTotal.setBounds(370, 40, 120, 30);
        janela.add(labelValorTotal);

        JLabel labelTotalComDesconto = new JLabel("Total c/ desc.: ");
        labelTotalComDesconto.setBounds(240, 100, 120, 30);
        janela.add(labelTotalComDesconto);

        labelValorTotalDesconto = new JLabel("0G");
        labelValorTotalDesconto.setBounds(370, 100, 120, 30);
        janela.add(labelValorTotalDesconto);
        // botao 1
        // botao 2
        // Poção de Vida - 50g
        // Espada de Ferro - 300g
        // Armadura Leve - 450g
       
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        criarEventos();
    }

    private void criarEventos() {
        Item pocao = new Item("Poção", 50);
        Item espada = new Item("Espada de Ferro", 300);
        Item armadura = new Item("Armadura Leve", 450);

        // Eventos de clique de cada botão da janela
        botaoPocao.addActionListener(e -> {
            carrinho.adicionarItem(pocao, 1);
            atualizarTotais();
        });

        botaoEspada.addActionListener(e -> {
            carrinho.adicionarItem(espada, 1);
            atualizarTotais();
        });

        botaoArmadura.addActionListener(e -> {
            carrinho.adicionarItem(armadura, 1);
            atualizarTotais();
        });
    }

    public void atualizarTotais() {
        double total = carrinho.getTotal();
        double totalDesconto = carrinho.getTotalComDesconto();
        // 250 + "G" = "250G"
        String totalString = String.format("%.0fG", total);
        labelValorTotal.setText(totalString);

        String totalDescontoString = String.format("%.0fG", totalDesconto);
        labelValorTotalDesconto.setText(totalDescontoString); 
        
        // Chamar o total, e atualizar na janela o valor dele
        // Chamar o total com desconto, e atualizar o valor dele na janela
    }

    public void mostrarJanela() {
        janela.setVisible(true);
    }
}
