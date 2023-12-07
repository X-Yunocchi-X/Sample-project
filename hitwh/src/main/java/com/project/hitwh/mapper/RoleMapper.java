package com.project.hitwh.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.project.hitwh.entity.RolePointer;

@Mapper
public interface RoleMapper {
    
    @Insert("insert into Roles(Account, Password, Entity, EntityID) values(#{account}, #{password}, #{entity}, #{entityID})")
    int insertRole(String account, String password, String entity, int entityID);
    
    @Select("select Entity, EntityID from Roles where Account = #{account} and Password = #{password}")
    RolePointer getRolePointerByAccountAndPassword(String account, String password);

}
