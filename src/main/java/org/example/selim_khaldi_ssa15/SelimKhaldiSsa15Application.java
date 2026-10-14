package org.example.selim_khaldi_ssa15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"domain", "org.example.selim_khaldi_ssa15"})
public class SelimKhaldiSsa15Application {

    public static void main(String[] args) {
        SpringApplication.run(SelimKhaldiSsa15Application.class, args);
    }

}
