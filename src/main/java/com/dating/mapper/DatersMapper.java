package com.dating.mapper;

import com.dating.mapper.QueryDTO.DaterRequestDTO;
import com.dating.pojo.User;
import com.dating.pojo.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatersMapper {
    /**
     * 根据条件筛选相亲对象
     * @return
     */
    public List<UserInfo> getDaters(DaterRequestDTO daterRequestDTO);

    public boolean updateByUserName(UserInfo userInfo);

    public UserInfo isExist(UserInfo userInfo);

    public boolean deleteUser(UserInfo userInfo);

    public boolean insertUserInfo(UserInfo userInfo);

}
