package kr.co.hanbit.product.management.application;

import kr.co.hanbit.product.management.domain.Product;
import kr.co.hanbit.product.management.infrastructure.ListProductRepository;
import kr.co.hanbit.product.management.presentation.ProductDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//응용 계층 - 표현 계층에서 넘겨 받은 데이터로 새로운 자원을 저장하거나 저장되어 있던 자원을 조회
@Service //빈으로 등록
public class SimpleProductService {

    private ListProductRepository listProductRepository;

    private ModelMapper modelMapper;

    @Autowired
    SimpleProductService(ListProductRepository listProductRepository, ModelMapper modelMapper){
        this.listProductRepository = listProductRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDto add(ProductDto productDto){
        // 1. ProductDto를 product로 변환
        Product product = modelMapper.map(productDto, Product.class);

        // 2. Repository를 호출하는 코드
        Product savedProduct = listProductRepository.add(product);
        
        //3.Product를 productDto로 변환
        ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);

        return savedProductDto;
    }

    public ProductDto findById(Long id){
        Product product = listProductRepository.findByID(id);
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }

    private List<ProductDto> convertToDto(List<Product> productList){
        return productList.stream()
                .map(product -> modelMapper.map(product,ProductDto.class))
                .toList();
    }

    public List<ProductDto> findByName(String name){
        List<Product> foundList = listProductRepository.findByname(name);
        return convertToDto(foundList);
    }

    public List<ProductDto> findAll(){
        List<Product> productList = listProductRepository.findAll();
        return convertToDto(productList);
    }

    public ProductDto update(ProductDto productDto){
        Product product = modelMapper.map(productDto, Product.class);
        Product updateProduct = listProductRepository.update(product);
        ProductDto updateProductDto = modelMapper.map(updateProduct, ProductDto.class);
        return updateProductDto;
    }

    public void remove(Long Id){
        listProductRepository.remove(Id);
    }
}

