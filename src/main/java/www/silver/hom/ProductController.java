package www.silver.hom;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import www.silver.VO.ProductVO;
import www.silver.VO.SearchVO;
import www.silver.service.IF_CommentService;
import www.silver.service.IF_ProductService;

import java.util.List;
@RequiredArgsConstructor
@Controller
public class ProductController {

   private final IF_ProductService productService;


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
    @ResponseBody
    public ResponseEntity<ProductVO> getlist(@RequestParam("name") String name) {
        System.out.println("checkdddddddddd - Start");
        ProductVO productVO = productService.getProductById(name);
        if (productVO == null) {
            System.out.println("Product not found for name: " + name);
            return ResponseEntity.notFound().build();
        }
        SearchVO searchVO = new SearchVO();
        searchVO.setSearchName(productVO.getProductName());
        productService.addsearch(searchVO);
        System.out.println("checkdddddddddd - End");
        return ResponseEntity.ok(productVO);
    }

//    @GetMapping("addsearch")
//    @ResponseBody
//    public ProductVO addsearch(@ModelAttribute("product") ProductVO productVO, Model model) {
//        model.addAttribute("product", productVO);
//
//
//
//        return productVO;
//    }

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
