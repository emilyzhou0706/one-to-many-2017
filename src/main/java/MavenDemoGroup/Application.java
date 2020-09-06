package MavenDemoGroup;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import MavenDemoGroup.model.JpaSigner;
//H2Service;
//import MavenDemoGroup.repository.JpaSignerRepository;
import MavenDemoGroup.model.JpaTest;
import MavenDemoGroup.repository.H2Service;
import MavenDemoGroup.repository.JpaSignerRepository;

@SpringBootApplication
public class Application {
	public static void main(String[] args){
		SpringApplication.run(Application.class,args);
	}
	
	@Bean
	public CommandLineRunner mappingDemo(H2Service h2Service, JpaSignerRepository jpaSignerRepository){
		return args -> {
			JpaTest jpaTest = new JpaTest(987654213,"autolala","m");
			JpaSigner jpaSigner1=new JpaSigner("r1","contactName1","contactAddr1",987654213,jpaTest);
			JpaSigner jpaSigner2=new JpaSigner("r2","contactName2","contactAddr2",987654213,jpaTest);
			JpaSigner jpaSigner3=new JpaSigner("r3","contactName3","contactAddr3",987654213,jpaTest);
			
			jpaTest.getJpaSigner().add(jpaSigner1);
			jpaTest.getJpaSigner().add(jpaSigner2);
			jpaTest.getJpaSigner().add(jpaSigner3);
			
			jpaSignerRepository.save(jpaSigner1);
			jpaSignerRepository.save(jpaSigner2);
			jpaSignerRepository.save(jpaSigner3);
			h2Service.save(jpaTest);
		};
		
	
	}
	
	
	
}

