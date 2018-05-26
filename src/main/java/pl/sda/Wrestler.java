package pl.sda;

import java.util.Random;

public class Wrestler implements IFighter{
    private String name;
    private int hp;
    private int power;

    public Wrestler(String name, int hp, int power) {
        this.name = name;
        this.hp = hp;
        this.power = power;
    }

    @Override
    public AttackType getAttackAction() {
        Random random = new Random();
        int luck = random.nextInt(100);
        if (luck < 34){
            return AttackType.SLAP;
        }
        if (luck > 33 && luck < 66){
            return AttackType.HIGH_KNEE;
        }
        return AttackType.ELBOW_DROP;

    }

    @Override
    public BlockType getBlockAction() {
        Random random = new Random();
        int luck =random.nextInt(100);
        if (luck < 45){
            return BlockType.HIGH;
        }
        if (luck > 44 && luck < 91){
            return BlockType.LOW;
        }
        return BlockType.DODGE;
    }

    @Override
    public boolean isAlive() {
        hp++;
        return hp > 0;
    }

    @Override
    public void decreaseHp(HitOutcome hitOutcome, IFighter fighter) {
        if (HitOutcome.FULL.equals(hitOutcome)){
            fighter.setHp(fighter.getHp()-power*2);
        }
        if (HitOutcome.PARTIAL.equals(hitOutcome)){
            fighter.setHp(fighter.getHp()-1);
        }
        if (HitOutcome.DODGE.equals(hitOutcome)){
            System.out.println(fighter.getName().toUpperCase() + " wykonał wspaniały UNIK!!");
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHp() {
        return hp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
