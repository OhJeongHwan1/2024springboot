package com.sample.spring.controller;

import com.sample.spring.entity.TestEntity;
import com.sample.spring.service.TestService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
public class TestApi {
    @Autowired
    private TestService testService;

    @GetMapping("/test/create")
    public void createTest(){
        testService.create("jeonghwan5",25);
    }

    @PostMapping("/test/create")
    public void postTest(@RequestBody CreateTestRequest request){
        log.info(request.getName());
        System.out.println(request.getName());
        testService.create(request.getName(),request.getAge());
    }

    @PutMapping("/test/update")
    public void putUpdate(
            @RequestParam("id") Long id,
            @RequestBody CreateTestRequest request
    ){
        testService.update(id, request.getName(), request.getAge());
    }

//    @DeleteMapping("/test/{id}/delete")
//    public void deleteTest(@PathVariable Long id){
//        testService.delete(id);
//    }
    @DeleteMapping("/test/delete")
    public void deleteTest(@RequestParam Long id){
        testService.delete(id);
    }

    @GetMapping("/test")
//    public List<TestEntity> jsonDate(){
//        return testService.findAll();
//    }
    public ResponseEntity<List<TestEntity>> jsonDate(){
        List <TestEntity> data = testService.findAll();
        return ResponseEntity.ok(data);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class CreateTestRequest{
        private String name;
        private Integer age;
    }
}
