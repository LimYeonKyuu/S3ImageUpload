package com.example.dto;

import com.example.domain.S3Example;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class S3ExampleDto {
    private Long id;
    private String name;
    private String imagePath;
    private String imageUrl;

    public static List<S3ExampleDto> toList(List<S3Example> s3Examples) {
        List<S3ExampleDto> s3ExampleDtos=new ArrayList<>();
        for(S3Example s3Example:s3Examples) {
            s3ExampleDtos.add(S3ExampleDto.toS3ExampleDto(s3Example));
        }
        return s3ExampleDtos;
    }

    public static S3ExampleDto toS3ExampleDto(S3Example s3Example) {
        return S3ExampleDto.builder()
                .id(s3Example.getId())
                .name(s3Example.getName())
                .imagePath(s3Example.getImagePath())
                .build();
    }

    public static S3ExampleDto from(S3Example s3Example) {
        return S3ExampleDto.builder()
                .id(s3Example.getId())
                .name(s3Example.getName())
                .imagePath(s3Example.getImagePath())
                .build();
    }
}
