package J2SE.Socket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class dictionaryDao {
    public dictionaryDao(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/android?characterEncoding=Utf-8","root","123456");
    }
    public List<dictionary> getDictionaryList(String name){
        List<dictionary> dicList=new ArrayList<>();
        String sqlStr="select * from dictionary where receive=?";
        try (Connection con=getConnection(); PreparedStatement pre=con.prepareStatement(sqlStr);){
            pre.setString(1,name);
            ResultSet rs=pre.executeQuery();
            while(rs.next()){
                dictionary d=new dictionary();
                d.id=rs.getInt(1);
                d.receive=rs.getString(2);
                d.response=rs.getString(3);
                dicList.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dicList;
    }
}
