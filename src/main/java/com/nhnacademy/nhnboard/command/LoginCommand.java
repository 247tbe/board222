package com.nhnacademy.nhnboard.command;

import com.nhnacademy.nhnboard.domain.JoinUser;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> ids =
            (Map<String, String>) request.getServletContext().getAttribute("ids");
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        if (ids == null) {
            ids = new HashMap<>();
            request.getServletContext().setAttribute("ids", ids);
        }

        if (ids.containsKey(id)) {
            String initPwd = ids.get(id);
            if (pwd == null || !pwd.equals(initPwd) || !id.equals("admin")) {
                return "loginForm.jsp";
            }
        } else {
            ids.put(id, pwd);
            request.getServletContext().setAttribute("ids", id);

            JoinUser user = new JoinUser();
            request.getServletContext().setAttribute(id + "user", user);
        }

        request.getSession().setAttribute("loginID", id);
        request.setAttribute("loginID", id);

        return "login.jsp";
    }
}
