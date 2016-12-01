package com.upe.snu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, ModelMap model) {

        if (error != null) {
            model.put("error", "Usuario e senha invalidos");
        }

        if (logout != null) {
            model.put("msg", "Logoff com sucesso.");
        }

		return "login";
	}
}