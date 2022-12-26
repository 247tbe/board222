package com.nhnacademy.nhnboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeLanguageCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String lang = request.getParameter("lang");

        request.getSession().setAttribute("lang", lang);

        return "redirect:index.do";
    }
}
