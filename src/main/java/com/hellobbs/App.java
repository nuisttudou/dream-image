//package com.hellobbs;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class App {
//    public static void main(String[] args){
//        SpringApplication.run(App.class,args);
//    }
//}
package com.hellobbs;

import com.hellobbs.filedemo.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
