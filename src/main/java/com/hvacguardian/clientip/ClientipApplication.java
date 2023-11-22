package com.hvacguardian.clientip;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;



@RestController
@SpringBootApplication
public class ClientipApplication {

	@Autowired
	private HttpServletRequest request;

    static class IpResponse {
        private String ipAddress;

        public IpResponse(String ipAddress) {
            this.ipAddress = ipAddress;
        }

        public String getIpAddress() {
            return ipAddress;
        }
    }

    @GetMapping("/get-ip")
    public IpResponse getClientIp(HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        return new IpResponse(clientIp);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ClientipApplication.class, args);
	}

}
