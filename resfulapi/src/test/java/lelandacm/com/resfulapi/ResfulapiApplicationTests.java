package lelandacm.com.resfulapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ResfulapiApplicationTests {

    /**
     * 测试userController
     *
     * @throws Exception Exception
     */
    @Test
    public void testUserController() throws Exception {

        MockMvc mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();

        RequestBuilder builder;

        //1. get，查询user列表
        builder = get("/user/all");
        mvc.perform(builder).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));

        //2. post 提交一个user
        builder = post("/user/add").contentType(MediaType.APPLICATION_JSON).content("{\"id\" : 1, \"username\": " +
                "\"大师\"}");
        mvc.perform(builder).andExpect(content().string("add success"));

        //3. 获取某条数据
        builder = get("/users/1");
        mvc.perform(builder)
                .andExpect(content().string(equalTo("")));

        //更新一条数据
        builder = put("/user/1").contentType(MediaType.APPLICATION_JSON).content("{\"id\" : 1, \"username\": " +
                "\"大师\"}");
        mvc.perform(builder).andExpect(content().string("update default"));

        //删除一条数据
        builder = delete("/user/1") ;
        mvc.perform(builder).andExpect(content().string(equalTo("delete success")));
    }
}
