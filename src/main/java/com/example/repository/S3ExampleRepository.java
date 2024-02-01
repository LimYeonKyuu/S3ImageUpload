package com.example.repository;

import com.example.domain.S3Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface S3ExampleRepository extends JpaRepository<S3Example, Long> {
}
