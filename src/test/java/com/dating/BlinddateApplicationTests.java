package com.dating;

import com.dating.mapper.QueryDTO.DaterRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlinddateApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void getDatersTest(){
        DaterRequestDTO daterRequestDTO = new DaterRequestDTO();
        daterRequestDTO.setName("zhangsan");
        daterRequestDTO.setEdu("中南大学");
    }

}
