public class AccurateCreature extends Creature{
    public AccurateCreature(String name) {
        super(name, 20, 80);
        resetHealth();
    }
    public void performAttack(Creature target) {
        double percent = Math.random();
        if (doesAttackDamage(target)) {
            damageTargetCreature(target);
            if(percent < 0.2){
                damageTargetCreature(target);
            }
        }
    }
}
