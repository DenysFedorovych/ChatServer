package org.bitbucket.handlers;

import org.bitbucket.controllers.UserControllers;
import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.utils.JsonHelper;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UsersHandlers extends HttpServlet{
    private final UserControllers userControllers;

    public UsersHandlers(UserControllers userControllers) {
        this.userControllers = userControllers;
    }


    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            ServletOutputStream out = resp.getOutputStream();
            out.write(JsonHelper.toJson(this.userControllers.auth(new UserAuthorizationDto())).getBytes());
            out.flush();
            out.close();
        }
    }
