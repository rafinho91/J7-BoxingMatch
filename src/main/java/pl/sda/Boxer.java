package pl.sda;

import java.util.Random;

public class Boxer implements IFighter{
    private String name;
    private int hp;
    private int experience;

    public Boxer(String name, int hp, int experience) {
        this.name = name;
        this.hp = hp;
        this.experience = experience;
    }

    @Override
    public AttackType getAttackAction() {
        Random random = new Random();
        int luck = random.nextInt(100);
        if (luck < 34){
            return AttackType.HOOK;
        }
        if (luck > 33 && luck < 66){
            return AttackType.JAB;
        }
        return AttackType.UPPERCUT;
    }

    @Override
    public BlockType getBlockAction() {
        Random random = new Random();
        int luck =random.nextInt(100) + this.experience;
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
        return hp > 0;
    }

    @Override
    public void decreaseHp(HitOutcome hitOutcome, IFighter fighter) {
        if (HitOutcome.FULL.equals(hitOutcome)){
            fighter.setHp(fighter.getHp()-experience);
        }
        if (HitOutcome.PARTIAL.equals(hitOutcome)){
            fighter.setHp(fighter.getHp()-1);
        }
        if (HitOutcome.DODGE.equals(hitOutcome)){
            System.out.println(fighter.getName().toUpperCase() + " wykonał wspaniały UNIK!!");
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
