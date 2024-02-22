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

@WebServlet("/updateGroup")
public class updateGroup extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int targetGroupeId=Integer.parseInt(req.getParameter("groupeId"));
            GroupeRepository groupeRepository=new GroupeRepository();
        Groupe groupe=groupeRepository.findById(targetGroupeId);
        String category=req.getParameter("category");
        int trainerId=Integer.parseInt(req.getParameter("trainer"));
        EntraineurRepository entraineurRepository=new EntraineurRepository();
        Entraineur e=entraineurRepository.findById(trainerId);

        groupe.setEntraineur(e);
        groupe.setCategorie(category);
        groupeRepository.save(groupe);

        req.getRequestDispatcher("admin.jsp").forward(req,resp);
    }
}
