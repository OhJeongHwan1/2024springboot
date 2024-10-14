package com.sample.spring.repository;

import com.sample.spring.model.TodoEntity;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class TodoRepositoryTest {
    @Autowired
    private TodoRepository todoRepository;

//    @Test
//    public void TestInsert(){
//        TodoEntity todo = TodoEntity.builder()
//                .title("title")
//                .writer("writer...")
//                .dueDate(LocalDate.of(2024,10,14))
//                .build();
//
//        TodoEntity result = todoRepository.save(todo);
//        log.info(result);
//    }
//    @Test
//    public void testRead(){
//        Long tno = 1L;
//        Optional<TodoEntity> result = todoRepository.findById(tno);
//        TodoEntity todo = result.orElseThrow();
//        log.info("안녕하세요"+todo);
//    }
    @Test
    public void testUpdate(){
        Long tno = 1L;
        Optional<TodoEntity> result = todoRepository.findById(tno);
        TodoEntity todo = result.orElseThrow();

        todo.changeTitle("update title");
        todo.changeComplete(true);

        todoRepository.save(todo);
    }
}
