package MavenDemoGroup.repository;

import org.springframework.data.jpa.repository.*;

import MavenDemoGroup.model.JpaSigner;

public interface JpaSignerRepository extends JpaRepository<JpaSigner,Integer>{

}
