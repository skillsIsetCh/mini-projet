package io.javabrains.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository ;


     public List<Course> getAllCourses(String topicId) {
         List<Course> courses = new ArrayList<>();
         courseRepository.findByTopicId(topicId).forEach(courses::add);
         return courses;
     }

     public Optional<Course> getCourse(String id) {
         //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

          return courseRepository.findById(id);
     }

     public Course addCourse(Course course) {

         courseRepository.save(course);
         return course;
     }

     public void editCourse(Course topic) {
         courseRepository.save(topic);
     }

     public void deleteCourse(String id) {
        courseRepository.deleteById(id);
     }
}
