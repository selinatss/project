package com.prototype.bootsoap;



import model.Key;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@RestController
public class BootsoapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootsoapApplication.class, args);
    }

      List<Key> keyValueList = new ArrayList<Key>(Arrays.asList(
            new Key("key1", "1"),
            new Key("key2", "2"),
            new Key("key3", "3")
    ));

    @RequestMapping("/getAllValues")
    public List<Key> getAllValues() {
        LOG.debug("log1");
        return keyValueList;
    }

    @RequestMapping("/getValue/{id}")
    public  Key getValue(@PathVariable String id){
        LOG.debug("log2");
        return keyValueList.stream().filter(t -> t.getId().equals(id)).findFirst().get();

    }
    private static final Logger LOG = LoggerFactory.getLogger(BootsoapApplication.class);

}
