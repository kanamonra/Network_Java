public class GameDemo {
    public static void main(String[] args) {
        // setting new user
        Speedy s1 = new Speedy();
        Kana k1 = new Kana();
        Mighty m1 = new Mighty();

        Weapon_items attack = new Weapon_items();
        Boot_item run = new Boot_item();
        Shield_items protect = new Shield_items();
        // Wings wingFly = new Wings();
        Rocket rocketOne = new Rocket();

        s1.setItem(run);
        k1.setItem(attack);
        m1.setItem(run);

        m1.setItem(new Shield_items());
        m1.performItem(protect);
        m1.info();
        k1.info();
        s1.info();
        // k1.startFly(wingFly);


    }
}