public abstract class Character {
    protected int hp;
    protected int mp;
    // others things you can add
    Items item ; // Association <Aggregation>
    FlyBehavior fly;
    abstract void info();


    public void setItem(Items item) {
        this.item = item;
    }
    public void chooseFly(FlyBehavior fly){
        this.fly = fly;
    }
    public final void startFly(){
        fly.fly();
    }

    public final void performItem(Shield_items protect){
        item.useItem();
    }

}
