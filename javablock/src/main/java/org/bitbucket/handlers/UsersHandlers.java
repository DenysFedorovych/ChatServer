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
import java.util.stream.Collectors;

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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            if (!"aplication/json".equalsIgnoreCase(req.getHeader("Content-type"))) {
                res.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Invalid content type");
            } else {
                ServletOutputStream out = res.getOutputStream();
                String body = req.getReader().lines().collect(Collectors.joining());
                System.out.println("Body" + body);
                UserAuthorizationDto payload = JsonHelper.fromFormat(body, UserAuthorizationDto.class)
                        .orElseThrow(BadRequest::new);
                Token token = this.usersController.auth(payload);
                String str = JsonHelper.toFormat(token).orElseThrow(BadRequest::new);
                res.setContentType("application/json");
                res.setStatus(HttpServletResponse.SC_ACCEPTED);
                out.write(str.getBytes());
                out.flush();
                out.close();
            }
        } catch (BadRequest e) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid body");
        }
    }
}
