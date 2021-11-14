package J2SE.charactor;

import J2SE.Interface.Moral;

public class ADAPHero extends Hero implements AD,AP, Moral {

    @Override
    public void physicAttack() {
        System.out.println("进行物理攻击");
    }

    @Override
    public void magicAttack() {
        System.out.println("进行魔法攻击");
    }

    @Override
    public void die() {
        System.out.println("ADAP英雄去世了");
    }

    //继承接口的默认方法必须重写
    @Override
    public void attack() {
        System.out.println();
    }

}
