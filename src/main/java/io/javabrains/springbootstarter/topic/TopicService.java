package io.javabrains.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

     List<Topic> topics  = new ArrayList<>(Arrays.asList(
                new Topic("Spring", "Spring framework", "Spring framework description"),
                new Topic("SpringBoot", "Spring Boot", "Spring Boot description"),
                new Topic("SpringSecuirty", "Spring Security", "Spring Secuirty description")
     ));

     public List<Topic> getAlltopics() {
         List<Topic> topics = new ArrayList<>();
         topicRepository.findAll().forEach(topics::add);
         return topics;
     }

     public Optional<Topic> getTopic(String id) {
         //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

          return topicRepository.findById(id);
     }

     public Topic addTopic(Topic topic) {

         topicRepository.save(topic);
         return topic;
     }

     public void editTopic(String id, Topic topic) {
         topicRepository.save(topic);
     }

     public void deleteTopic(String id) {
        topicRepository.deleteById(id);
     }
}
