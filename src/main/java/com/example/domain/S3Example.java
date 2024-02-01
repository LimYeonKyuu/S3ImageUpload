package com.example.domain;

import com.example.dto.S3ExampleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "example")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class S3Example {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name" , length = 1000)
    private String name;

    @Column(name="image_path" , length = 1000)
    private String imagePath;

    public static S3Example toS3Example(S3ExampleDto s3ExampleDto) {
        return S3Example.builder()
                .name(s3ExampleDto.getName())
                .imagePath(s3ExampleDto.getImagePath())
                .build();
    }

    public void update(S3ExampleDto dto) {
        this.name = dto.getName() != null ? dto.getName() : this.name;
        this.imagePath = dto.getImagePath() != null ? dto.getImagePath() : this.imagePath;
    }
}
