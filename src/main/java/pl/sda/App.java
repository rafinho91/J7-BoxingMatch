package pl.sda;

public class App {
    public static void main(String[] args) {

        IFighter fighter1 = new Boxer("Andrzej Gołota", 35, 4);
        IFighter fighter2 = new Boxer("Mike Tyson", 28, 6);
        IFighter fighter3 = new Wrestler("Hulk Hogan", 20, 4);

        IFight fight = new BoxingMatch(fighter1, fighter2);
//        IFight fight = new MmaMatch(fighter1, fighter3);
        fight.fight();
    }
}
