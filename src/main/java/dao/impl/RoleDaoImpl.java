package dao.impl;

import dao.IRoleDAO;
import mapper.RoleMapper;
import model.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl extends AbtractDao<Role> implements IRoleDAO{
    public Role findByRoleId(Long roleid) {
        String sql ="SELECT * FROM role WHERE roleid=?";
        List<Role> list = query(sql,new RoleMapper(), roleid);
        return list.isEmpty()? null:list.get(0);

    }
}
