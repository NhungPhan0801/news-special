package dao.impl;

import dao.GenericDAO;
import mapper.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbtractDao<T> implements GenericDAO<T> {
    private String url="jdbc:mysql://localhost:3306/news";
    private String user="root";
    private String password="1234";


    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            return null;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        Connection connection=null;
        ResultSet rs= null;
        PreparedStatement ps= null;
        List<T> results  = new ArrayList<T>();

        try {
            connection=getConnection();
            ps= connection.prepareStatement(sql);
            setParamets(ps,parameters);
            rs = ps.executeQuery();
            while(rs.next()){
                T t = rowMapper.mapRow(rs);
                results.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public void insert(String sql, Object... parameters) {
        Connection connection= null;
        PreparedStatement ps=null;
        try{
             connection = getConnection();
            connection.setAutoCommit(false);
            ps=connection.prepareStatement(sql);
            setParamets(ps,parameters);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public void update(String sql, Object... parameters) {
        Connection connection= null;
        PreparedStatement ps=null;
        try{
            connection = getConnection();
            connection.setAutoCommit(false);
            ps=connection.prepareStatement(sql);
            setParamets(ps,parameters);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }


    }

    private void setParamets(PreparedStatement ps,Object...parametera){
        try{
            {
                int length = parametera.length;
                for (int i=0;i<length;i++){
                    int index = i+1;
                    Object parameter=parametera[i];
                    if(parameter instanceof String){
                        ps.setString(index,(String) parameter);
                    }
                    else if (parameter instanceof Long){
                        ps.setLong(index,(Long) parameter);
                    }
                    else if(parameter instanceof Integer){
                        ps.setInt(index,(Integer) parameter);
                    }
                    else if(parameter instanceof Timestamp){
                        ps.setTimestamp(index,(Timestamp) parameter);
                    }
                    else if(parameter instanceof Boolean){
                        ps.setBoolean(index,(Boolean) parameter);
                    }
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
