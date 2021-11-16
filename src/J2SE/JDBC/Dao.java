package J2SE.JDBC;

import J2SE.charactor.Hero;

import java.util.List;

public interface Dao {
    public void add(Hero h);
    public void update(Hero h);
    public void delete(Hero h);
    public Hero get(int id);
    public List<Hero> list();
    public List<Hero> list(int start,int count);
}
