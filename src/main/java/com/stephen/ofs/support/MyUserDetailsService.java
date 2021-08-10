package com.stephen.ofs.support;

import com.stephen.ofs.dao.*;
import com.stephen.ofs.dao.entity.OfsUser;
import com.stephen.ofs.dao.entity.Permission;
import com.stephen.ofs.dao.entity.Role;
import com.stephen.ofs.dao.entity.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Autowired
    private PermissionDao permissionDao;
    /**
     * 授权的时候是对角色授权，而认证的时候应该基于资源，而不是角色，因为资源是不变的，而用户的角色是会变的
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        OfsUser sysUser = userDao.findByUserName(username);
        if (null == sysUser) {
            throw new UsernameNotFoundException(username);
        }
        List<Role> sysRoleList = userDao.findRolesById(sysUser.getCustomerId());
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : sysRoleList) {
            List<RolePermission> rolePermissionList = rolePermissionDao.findRolePermissionByRoleId(role.getCode());


            for (RolePermission rolePermission : rolePermissionList) {
                int permissionCode = rolePermission.getPermissionCode();
                Permission permission = permissionDao.findByCode(permissionCode);
                authorities.add(new SimpleGrantedAuthority(permission.getCode() + ""));
            }
        }

        return new User(sysUser.getUserName(), sysUser.getPassword(), authorities);
    }
}
