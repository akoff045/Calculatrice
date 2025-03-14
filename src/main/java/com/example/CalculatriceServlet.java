package com.example;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/*import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;*/

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CalculatriceServlet")
public class CalculatriceServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Récupération des valeurs du formulaire
        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String operation = request.getParameter("operation");
        double result = 0;
        String message = "";

        // Calcul selon l'opération choisie
        switch (operation) {
            case "addition":
                result = num1 + num2;
                break;
            case "soustraction":
                result = num1 - num2;
                break;
            case "multiplication":
                result = num1 * num2;
                break;
            case "division":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    message = "Erreur: Division par zéro!";
                }
                break;
            default:
                message = "Opération invalide!";
        }

        // Gestion de la session
        HttpSession session = request.getSession();
        String lastAccess = (String) session.getAttribute("lastAccess");
        String currentAccess = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        session.setAttribute("lastAccess", currentAccess);

        // Affichage du résultat
        out.println("<html><head><link rel='stylesheet' type='text/css' href='styles.css'></head><body>");
        out.println("<div class='container'>");
        out.println("<h2>Résultat de l'opération</h2>");
        if (message.isEmpty()) {
            out.println("<p>Le résultat de " + operation + " est : " + result + "</p>");
        } else {
            out.println("<p class='error'>" + message + "</p>");
        }
        
        if (lastAccess != null) {
            out.println("<p>Dernier accès : " + lastAccess + "</p>");
        }
        out.println("<a href='index.html' class='btn'>Retour</a>");
        out.println("</div>");
        out.println("</body></html>");
    }
}
