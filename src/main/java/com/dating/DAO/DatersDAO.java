package com.dating.DAO;


import com.dating.DAO.QueryDTO.DaterRequestDTO;
import com.dating.pojo.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatersDAO {
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
