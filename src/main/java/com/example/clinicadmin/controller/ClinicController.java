package com.example.clinicadmin.controller;

import com.example.clinicadmin.dto.ClinicDto;
import com.example.clinicadmin.entity.Specialization;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

//https://domain.com/clinic

// @Controller для html страниц
// @RestController: @Controller + @ResponseBody
@RestController
@RequestMapping("/clinic")
public class ClinicController {
    // {"name": "Больница №234" }"

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public /*тип данных*/int createClinic(@RequestBody ClinicDto clinicDto) {
        return 0;
    }

    //аннотация @ResponsBody уже содержится в @RestController
    //она отвечает за тип данных, который выводится в ответ клиенту


//@Controller
//@RequestMapping("/clinic")
//public class ClinicController {
//    @PostMapping
//    public String createClinic(){
//        return "clinic";
//    }
//}

//clinic_name: "Больница №234", id: 34
//@PostMapping
//public int createClinic(@RequestParam(name = "clinic_name") String name,
//                        @RequestParam(required = false) Integer id,
//@RequestParam(required=false, defaultValue ="false") boolean enable){
//    return 0;
//}

    //GET https://domain.com/clinic/name/Больница №43
    @GetMapping("/name/{clinicName}")
    public ClinicDto getByName(@PathVariable String clinicName) {
        return new ClinicDto();

    }

    //GET https://domain.com/clinic/filter?clinic_id=3
    //GET https://domain.com/clinic/filter?clinic_id=435
    @GetMapping("/filter")
    public ClinicDto getByParamId(@PathVariable String clinicName, int id) {
        return new ClinicDto();

    }

//    //GET https://domain.com/clinic?id=2
//    @GetMapping
//    public ClinicDto getById(@RequestParam int id){};

//GET http://domain.com/clinic/34
//GET http://domain.com/clinic/2
//GET http://domain.com/clinic/135

    @GetMapping("/{clinicId}")
    public ClinicDto getById(@PathVariable int clinicId) {
        return new ClinicDto();

    }

    @PostMapping
    public int createClinic01(@RequestBody(required = false) ClinicDto clinicDto) {
        if (clinicDto.getId() < 1)
            throw new ResponseStatusException(HttpStatusCode.valueOf(200));

        return 1;
    }

    @PostMapping
    public ResponseEntity<Integer> createClinic02(@RequestBody(required = false) ClinicDto clinicDto) {
        if (clinicDto != null && clinicDto.getId() < 1)
            throw new ResponseStatusException
                    (HttpStatusCode.valueOf(400), "Invalid clinic");
        HttpHeaders headers = new HttpHeaders();
        headers.add("имя", "значение");

        return new ResponseEntity<>(1, headers, HttpStatus.CREATED);
    }

    /*return ResponseEntity.created()
            .headers(headers)
    .body(clinicDto.getId());

    return ResponseEntity.ok()
            .header(headerName: "имя", ...headerValues: "значение")*/


}
