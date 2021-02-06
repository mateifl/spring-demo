package ro.mfl.jdbc.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ro.mfl.jdbc.demo.entities.Category;
import ro.mfl.jdbc.demo.repositories.CategoryRepository;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

  private final CategoryRepository categoryRepository;

  @GetMapping("/categories")
  public ResponseEntity<?> getEntities() {
    log.info("loading categories");
    List<Category> entities = StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());
    return new ResponseEntity<>(entities, HttpStatus.OK);
  }
}
