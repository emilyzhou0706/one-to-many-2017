package MavenDemoGroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import MavenDemoGroup.model.JpaTest;

public interface H2Service extends JpaRepository<JpaTest,Integer>{

}
