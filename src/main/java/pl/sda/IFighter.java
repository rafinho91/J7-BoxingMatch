package pl.sda;

public interface IFighter {
    String getName();
    int getHp();

    AttackType getAttackAction();
    BlockType getBlockAction();

    boolean isAlive();
    void decreaseHp(HitOutcome hitOutcome, IFighter fighter);
    void setHp(int Hp);
}
