package hello;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure;
import org.springframework.boot.stereotype.*;
import org.springframework.boot.web.bind.anntation.*;

@Controller
@EnabledAutoConfiguration
public class SamplerController {

    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception{
        SpringApplication.run(SamplerController.class,args);
    }

}
