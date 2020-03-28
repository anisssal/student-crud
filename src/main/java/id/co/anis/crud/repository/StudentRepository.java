package id.co.anis.crud.repository;

import id.co.anis.crud.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sun.util.resources.cldr.mg.LocaleNames_mg;

import java.util.List;

/**
 * Created By Anis
 * created on 3/28/2020 - 10:53 AM on crud
 */

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findStudentsByName(String name);

}
