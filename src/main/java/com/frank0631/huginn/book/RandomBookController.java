package com.frank0631.huginn.book;

import com.frank0631.nidhogg.book.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.*;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.*;

@RepositoryRestController
public class RandomBookController implements ResourceProcessor<RepositorySearchesResource>{

    @Autowired private EntityLinks entityLinks;
    @Autowired private BookRepository bookRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/books/search/getrandombook")
	public @ResponseBody ResponseEntity<?> getRandomBook(
		@RequestParam(value = "title", required = false) String title,
		PersistentEntityResourceAssembler assembler){
			BookEntity book = bookRepository.giveRandomBook(title);
			ResponseEntity respone = (book == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(assembler.toResource(book)));
			return respone;
    }
    
    @Override
    public RepositorySearchesResource process(RepositorySearchesResource resource) {
        LinkBuilder lb = entityLinks.linkFor(BookEntity.class, "title");
        resource.add(new Link(lb.toString() + "/search/getrandombook{?title}", "getrandombook"));
        return resource;
    }

}