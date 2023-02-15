public abstract class Character {
    protected int hp;
    protected int mp;
    // others things you can add
    Items item ; // Association <Aggregation>

    abstract void info();


    public void setItem(Items item) {
        this.item = item;
    }

    public final void performItem(){
        item.useItem();
    }

}
