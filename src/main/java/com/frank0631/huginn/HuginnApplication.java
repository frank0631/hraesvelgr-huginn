package com.frank0631.huginn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import org.springframework.boot.autoconfigure.domain.*;
import javax.persistence.*;

@SpringBootApplication
@ComponentScan
public class HuginnApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(HuginnApplication.class, args);
    }
    
}
