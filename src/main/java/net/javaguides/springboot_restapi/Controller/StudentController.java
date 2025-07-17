package net.javaguides.springboot_restapi.Controller;


import net.javaguides.springboot_restapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {


    @GetMapping("/student")
public ResponseEntity<Student> getStudent(){

    Student student=new Student(
            1,
            "bakhtawar",
            "changezi"

    );
    return ResponseEntity.ok().header("custom-header","bakhtawar").body(student);
}

@GetMapping
public ResponseEntity<List<Student>> getStudents(){

        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"Bakhtawar","changezi"));
        students.add(new Student(2,"ALi","changezi"));
        students.add(new Student(3,"Arisha","changezi"));
return ResponseEntity.ok(students);

}

//PatH Variable

@GetMapping("{id}/{first-name}/{last-name}")
    public  ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentid,
                                        @PathVariable("first-name")String firstName,
                                        @PathVariable("last-name") String lastName){

        Student student=new Student(studentid,firstName,lastName);
    return ResponseEntity.ok(student);
    }

    @GetMapping("query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam  int id , @RequestParam String firstName, @RequestParam String lastName){

        Student student=new Student(id,firstName,lastName);
return ResponseEntity.ok(student);

    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    //Post Request
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }

//PUT REQUEST

    @PutMapping("{id}/update")
    public  ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int id){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);

    }


@DeleteMapping("{id}/delete")

    public  ResponseEntity<String> deleteStudent(@PathVariable("id") int id){
    System.out.println(id);
        return   ResponseEntity.ok("Student delete sucesssfully");

}



}
