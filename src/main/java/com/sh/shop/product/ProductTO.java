package com.sh.shop.product;

import lombok.*;

import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ProductTO {

    @NonNull
    private String name;
    @Min(1)
    private Long price;

}