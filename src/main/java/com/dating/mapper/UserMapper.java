package com.dating.mapper;

import com.dating.mapper.QueryDTO.DaterRequestDTO;
import com.dating.pojo.Dater;
import com.dating.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    public User findByUserName(String username);

}
