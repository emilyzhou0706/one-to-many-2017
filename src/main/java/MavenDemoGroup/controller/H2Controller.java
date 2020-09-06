package MavenDemoGroup.controller;
import MavenDemoGroup.*;
import MavenDemoGroup.repository.H2Service;
import MavenDemoGroup.repository.JpaSignerRepository;
import MavenDemoGroup.model.JpaSigner;
import MavenDemoGroup.model.JpaTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("JAPA")
public class H2Controller {
	@Autowired
	private H2Service service;
	
	@Autowired
	private JpaSignerRepository jpaSignerRepository;
	
	@GetMapping("/employees")
	List<JpaTest> findAll(){
		System.out.println("i am in the link");
		List<JpaTest> jpaTestList=service.findAll();
		List<JpaTest> jpaTestListOutput=new ArrayList<>();
		Iterator<JpaTest> it=jpaTestList.iterator();
		while(it.hasNext()){
			JpaTest jpaTest=(JpaTest)it.next();
			Set<JpaSigner> jpaSignersOut=new HashSet<JpaSigner>();
			//loop for each jpaSigner of a specific jpaTest
			for(JpaSigner jpaSigner:jpaTest.getJpaSigner()){
				jpaSignersOut.add(jpaSigner);
				System.out.println("jpaSigner="+jpaSigner);
			}
			JpaTest jpaTestOutput=new JpaTest(jpaTest.getId(),jpaTest.getName(),jpaTest.getSex(),jpaSignersOut);
			System.out.println("jpaTestOutput="+jpaTestOutput.toString());
			jpaTestListOutput.add(jpaTestOutput);
			System.out.println("jpaTestListOutput="+jpaTestListOutput.toString());
		}
		
		return jpaTestListOutput;
	}
}
