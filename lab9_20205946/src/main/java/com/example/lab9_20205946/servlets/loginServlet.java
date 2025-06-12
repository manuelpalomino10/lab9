package com.example.lab9_20205946.servlets;

import com.example.lab9_20205946.daos.HashUtil;
import com.example.lab9_20205946.daos.UsuarioDAO;
import com.example.lab9_20205946.beans.usuarios;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/login")
public class loginServlet extends HttpServlet {

    private final UsuarioDAO usuarioDao = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String correo = request.getParameter("correo");
        String contraseña = request.getParameter("pass");

        String contraseñaHasheada = HashUtil.hashSHA256(contraseña);

        usuarios usuario = null; // Inicializar usuario fuera del try para que sea accesible


        // Llama a la función de validación con la contraseña ya hasheada
        usuario = usuarioDao.validarUsuario(correo, contraseñaHasheada);

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);

            response.sendRedirect(request.getContextPath() + "/hello-servlet");
        } else {
            request.setAttribute("errorMessage",
                    "Correo o contraseña incorrectos, o usuario inactivo");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
