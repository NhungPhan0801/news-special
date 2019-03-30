package mapper;

import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User>{

    public User mapRow(ResultSet rs) {
        User userModel = new User();
        try {
            if (rs.getString("userName") != null) {
                userModel.setUserName(rs.getString("userName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (rs.getString("password") != null) {
                userModel.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs.getString("fristName") != null) {
                userModel.setFirstName(rs.getString("lastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs.getString("createdDate") != null) {
                userModel.setCreatedDate(rs.getTimestamp("createdDate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs.getString("email") != null) {
                userModel.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            userModel.setSex(rs.getBoolean("sex"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            userModel.setRoleId(rs.getLong("roleId"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userModel;

    }

}
