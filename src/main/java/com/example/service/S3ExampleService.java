package com.example.service;

import com.example.domain.S3Example;
import com.example.dto.S3ExampleDto;
import com.example.repository.S3ExampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class S3ExampleService {

    private final S3ExampleRepository s3ExampleRepository;

    public void save(S3ExampleDto dto) {
        S3Example s3Example=S3Example.toS3Example(dto);
        s3ExampleRepository.save(s3Example);
    }

    public List<S3ExampleDto> findAll() {
        List<S3Example> s3Examples=s3ExampleRepository.findAll();
        return S3ExampleDto.toList(s3Examples);
    }

    public void update(S3ExampleDto dto) {
        Optional<S3Example> s3Example=s3ExampleRepository.findById(dto.getId());
        if(s3Example.isPresent()) {
            s3Example.get().update(dto);
            s3ExampleRepository.save(s3Example.get());
        }
    }

    public S3ExampleDto findById(Long id) {
        Optional<S3Example> s3Example=s3ExampleRepository.findById(id);
        return s3Example.map(S3ExampleDto::from).orElse(null);
    }

    public void deleteById(Long id) {
        s3ExampleRepository.deleteById(id);
    }
}
