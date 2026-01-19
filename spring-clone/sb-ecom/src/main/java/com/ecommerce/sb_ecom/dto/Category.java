package main.java.com.ecommerce.sb_ecom.dto;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
    private Long categoryId;
    private String categoryName;
}
