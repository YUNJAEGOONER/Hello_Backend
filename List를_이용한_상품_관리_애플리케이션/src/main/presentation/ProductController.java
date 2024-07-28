package kr.co.hanbit.product.management.presentation;

import kr.co.hanbit.product.management.application.SimpleProductService;
import kr.co.hanbit.product.management.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 표현 계층 - 클라이언트로부터 들어오는 요청을 받고, 응답해 주는 역할
@RestController
public class ProductController {

    private final SimpleProductService simpleProductService;
    
    @Autowired //의존성 주입을 받음
    ProductController(SimpleProductService simpleProductService){
        this.simpleProductService = simpleProductService;
    }

    //POST - 글 작성, GET - 글 읽기(조회), PUT - 글 수정, DELETE - 글 삭제

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ProductDto createProduct(@RequestBody ProductDto productDto){
        return simpleProductService.add(productDto);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ProductDto findById(@PathVariable Long id){
        return simpleProductService.findById(id);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    //RequestParam : /products?name=abc....
    public List<ProductDto> findproducts(
            @RequestParam(required = false)String name
    ){
        if(null == name){
            return simpleProductService.findAll();
        }
        return simpleProductService.findByName(name);

    }

    // id와 productDto를 받아온다.
    // @RequestBody ProductDto productDto -> createProduct 참고
    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ProductDto updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDto productDto
    ){
        productDto.setId(id);
        return simpleProductService.update(productDto);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Long id){
        simpleProductService.remove(id);
    }






}
