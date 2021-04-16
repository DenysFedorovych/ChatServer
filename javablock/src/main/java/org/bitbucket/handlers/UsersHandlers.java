package org.bitbucket.handlers;

import org.bitbucket.controllers.UserControllers;
import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.exceptions.BadRequest;
import org.bitbucket.exceptions.NotFound;
import org.bitbucket.payload.Token;
import org.bitbucket.utils.JsonHelper;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class UsersHandlers extends HttpServlet {

    private final UserControllers userControllers;

    public UsersHandlers(UserControllers userControllers) {
        this.userControllers = userControllers;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            super.service(req, resp);
        } catch (BadRequest e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,"Invalid body.");
        } catch (NotFound e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Not found.");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletOutputStream out = resp.getOutputStream();
        Token result = this.userControllers.auth(new UserAuthorizationDto());
        String str = JsonHelper.toFormat(result).orElseThrow(BadRequest::new);
        out.write(str.getBytes());
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        if (!"application/json".equalsIgnoreCase(req.getHeader("Content-Type"))) {
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Invalid content type");
        } else {
            ServletOutputStream out = resp.getOutputStream();
            String body = req.getReader().lines().collect(Collectors.joining());
            System.out.println("Body : " + body);
            UserAuthorizationDto payload = JsonHelper.fromFormat(body, UserAuthorizationDto.class)
                    .orElseThrow(BadRequest::new);
            Token result = this.userControllers.auth(payload);
            String str = JsonHelper.toFormat(result).orElseThrow(BadRequest::new);
            resp.setContentType("application/json");
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
            out.write(str.getBytes());
            out.flush();
            out.close();
        }
    }


}
