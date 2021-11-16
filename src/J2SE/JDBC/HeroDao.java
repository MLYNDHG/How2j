package J2SE.JDBC;

import J2SE.charactor.Hero;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDao implements Dao{
    public HeroDao(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        String conStr= null;
        Connection c=null;
        try {
            conStr = "jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=Utf-8";
            c= DriverManager.getConnection(conStr,"root","123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  c;
    }
    @Override
    public void add(Hero h) {
        try (Connection c=getConnection(); ){
            String sqlStr="insert into hero values(null,?,?,?)";
            PreparedStatement ps=c.prepareStatement(sqlStr);
            ps.setString(1,h.name);
            ps.setFloat(2,315.0f);
            ps.setInt(3,900);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Hero h) {
        try(Connection c=getConnection();Statement s=c.createStatement()){
            String sqlStr="update hero set hp=100 where name="+h.name;
            s.execute(sqlStr);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Hero h) {
        try(Connection c=getConnection();Statement s=c.createStatement()){
            String sqlStr="delete from hero where name="+h.name;
            s.execute(sqlStr);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Hero get(int id) {
        Hero h=null;
        try(Connection c=getConnection();Statement s=c.createStatement()){
            String sqlStr="select * from Hero where id="+id;
            h=new Hero();
            ResultSet rs=s.executeQuery(sqlStr);
            while (rs.next()){
                h.id=rs.getInt(1);
                h.name=rs.getString(2);
                h.hp=rs.getFloat(3);
                h.damage=rs.getInt(4);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return h;
    }

    @Override
    public List<Hero> list() {
        List<Hero>  heroList=new ArrayList<Hero>();
        try(Connection c=getConnection();Statement s=c.createStatement()){
            String sqlStr="select * from Hero";
            ResultSet rs=s.executeQuery(sqlStr);
            Hero h=new Hero();
            while (rs.next()){
                h.id=rs.getInt(1);
                h.name=rs.getString(2);
                h.hp=rs.getFloat(3);
                h.damage=rs.getInt(4);
                heroList.add(h);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return heroList;
    }

    @Override
    public List<Hero> list(int start, int count) {
        List<Hero>  heroList=new ArrayList<Hero>();
        try(Connection c=getConnection();Statement s=c.createStatement()){
            String sqlStr="select * from Hero  limit "+start+","+count+"";
            ResultSet rs=s.executeQuery(sqlStr);
            Hero h=new Hero();
            while (rs.next()){
                h.id=rs.getInt(1);
                h.name=rs.getString(2);
                h.hp=rs.getFloat(3);
                h.damage=rs.getInt(4);
                heroList.add(h);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return heroList;
    }

}
