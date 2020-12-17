package project.springboot.repository;

import project.springboot.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository <Event, Long > {

    List<Event> findAllByParticipantContainingOrCreatorEquals(String email, String creator);

    List<Event> findAllByCreatorEquals(String creator);

    Event findEventByCreatorEquals(String creator);
}
