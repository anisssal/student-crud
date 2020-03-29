package id.co.anis.crud.controller;

import id.co.anis.crud.entity.Student;
import id.co.anis.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import javax.validation.Valid;

/**
 * Created By Anis
 * created on 3/28/2020 - 10:55 AM on crud
 */

@Controller
@RequestMapping("/students/")
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("signup")
    public String showSignUpForm(Student student) {
        return "add-student";
    }

    @PostMapping("add")
    public String addStudent(@Valid Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-student";
        }
        studentRepository.save(student);
        return "redirect:list";
    }

    @GetMapping("list")
    public String showList(Model model) {
        Iterable<Student> all = studentRepository.findAll();
        if (all.spliterator().getExactSizeIfKnown() != 0) {
            model.addAttribute("students", all);
        }
        return "index";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id " + id));
        model.addAttribute("student", student);
        return "add-student";
    }

  /*  @PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") long id, @Valid Student student ,  BindingResult result, Model model) {
        if (result.hasErrors()) {
            student.setId(id);
            return "update-student";
        }
        studentRepository.save(student);
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }*/

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        studentRepository.delete(student);
        return "redirect:list";
    }
}
