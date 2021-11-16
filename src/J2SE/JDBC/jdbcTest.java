package J2SE.JDBC;

import J2SE.charactor.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//数据库连接类  单例   暴露出connect  statement对象
class connect{
    public Connection getC() {
        return c;
    }
    public Statement getS() {
        return s;
    }
    private Connection c=null;
    private Statement s=null;
    private PreparedStatement ps=null;
    //写一个饿汉单例将连接数据库形成单例直接调用
    private connect(){
        //创建实例就开启数据库连接
        try{
            //加载jar包驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            String conStr="jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=Utf-8";
            c=DriverManager.getConnection(conStr,"root","123456");
            System.out.println("数据库链接成功！"+c);
            //1.创建Statement对象
            s=c.createStatement();
        }catch (ClassNotFoundException |SQLException e){
            e.printStackTrace();
        }
    }
    private static connect con=new connect();
    public static connect getinstance(){
        return con;
    }
    //2.创建PreparedStatement对象
    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(String sqlStr) {
        try{
            ps = c.prepareStatement(sqlStr);;
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //关闭数据库连接
    public void closeConnect(){
        try{
            c.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //关闭数据对象链接
    public void closeStatement(){
        try{
            s.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
public class jdbcTest {
    //ORM   获取数据映射到对象
    public static Hero getHero(int id,Statement s){
        Hero h=null;
        String sqlStr="select * from Hero where id="+id;
        try{
            ResultSet rs=s.executeQuery(sqlStr);
            while(rs.next()) {
                h = new Hero();
                h.name = rs.getString(2);
                h.hp = rs.getFloat("hp");
                h.damage = rs.getInt(4);
                h.id = rs.getInt("id");
                System.out.printf("orm查询成功:%d\t%s\t%f\t%d\n",h.id, h.name, h.hp, h.damage);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            return h;
        }
    }
    //ORM  add
    public static void addHero(Hero h,Statement s){
        //s.execute()插入
        String sqlStr="insert into hero values(null,"+"'"+h.name+"',"+h.hp+","+h.damage+")";
        insert(sqlStr,s);
        System.out.println("ORM插入成功！");
        //PreparedStatement插入
    }
    //ORM delete
    public static void delete(Hero h,Statement s){
        try{
            String sqlStr="delete from hero where id =  "+h.id;
            s.execute(sqlStr);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //ORM update
    public static void update(Hero h,Statement s){
        try{
            String sqlStr="update hero set hp = 818 where id = "+h.id;
            s.execute(sqlStr);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //ORM 查询数据到集合
    public static List<Hero> getlist(Statement s){
        Hero h=null;
        List<Hero> heroList=new ArrayList<Hero>();
        try {
            String sqlStr="select * from hero";
            ResultSet rs=s.executeQuery(sqlStr);
            while(rs.next()) {
                h = new Hero();
                h.name = rs.getString(2);
                h.hp = rs.getFloat("hp");
                h.damage = rs.getInt(4);
                h.id = rs.getInt("id");
                heroList.add(h);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return heroList;
        }

    }


    //插入数据
    public static void insert(String sqlStr,Statement s){
        try{
            s.execute(sqlStr);
            System.out.println("执行插入"+sqlStr+"成功");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //查询数据
    public static void select(String sqlStr,Statement s){
        try{
            ResultSet rs=s.executeQuery(sqlStr);
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString(2);
                float hp=rs.getFloat("hp");
                int damage=rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d\n",id,name,hp,damage);
            }
            System.out.println("执行查询"+sqlStr+"成功");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //分页查询
    //start开始位置    count查询数量
    public  static void list(int start ,int count,Statement s){
        try{
            String sqlStr= "select * from hero  limit "+start+","+count+"";
            ResultSet rs= s.executeQuery(sqlStr);
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString(2);
                float hp=rs.getFloat("hp");
                int damage=rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d\n",id,name,hp,damage);
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        connect con=connect.getinstance();
        Connection c=con.getC();
        Statement s=con.getS();

        Hero h=getHero(326,s);
        addHero(h,s);
        //delete(h,s);
        update(h,s);
        getlist(s);

        try{
//            String sqlStr="insert into hero values(null,"+"'薇恩',"+313.0f+","+50+")";
//            insert(sqlStr,s);
            //test插入一百条数据
            //for (int i = 0; i < 100; i++) {
            //    sqlStr="insert into hero values(null,"+"'hero-"+i+"'"+","+313.0f+","+50+")";
            //    insert(sqlStr,s);
            //}

            //查询全部数据
            //sqlStr="select * from hero";
            //select(sqlStr,s);

            //分页查询
            list(0,10,s);

            //PreparedStatement使用测试   PreparedStatement 用起来比Statement方便
//            String PsqlStr="insert into hero values(null,?,?,?)";
//            con.setPs(PsqlStr);
//            PreparedStatement ps=con.getPs();
//            ps.setString(1,"shabi");
//            ps.setFloat(2,313.0f);
//            ps.setInt(3,50);
//            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(s!=null){
                try{
                    s.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(c!=null){
                try{
                    c.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
