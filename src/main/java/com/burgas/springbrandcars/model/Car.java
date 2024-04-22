package com.burgas.springbrandcars.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Getter
@Setter
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private int id;

    @NotEmpty(message = "This field can't be empty")
    private String title;
    private int brandId;
    private int categoryId;
    private String image;
    private String webpage;
    private String description;

    @NotEmpty(message = "This field can't be empty")
    @Min(0)
    private int price;
}
