package by.strigo.demokotlin

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class DemoKotlinApplicationTests {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun test200() {
        mockMvc.get("/")
            .andExpect { status { is2xxSuccessful() } }
            .andReturn()
            .response.contentAsString
            .apply { contains("""{"message": "Hello World"}""") }
    }

}
