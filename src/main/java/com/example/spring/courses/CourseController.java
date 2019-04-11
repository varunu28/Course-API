package com.example.spring.courses;

import com.example.spring.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllTopics(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}

	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}

	@RequestMapping(method = RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		System.out.println("ADD COURSE");
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
