public class Mighty extends Character{
    public Mighty(){
        hp = 1000;
        mp = 400;
    }


    @Override
    void info() {
        System.out.println("Hero: Mike\nHP: " +hp + "\n" + "MP:" + mp);
    }
}
