package com.project._TShop.Request;

import lombok.Data;
import java.util.List;

@Data
public class OrderRequest {
    private Integer idAddress;
    private List<OrderDetailRequest> orderRequests;
}
