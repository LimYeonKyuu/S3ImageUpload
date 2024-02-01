package com.example.controller;


import com.example.dto.S3ExampleDto;
import com.example.form.S3ExampleForm;
import com.example.response.HomeResponse;
import com.example.response.UpdateResponse;
import com.example.service.S3ExampleService;
import com.example.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class S3ExampleController {

    private final S3Service s3Service;
    private final S3ExampleService s3ExampleService;

    @GetMapping("/s3Example")
    public String s3Example(Model model) {
        List<S3ExampleDto> s3ExampleDtos=s3ExampleService.findAll();
        List<HomeResponse> homeResponses=new ArrayList<>();
        for (S3ExampleDto s3ExampleDto : s3ExampleDtos) {
            HomeResponse homeResponse=HomeResponse.builder()
                    .id(s3ExampleDto.getId())
                    .name(s3ExampleDto.getName())
                    .imageUrl(s3Service.getImageUrl(s3ExampleDto.getImagePath()))
                    .build();
            homeResponses.add(homeResponse);
        }
        model.addAttribute("response", homeResponses);
        return "index";
    }

    @PostMapping("s3Example/upload")
    public String upload(@RequestParam("image") MultipartFile image, S3ExampleForm form) throws IOException {
        String imagePath=s3Service.upload(image, "example");

        S3ExampleDto dto=S3ExampleDto.builder()
                .name(form.getName())
                .imagePath(imagePath)
                .build();

        s3ExampleService.save(dto);

        return "redirect:/";
    }

    @GetMapping("/s3Example/upload")
    public String upload() {
        return "upload";
    }

    @GetMapping("/s3Example/update/{id}")
    public String update(@PathVariable("id") Long id, Model model) {
        S3ExampleDto dto=s3ExampleService.findById(id);
        UpdateResponse response=UpdateResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .imageUrl(s3Service.getImageUrl(dto.getImagePath()))
                .build();
        model.addAttribute("response", response);
        return "update";
    }

    @PostMapping("s3Example/update/{id}")
    public String update(@PathVariable("id") Long id, @RequestParam("image") MultipartFile image, S3ExampleForm form) throws IOException {
        String imagePath=s3Service.upload(image, "example");

        S3ExampleDto dto=S3ExampleDto.builder()
                .id(id)
                .name(form.getName())
                .imagePath(imagePath)
                .build();

        s3ExampleService.update(dto);

        return "redirect:/";
    }

    @GetMapping("/s3Example/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        s3Service.delete(s3ExampleService.findById(id).getImagePath());
        s3ExampleService.deleteById(id);
        return "redirect:/";
    }
}