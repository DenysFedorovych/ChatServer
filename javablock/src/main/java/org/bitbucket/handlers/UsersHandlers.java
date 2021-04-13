package org.bitbucket.handlers;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bitbucket.controllers.UserControllers;
import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.exceptions.BadRequest;
import org.bitbucket.payload.Token;
import org.bitbucket.utils.JsonHelper;

import java.io.IOException;

public class UsersHandlers extends HttpServlet {

    private final UserControllers usersController;

    public UsersHandlers(UserControllers usersController) {
        this.usersController = usersController;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();

        Token result = usersController.auth(new UserAuthorizationDto());
        String str = JsonHelper.toFormat(result).orElseThrow(BadRequest::new);

        out.write(str.getBytes());
        out.flush();
        out.close();
    }
}
