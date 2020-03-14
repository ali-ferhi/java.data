package it.infinispan1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.infinispan1.business.Service1;
import it.infinispan1.model.Entity1;

@RestController
@RequestMapping(value = "/service1")
public class ServiceRest {
	
	@Autowired
	Service1 service1;

	@GetMapping(value="/resource1/{id}")
	@ResponseBody
	public Entity1 get1(@PathVariable Integer id) {
		Entity1 toReturn = service1.get1(id);
		return toReturn;
	}
	
	@PostMapping(value="/resource1", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody()
	public String post1(@RequestBody String msg) {
		System.out.println("ServiceRest.post1.input.msg = " + msg);
		return "yes";
	}
	
}
