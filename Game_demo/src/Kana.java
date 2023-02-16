public class Kana extends Character{
    public Kana(){
        hp = 300;
        mp = 800;
    }

    @Override
    void info() {
        System.out.println("Hero: Ceceg\nHP: " + hp + "\n" + "Mana: " + mp);
    }
}
