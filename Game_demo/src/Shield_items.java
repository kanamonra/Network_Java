public class Shield_items implements Items{
    @Override
    public void useItem() {
        System.out.println("HP has increased by 30% <If the hero is tank then +50%>");
    }
}
