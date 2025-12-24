public class ItemCarrinho {
    private Item item;
    private int quantidade;

    public ItemCarrinho(Item item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }

    // Subtotal -> valor do item X quantidade
    // valor (double) * quantidade (inteiro) 
    public double calcularSubtotal() {
        double subtotal = item.getValor() * quantidade;
        return subtotal;
    }
}
