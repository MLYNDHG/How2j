package J2SE.charactor;

import J2SE.Interface.Moral;

public class APHero extends Hero implements AP, Moral {
    @Override
    public void magicAttack() {
        System.out.println("进行魔法攻击");
    }

    @Override
    public void die() {
        System.out.println("法师去世了");
    }
}
