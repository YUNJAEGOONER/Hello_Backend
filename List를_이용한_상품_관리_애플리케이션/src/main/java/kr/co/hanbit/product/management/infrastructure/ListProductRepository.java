package kr.co.hanbit.product.management.infrastructure;

import kr.co.hanbit.product.management.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;


// 인프라스트럭처 계층 - 특정 인프라스트럭처에 접근하는 구현 코드들이 위치하는 계층
// 리스트나 데이터베이스에 상품을 저장하는 코드들이 포함된다,
@Repository
public class ListProductRepository {

    private List<Product> products = new CopyOnWriteArrayList<>();

    //AtomicLong - 동시성 문제를 피하기 위함
    //같은 Id는 발행되지 않고, 1씩 증가
    private AtomicLong sequence = new AtomicLong(1L);

    public Product add(Product product){
        //Id 발급
        product.setId(sequence.getAndAdd(1L));

        products.add(product);
        return product;
    }

    public Product findByID(Long id){
        return products.stream()
                .filter(product -> product.sameId(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Product> findByname(String name){
        return products.stream()
                .filter(product -> product.containsName(name))
                .toList();
    }

    public List<Product> findAll(){
        return products;
    }

    public Product update(Product product){
        Integer indexToModify = products.indexOf(product);
        products.set(indexToModify, product);
        return product;
    }

    public void remove(Long id){
        Product rmProduct = this.findByID(id);
        products.remove(rmProduct);
    }


}
