package com.tutorial.spring.security.controller;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

import com.tutorial.spring.security.model.Foo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FooController {
    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping(value = "/foos/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Foo findById(@PathVariable long id) {
        return new Foo(Long.parseLong(randomNumeric(2)), randomAlphabetic(4));
    }
}
