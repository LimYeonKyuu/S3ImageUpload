package com.example.response;

import com.example.dto.S3ExampleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomeResponse {
    private Long id;

    private String name;

    private String imageUrl;
}
