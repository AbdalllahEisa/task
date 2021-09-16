package com.example.Apis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RestControllerApi {


    @GetMapping("/ticks")
    @ResponseBody
    public Double Prices() throws IOException {
        LocalDateTime timeing = LocalDateTime.now();
        long sec = 60 - timeing.getSecond();
        body[] b = null;
        List<Double> y = new ArrayList<>();
        double r = 0;
        if (sec >= 1) {
            ObjectMapper mapper = new ObjectMapper();

            b = mapper.readValue(new File("C:\\Users\\User\\Desktop\\Apis\\Apis\\src\\main\\resources\\static\\prices.json"), body[].class);

            for (body g : b) {
                y.add(g.getPrice());
            }
        }
        return y.get(0);

    }

    @GetMapping("/statistics")
    @ResponseBody
    public ResponseEntity<stastics> stasttics() throws IOException {
        LocalDateTime timeing = LocalDateTime.now();
        long sec = 60 - timeing.getSecond();
        body[] b = null;
        List<Double> y = new ArrayList<>();
        double r = 0;
        if (sec >= 0) {
            ObjectMapper mapper = new ObjectMapper();

            b = mapper.readValue(new File("C:\\Users\\User\\Desktop\\Apis\\Apis\\src\\main\\resources\\static\\prices.json"), body[].class);

            for (body g : b) {
                y.add(g.getPrice());
            }
        }
        int count = 0;
    double avg=0;
        double u = 0;
        double max = 0;
        double min=0;
for(double h:y){

    count++;
    u+=h;

}
        avg=u/count;

        for (int j =0; j < y.size(); j++) {
            if (y.get(0) >y.get((j-1)+1)) {
                max = y.get(0);

            }else{
              max=  y.get((j-1)+1);

            }
        }


        for (int j =  0; j < y.size(); j++) {
                if (y.get(0) >y.get((j-1)+1)) {
                    min = y.get((j-1)+1);

                }else{

                  min=  y.get(0);

                }
            }



        return new ResponseEntity<stastics>(new stastics(count,avg,max,min), HttpStatus.OK);


    }
    @GetMapping(" /statistics/{instrument_identifier}")
    @ResponseBody
    public ResponseEntity<stastics> stastticsidentifier(@PathVariable("instrument_identifier")String instrument) throws IOException {
        LocalDateTime timeing = LocalDateTime.now();
        long sec = 60 - timeing.getSecond();
        body[] b = null;
        List<Double> y = new ArrayList<>();
        double r = 0;
        if (sec >= 0&&instrument!=null) {
            ObjectMapper mapper = new ObjectMapper();

            b = mapper.readValue(new File("C:\\Users\\User\\Desktop\\Apis\\Apis\\src\\main\\resources\\static\\prices.json"), body[].class);

            for (body g : b) {
                y.add(g.getPrice());
            }
        }
        int count = 0;
        double avg=0;
        double u = 0;
        double max = 0;
        double min=0;
        for(double h:y){

            count++;
            u+=h;

        }
        avg=u/count;

        for (int j =0; j < y.size(); j++) {
            if (y.get(0) >y.get((j-1)+1)) {
                max = y.get(0);

            }else{
                max=  y.get((j-1)+1);

            }
        }


        for (int j =  0; j < y.size(); j++) {
            if (y.get(0) >y.get((j-1)+1)) {
                min = y.get((j-1)+1);

            }else{

                min=  y.get(0);

            }
        }



        return new ResponseEntity<stastics>(new stastics(count,avg,max,min), HttpStatus.OK);


    }


}




