package com.project._TShop.Services;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.project._TShop.DTO.ProductDTO;
import com.project._TShop.DTO.ProductSpecDTO;
import com.project._TShop.DTO.SpecificationsDTO;
import com.project._TShop.Entities.*;
import com.project._TShop.Exceptions.ResourceNotFoundException;
import com.project._TShop.Repositories.*;
import com.project._TShop.Request.ProductWithSpecificationsRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project._TShop.Response.Response;
import com.project._TShop.Utils.Utils;

@Service
@RequiredArgsConstructor
public class ProductService {
@Autowired

    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ColorRepository colorRepository;
    @Autowired
    SizeRepository sizeRepository;
    @Autowired
    SpecificationsRepository specRepo;


    public Response getAll(){
        Response response = new Response();
        try {
            List<Product> products = productRepository.findAll();
            response.setStatus(200);
            response.setMessage("Get all product success");
            response.setProductDTOList(Utils.mapProducts(products));
        } catch (Exception e) {
            System.out.println(e);
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;
    }

    public Response getAvailableProduct(){
        Response response = new Response();
        try {
            List<Product> products = productRepository.findAvailableProducts();
            response.setStatus(200);
            response.setMessage("Get all product success");
            response.setProductDTOList(Utils.mapProducts(products));
        } catch (Exception e) {
            System.out.println(e);
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;
    }

    public Response getById(Integer id){
        Response response = new Response();
        try {
            Optional<Product> product = productRepository.findById(id);
            if(product.isPresent()){
                response.setStatus(200);
                response.setMessage("Get product success");
                response.setProductDTO(Utils.mapProduct(product.get()));
            }else{
                response.setStatus(201);
                response.setMessage("Not found product");
            }
        } catch (Exception e) {
            System.out.println(e);
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;
    }

    // public Response getByCategory(Integer id){
    //     Response response = new Response();
    //     try {
    //         Optional<Category> category = categoryRepository.findById(id);
    //         if(category.isPresent()){
    //             List<Product> products = productRepository.findByCategory(category.get().getCategory_id());
    //             response.setStatus(200);
    //             response.setMessage("Get products success");
    //             response.setProductDTOList(Utils.mapProducts(products));
    //         }else{
    //             response.setStatus(202);
    //             response.setMessage("Not found categorys");
    //         }
    //     } catch (Exception e) {
    //         System.out.println(e);
    //         response.setStatus(500);
    //         response.setMessage("Server error");
    //     }
    //     return response;
    // }

    public Response getHotProducts() {
        Response response = new Response();
        try {
            List<Product> products = productRepository.findAvailableProducts();
            products.sort(Comparator.comparingInt(Product::getSold).reversed());
            List<Product> top10Products = products.stream().limit(10).toList();
            response.setStatus(200);
            response.setMessage("Get hot products success");
            response.setProductDTOList(Utils.mapProducts(top10Products));
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;
    }

    // public Response getByCategory(Integer idCategory) {
    //     Response response = new Response();
    //     try {
    //         Category category = categoryRepository.findById(idCategory)
    //             .orElseThrow(() -> new RuntimeException("Category not found"));
    //         List<Product> products = productRepository.findAvailableProducts();
    //         List<Product> filteredProducts = products.stream()
    //             .filter(product -> product.getCategory_id().equals(category)) 
    //             .limit(10) 
    //             .toList();
    //         response.setStatus(200);
    //         response.setMessage("Get products by category success");
    //         response.setProductDTOList(Utils.mapProducts(filteredProducts));
    //     } catch (RuntimeException e) {
    //         response.setStatus(202);
    //         response.setMessage(e.getMessage());
    //     } catch (Exception e) {
    //         System.out.println("Lỗi: " + e.getMessage());
    //         response.setStatus(500);
    //         response.setMessage("Server error");
    //     }
    //     return response;
    // } 
    
    // public Response getByName(String name) {
    //     Response response = new Response();
    //     try {
    //         String formattedName = name.replace("-", " ");
            
    //         List<Product> products = productRepository.findByNameContainingIgnoreCase(formattedName);
            
    //         if (products.isEmpty()) {
    //             response.setStatus(202);
    //             response.setMessage("Không tìm thấy sản phẩm với tên: " + formattedName);
    //         } else {
    //             response.setStatus(200);
    //             response.setMessage("Tìm thấy sản phẩm thành công");
    //             response.setProductDTOList(Utils.mapProducts(products));
    //         }
    //     } catch (Exception e) {
    //         System.out.println("Lỗi: " + e.getMessage());
    //         response.setStatus(500);
    //         response.setMessage("Lỗi máy chủ");
    //     }
    //     return response;
    // }    

     private ProductSpecDTO mapToProductSpecDTO(Product product, List<Specifications> specs) {
        List<ProductSpecDTO.SpecificationInfo> specInfoList = specs.stream()
            .map(spec -> ProductSpecDTO.SpecificationInfo.builder()
                .size(spec.getSize_id().getName())
                .color(spec.getColor().getName())
                .quantity(spec.getQuantity())
                .build())
            .collect(Collectors.toList());

        return ProductSpecDTO.builder()
            .product_id(product.getProduct_id())
            .name(product.getName())
            .description(product.getDescription())
            .image(product.getImage())
            .price(product.getPrice())
            .sold(product.getSold())
            .which_gender(product.getWhich_gender())
            .created_at(product.getCreated_at())
            .status(product.getStatus())
            .categoryName(product.getCategory_id().getName())
            .specifications(specInfoList)
            .build();
    }

    public Response getByCategory(Integer idCategory) {
        Response response = new Response();
        try {
            Category category = categoryRepository.findById(idCategory)
                .orElseThrow(() -> new RuntimeException("Category not found"));
            
            List<Product> products = productRepository.findAvailableProducts();
            List<Product> filteredProducts = products.stream()
                .filter(product -> product.getCategory_id().equals(category))
                .limit(10)
                .collect(Collectors.toList());

            List<ProductSpecDTO> productSpecDTOs = filteredProducts.stream()
                .map(product -> {
                    List<Specifications> specs = specRepo
                        .findByProductAndStatus(product, 1); 
                    return mapToProductSpecDTO(product, specs);
                })
                .collect(Collectors.toList());

            response.setStatus(200);
            response.setMessage("Get products by category success");
            response.setProductSpecDTOList(productSpecDTOs);
        } catch (RuntimeException e) {
            response.setStatus(202);
            response.setMessage(e.getMessage());
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;
    }
   
    public Response getByName(String name) {
        Response response = new Response();
        try {
            String formattedName = name.replace("-", " ");
           
            List<Product> products = productRepository.findByNameContainingIgnoreCase(formattedName);
           
            if (products.isEmpty()) {
                response.setStatus(202);
                response.setMessage("Không tìm thấy sản phẩm với tên: " + formattedName);
            } else {
                List<ProductSpecDTO> productSpecDTOs = products.stream()
                    .map(product -> {
                        List<Specifications> specs = specRepo
                            .findByProductAndStatus(product, 1);
                        return mapToProductSpecDTO(product, specs);
                    })
                    .collect(Collectors.toList());

                response.setStatus(200);
                response.setMessage("Tìm thấy sản phẩm thành công");
                response.setProductSpecDTOList(productSpecDTOs);
            }
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            response.setStatus(500);
            response.setMessage("Lỗi máy chủ");
        }
        return response;
    }

    public Response getNewProducts() {
        Response response = new Response();
        try {
            List<Product> products = productRepository.findAvailableProducts();
            products.sort(Comparator.comparing(Product::getCreated_at).reversed());
            List<Product> top10NewProducts = products.stream().limit(10).toList();
            response.setStatus(200);
            response.setMessage("Get new products success");
            response.setProductDTOList(Utils.mapProducts(top10NewProducts));
        } catch (Exception e) {
            System.out.println("Lỗi: " + e.getMessage());
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;

    }
    @Transactional
    public Response addProduct(ProductWithSpecificationsRequest request) {

        Response response = new Response();
        try {
            ProductDTO productDTO = request.getProductDTO();
            List<SpecificationsDTO> specificationsDTOList = request.getSpecificationsDTO();
            Category category = categoryRepository.findByCategoryId(productDTO.getCategoryDTO().getCategory_id());
            if (category == null) {
                response.setStatus(204);
                response.setMessage("Category not found");
                return response;
            }
            for (SpecificationsDTO spec : specificationsDTOList) {
                colorRepository.findByColorId(spec.getColorDTO().getColor_id())
                        .orElseThrow(()-> new ResourceNotFoundException("Color", "ID", spec.getColorDTO().getColor_id()));
                sizeRepository.findBySizeId(spec.getSizeDTO().getSize_id())
                        .orElseThrow(()-> new ResourceNotFoundException("Size", "ID", spec.getSizeDTO().getSize_id()));
            }
            var product = Product.builder()
                    .name(productDTO.getName())
                    .description(productDTO.getDescription())
                    .price(productDTO.getPrice())
                    .sold(productDTO.getSold())
                    .which_gender(productDTO.getWhich_gender())
                    .image(productDTO.getImage())
                    .created_at(new Date())
                    .category_id(category)
                    .status(1)
                    .build();
            Product savedProduct = productRepository.save(product); // Save the Product only after validation
            for (SpecificationsDTO spec : specificationsDTOList) {
                Color color = colorRepository.findByColorId(spec.getColorDTO().getColor_id())
                        .orElseThrow(()-> new ResourceNotFoundException("Color", "ID", spec.getColorDTO().getColor_id()));
                Size size = sizeRepository.findBySizeId(spec.getSizeDTO().getSize_id())
                        .orElseThrow(()-> new ResourceNotFoundException("Size", "ID", spec.getSizeDTO().getSize_id()));
                if (size != null && color != null) {
                    var specification = Specifications.builder()
                            .color(color)
                            .product(savedProduct)
                            .size_id(size)
                            .quantity(spec.getQuantity())
                            .status(1)
                            .build();
                    specRepo.save(specification);
                }
            }
            response.setStatus(200);
            response.setMessage("Add new product and specification success");
        }catch (ResourceNotFoundException e){
            response.setStatus(201);
            response.setMessage(e.getMessage());
        }
        catch (Exception e) {
            System.out.println(e);
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;
    }

    public Response changeStatusOfProduct(ProductDTO productDTO) {
        Response response = new Response();
        try {
            Product product = productRepository.findByProductId(productDTO.getProduct_id())
                    .orElseThrow(()-> new ResourceNotFoundException("Product", "ID", productDTO.getProduct_id()));
            product.setStatus(productDTO.getStatus());
            productRepository.save(product);
            response.setStatus(200);
            response.setMessage("Change status success");
        }catch (ResourceNotFoundException e){
            response.setStatus(201);
            response.setMessage(e.getMessage());
        }catch (Exception e){
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;
    }

    public Response searchByName(String productName) {
        System.out.println("Product name: "+productName);
        Response response = new Response();
        try {
            List<Product> products = productRepository.findByNameContaining(productName)
                    .orElseThrow(()-> new ResourceNotFoundException("Product", "name", productName));
            List<ProductDTO> productsDTOList = products.stream()
                    .map(Utils::mapProduct)
                    .toList();
            response.setStatus(200);
            response.setProductDTOList(productsDTOList);
        }catch (ResourceNotFoundException e){
            response.setStatus(201);
            response.setMessage(e.getMessage());
        }catch (Exception e){
            response.setStatus(500);
            response.setMessage("Server error");
        }
        return response;
    }
}
