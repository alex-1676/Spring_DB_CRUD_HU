package www.silver.hom;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import www.silver.VO.ProductVO;
import www.silver.VO.SearchVO;
import www.silver.service.IF_ProductService;

import javax.inject.Inject;
import java.util.List;

@Controller
public class ProductController {
    @Inject
    IF_ProductService productService;


    @GetMapping("start")
    public String start(){
        return "product";
    }

    @PostMapping("insertpro")
    public String insert(@ModelAttribute ProductVO productVO){
        productService.addProduct(productVO);
        return "product";
    }

    @GetMapping("getlist")
    public String getlist(@RequestParam("name") String name, RedirectAttributes redirectAttributes) {
        ProductVO productVO = productService.getProductById(name);
        redirectAttributes.addFlashAttribute("product", productVO);
        return "redirect:/addsearch";
    }

    @GetMapping("addsearch")
    public String addsearch(@ModelAttribute("product") ProductVO productVO, Model model) {
        model.addAttribute("product", productVO);
        SearchVO searchVO = new SearchVO();
        searchVO.setSearchName(productVO.getProductName());

        productService.addsearch(searchVO);
        return "product";
    }

    @GetMapping("getSearchHistory")
    @ResponseBody
    public List<SearchVO> getSearchHistory() {

        List<SearchVO>list = productService.getSearchHistory();
        System.out.println(list.size());
        for (SearchVO searchVO : list) {
            System.out.println(searchVO.getSearchName());
        }
        return list;
    }
}
