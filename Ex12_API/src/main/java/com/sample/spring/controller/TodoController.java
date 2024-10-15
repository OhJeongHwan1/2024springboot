package com.sample.spring.controller;

import com.sample.spring.dto.PageRequestDto;
import com.sample.spring.dto.PageResponseDto;
import com.sample.spring.dto.TodoDto;
import com.sample.spring.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Log4j2
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/todo")
public class TodoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/{tno}") // https://localhost:8080/api/todo/1
    public TodoDto get(@PathVariable(name = "tno") Long tno){
        return todoService.get(tno);
    }

    @GetMapping("/list")
    public PageResponseDto<TodoDto> list(PageRequestDto pageRequestDto){
        log.info(pageRequestDto);

        return todoService.getList(pageRequestDto);
    }

    @PostMapping("/")
    public Map<String, Long> register(@RequestBody TodoDto todoDto){
        log.info("todoDto : " + todoDto);
        Long tno = todoService.postTodo(todoDto);

        return Map.of("No.", tno);
    }
    @PutMapping("/{tno}")
    public Map<String, String> modify(@PathVariable(name = "tno") Long tno,@RequestBody TodoDto todoDto){
        todoDto.setTno(tno);

        todoService.modify(todoDto);
        return Map.of("result: ", "success");
    }

    @DeleteMapping("/{tno}")
    public Map<String, String> delete(@PathVariable(name = "tno") Long tno){
        todoService.remove(tno);
        return Map.of("result: ", "success");
    }
}

