package pl.sda;

import java.util.Random;

public class MmaMatch implements IFight{
    private IFighter mmaFighter1;
    private IFighter mmaFighter2;

    public MmaMatch(IFighter mmaFighter1, IFighter mmaFighter2) {
        this.mmaFighter1 = mmaFighter1;
        this.mmaFighter2 = mmaFighter2;
    }

    @Override
    public void fight() {
        IFighter first;
        IFighter second;
        Random random = new Random();
        if (random.nextInt() % 2 == 0){
            first = mmaFighter1;
            second = mmaFighter2;
        }else{
            first = mmaFighter2;
            second = mmaFighter1;
        }
        boolean isFightOver = false;
        IFighter winner = null;
        while (!isFightOver) {
            showFightStatus(mmaFighter1,mmaFighter2);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AttackType attack_f1 = first.getAttackAction();
            BlockType block_f2 = second.getBlockAction();
            HitOutcome hitOutcome = isHitSuccessfull(attack_f1, block_f2);
            System.out.println(first.getName() + " hits " + attack_f1 + " (result: " + hitOutcome + ")");
            checkDamage(first, second, hitOutcome);
            if (!second.isAlive()) {
                winner = first;
                break;
            }
            AttackType attack_f2 = second.getAttackAction();
            BlockType blockType_f1 = first.getBlockAction();
            hitOutcome = isHitSuccessfull(attack_f2, blockType_f1);
            System.out.println(second.getName() + " hits " + attack_f2 + " (result: " + hitOutcome + ")");
            checkDamage(second, first, hitOutcome);
            if (!first.isAlive()) {
                winner = second;
                break;
            }
        }
        System.out.println();
        System.out.println("THE WINNER IS " + winner.getName().toUpperCase());
    }

    private void checkDamage(IFighter first, IFighter second, HitOutcome hitOutcome) {
        first.decreaseHp(hitOutcome, second);
    }

    private HitOutcome isHitSuccessfull(AttackType attack_f1, BlockType block_f2) {
        if (BlockType.DODGE.equals(block_f2)){
            return HitOutcome.DODGE;
        }
        if ((AttackType.UPPERCUT.equals(attack_f1) || AttackType.HIGH_KNEE.equals(attack_f1)) && BlockType.LOW.equals(block_f2)
                || (AttackType.JAB.equals(attack_f1) || AttackType.SLAP.equals(attack_f1)) && BlockType.HIGH.equals(block_f2)){
            return HitOutcome.PARTIAL;
        }
        return HitOutcome.FULL;
    }
}
