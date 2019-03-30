package dao;

import dao.impl.AbtractDao;
import model.Role;

public interface IRoleDAO extends GenericDAO<Role> {
    Role findByRoleId(Long roleid);
}
