package pl.sda;

public interface IFight {
    void fight();
    default void showFightStatus(IFighter first, IFighter second) {
        System.out.println("----------------------------------------");
        System.out.println( first.getName() + "[" + first.getHp() + "]  VS.  " + second.getName() + "[" + second.getHp() + "]");
        System.out.println("----------------------------------------");
    }
}
