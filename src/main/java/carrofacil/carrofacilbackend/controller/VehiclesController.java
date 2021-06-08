package carrofacil.carrofacilbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiclesController {

    @GetMapping(path = "/api/available")
    public String isAvailable() {
        return "Vehicle is available.";
    }

}
