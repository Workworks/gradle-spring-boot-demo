package org.kfaino.datasource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MultiDatasourceApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    /**
     * 请求测试
     */
    @Test
    void requestTesting() throws Exception {
        String name = "kfaino";

        mockMvc.perform(get("/greet")
                        .param("name", name))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, kfaino!"));
    }

}
