package mapper;

import model.Role;
import utils.MapperUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role>{

    public Role mapRow(ResultSet rs) {
        Role role =new Role();
        return MapperUtil.map(new Role(),rs);

    }
}
