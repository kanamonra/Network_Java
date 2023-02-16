public class Speedy extends Character{

    public Speedy(){
        hp = 300;
        mp = 800;
    }


    @Override
    void info() {
        System.out.println("Hero: Fill\nHP: " + hp + "\n" + "Mana: " + mp);
    }
}
