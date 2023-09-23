package org.kfaino.gradlespringbootdemo;

import org.kfaino.gradlespringbootdemo.exceptiondemo.controller.MyController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * 请求测试
     * {@link MyController#greet}
     */
    @Test
    void requestTesting() throws Exception {
        String name = "kfaino";

        mockMvc.perform(get("/greet")
                        .param("name", name))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, kfaino!"));
    }


    /**
     * 参数校验
     * {@link MyController#createUser}
     */
    @Test
    void shouldReturnBadRequestWhenNameIsBlank() throws Exception {
        String userJson = "{\"name\":\"\"}"; // 空的name应该触发验证失败

        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isBadRequest());
    }
}

