package org.example.club_sportif.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.club_sportif.Entities.Entraineur;
import org.example.club_sportif.Entities.Groupe;
import org.example.club_sportif.Repository.EntraineurRepository;
import org.example.club_sportif.Repository.GroupeRepository;

import java.io.IOException;

@WebServlet("/addGroup")
public class addGroup extends HttpServlet {
    EntraineurRepository entraineurRepository;
    GroupeRepository groupeRepository;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        entraineurRepository=new EntraineurRepository();
        groupeRepository=new GroupeRepository();
        String category=req.getParameter("category");
        int idTrainer=Integer.parseInt(req.getParameter("trainerId"));
        Entraineur e=entraineurRepository.findById(idTrainer);
        Groupe group=new Groupe();
        group.setEntraineur(e);
        group.setCategorie(category);
        groupeRepository.save(group);
        req.getRequestDispatcher("admin.jsp").forward(req,resp);

    }
}
