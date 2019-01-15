package io.javabrains.springbootstarter.course;

import io.javabrains.springbootstarter.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllTopics(@PathVariable String id) {
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{id}/courses/{courseId}")
    public Optional<Course> getTopic(@PathVariable String id, @PathVariable String courseId) {
        return courseService.getCourse(courseId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{id}/courses")
    public Course addTopic(@RequestBody Course course, @PathVariable String id) {
        course.setTopic(new Topic(id, "", ""));
        return courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}/courses/{courseId}")
    public void editTopic(@RequestBody Course course, @PathVariable String id, @PathVariable String courseId) {
            course.setTopic(new Topic(id, "", ""));
            courseService.editCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}/courses/{id}")
    public void deleteTopic(@PathVariable String id) {
         courseService.deleteCourse(id);
    }

    public String mohamed(){
    	return "Mohamed";
    }
}
