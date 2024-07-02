public class FastCreature extends Creature{
    public FastCreature(String name) {
        super(name, 15, 50);
        resetHealth();
    }
    public void performAttack(Creature target) {
        for(int i = 0; i < 1; i++){
            if (doesAttackDamage(target)) {
                damageTargetCreature(target);
            }
        }
    }
}
