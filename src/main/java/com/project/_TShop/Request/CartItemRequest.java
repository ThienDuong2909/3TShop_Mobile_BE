package com.project._TShop.Request;

import lombok.Data;

@Data
public class CartItemRequest {
    private Integer productId;
    private Integer sizeId;
    private Integer colorId;
    private Integer quantity;
}
