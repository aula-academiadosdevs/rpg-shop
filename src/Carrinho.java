import java.util.ArrayList;

public class Carrinho {
    private ArrayList<ItemCarrinho> itens;

    public Carrinho() {
        itens = new ArrayList<ItemCarrinho>();
    }

    public void adicionarItem(Item item, int quantidade) {
        ItemCarrinho itemCarrinho = new ItemCarrinho(item, quantidade);
        itens.add(itemCarrinho);
    }

    public double getTotal() {
        double total = 0;
        for (ItemCarrinho itemCarrinho : itens) {
            double subtotalItem = itemCarrinho.calcularSubtotal();
            total += subtotalItem;
        }

        return total;
    }
    
    public double getTotalComDesconto() {
        // Se a compra passar de 600g, aplique 20% de desconto
        double total = getTotal();

        if (total >= 600) {
            double totalComDesconto = total - (total * 0.2);
            return totalComDesconto;
        }

        
        return total;
    }

}
