package io.uslab.offers.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvironmentController {

    private final String port;
    private final String cfInstanceGuid;
    private final String cfInstanceIp;
    private final String cfInstancePort;
    private final String home;

    public EnvironmentController(
            @Value("${PORT:NOT SET}") String port,
            @Value("${CF_INSTANCE_GUID:NOT SET}") String cfInstanceGuid,
            @Value("${CF_INSTANCE_IP:NOT SET}") String cfInstanceIp,
            @Value("${CF_INSTANCE_PORT:NOT SET}") String cfInstancePort,
            @Value("${HOME:NOT SET}") String home
    ){
        this.port = port;
        this.cfInstanceGuid = cfInstanceGuid;
        this.cfInstanceIp = cfInstanceIp;
        this.cfInstancePort = cfInstancePort;
        this.home = home;
    }

    @GetMapping("/env")
    public Map<String, String> getEnvironment() {
        Map<String, String>  map = new HashMap<>();
        map.put("PORT", port);
        map.put("CF_INSTANCE_GUID", cfInstanceGuid);
        map.put("CF_INSTANCE_IP", cfInstanceIp);
        map.put("CF_INSTANCE_PORT", cfInstancePort);
        map.put("HOME", home);
        return map;
    }
}
