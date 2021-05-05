package org.bitbucket.handlers;

import org.bitbucket.controllers.UserControllers;
import org.bitbucket.dto.UserAuthorizationDto;
import org.bitbucket.dto.UserRegistrationDto;
import org.bitbucket.exceptions.BadRequest;
import org.bitbucket.exceptions.NotFound;
import org.bitbucket.utils.JsonHelper;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;


public class UsersHandlers extends HttpServlet {

    private final UserControllers userControllers;

    public UsersHandlers(UserControllers userControllers) {
        this.userControllers = userControllers;
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SERVICE");
        try {
            super.service(req, resp);
            System.out.println(req.getRequestURI());
        } catch (BadRequest e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid body.");
        } catch (NotFound e) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Not found.");
        }
    }

    @Override
    public void doOptions(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("DO OPTIONS");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        resp.setStatus(204);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("DO GET");
        ServletOutputStream out = resp.getOutputStream();
        String result = Optional.of(this.userControllers.auth(new UserAuthorizationDto())).orElseThrow(BadRequest::new);
        out.write(result.getBytes());
        out.flush();
        out.close();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("DO POST");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Allow-Headers", "*");
        String body = req.getReader().lines().collect(Collectors.joining());
        System.out.println(req.getHeader("Content-Type"));
        if (!req.getHeader("Content-Type").contains("application/json")) {
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Invalid content type");
        } else {
            String url = req.getRequestURI();
            System.out.println("Body : " + body);
            System.out.println(url);
            if (url.contains("/auth")) {
                System.out.println("AUTH");
                UserAuthorizationDto payload = JsonHelper.fromFormat(body, UserAuthorizationDto.class)
                        .orElseThrow(BadRequest::new);
                String result = Optional.of(this.userControllers.auth(payload)).orElseThrow(BadRequest::new);
                System.out.println(result);
                resp.setContentType("application/json");
                resp.setStatus(HttpServletResponse.SC_ACCEPTED);
                ServletOutputStream out = resp.getOutputStream();
                out.write(result.getBytes());
                out.flush();
                out.close();
                return;
            }

            if (url.contains("/registration")) {
                System.out.println("REG");
                UserRegistrationDto payload = JsonHelper.fromFormat(body, UserRegistrationDto.class)
                        .orElseThrow(BadRequest::new);
                this.userControllers.registration(payload);
                resp.setStatus(HttpServletResponse.SC_ACCEPTED);
            } else {
                System.out.println("BAD REQ");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        }
    }
}
