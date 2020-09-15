package com.dating.mapper;

import com.dating.mapper.QueryDTO.DaterRequestDTO;
import com.dating.pojo.Dater;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DatersMapper {
    /**
     * 根据条件筛选相亲对象
     * @return
     */
    //name ,salraty, color
    public List<Dater> getDaters(DaterRequestDTO daterRequestDTO);


}
