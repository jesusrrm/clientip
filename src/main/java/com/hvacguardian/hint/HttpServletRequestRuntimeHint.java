package com.hvacguardian.hint;

import org.springframework.aot.hint.ProxyHints;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;

import jakarta.servlet.http.HttpServletRequest;

public class HttpServletRequestRuntimeHint implements RuntimeHintsRegistrar{

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
    try {
        ProxyHints proxies = hints.proxies();
        proxies.registerJdkProxy(HttpServletRequest.class);
    } catch (Exception e) {
        throw new RuntimeException("Could not register RuntimeHint: " + e.getMessage());
    }
    }

}
