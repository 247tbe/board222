package com.nhnacademy.nhnboard.command;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String id = (String) request.getSession().getAttribute("loginID");

        if (!Objects.isNull(id)) {
            request.setAttribute("loginID", id);
        }

        return "index.jsp";
    }
}
