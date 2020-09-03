package lelandacm.com.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ProductController {
    private final ProduceServiceImpl produceService ;

    public ProductController(ProduceServiceImpl produceService) {
        this.produceService = produceService;
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("welcome", "Lelandacm") ;
        model.addAttribute("products" , produceService.findAll()) ;
        return "index" ;
    }
}
