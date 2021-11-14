package J2SE.charactor;

public interface AD {
    public void physicAttack();
    //接口与继承系列教材 （十一）- 默认方法
    default public void attack(){
        System.out.println("AD默认攻击");
    }
}
