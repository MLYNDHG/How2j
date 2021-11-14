package J2SE.charactor;

public interface AP {
    public void magicAttack();
    //接口与继承系列教材 （十一）- 默认方法
    default public void attack(){
        System.out.println("AP默认攻击");
    }
}
