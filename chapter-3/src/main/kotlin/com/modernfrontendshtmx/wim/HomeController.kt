package com.modernfrontendshtmx.wim

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.LocalTime

@Controller
class HomeController {

    @GetMapping("/")
    fun index(): String {
        return "index"
    }

    @GetMapping("/htmx")
    fun htmx(@RequestParam(value ="delay", required = false) delayInSeconds: Int?,
             model: Model,
             request: HttpServletRequest): String {

        val elementId = request.getHeader("HX-Request")
        println("elementId: $elementId")
        if(delayInSeconds != null) {
            Thread.sleep(delayInSeconds * 1000L)
        }
        model.addAttribute("currentTime", LocalTime.now())
        return "htmx :: message";
    }

}