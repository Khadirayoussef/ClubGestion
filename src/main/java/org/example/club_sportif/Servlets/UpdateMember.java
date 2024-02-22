package org.example.club_sportif.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.club_sportif.Entities.Groupe;
import org.example.club_sportif.Entities.Membre;
import org.example.club_sportif.Entities.Sport;
import org.example.club_sportif.Repository.GroupeRepository;
import org.example.club_sportif.Repository.MembreRepository;
import org.example.club_sportif.Repository.SportRepository;

import java.io.IOException;

@WebServlet("/updateMember")
public class UpdateMember extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int memberId=Integer.parseInt(req.getParameter("idMember"));
        MembreRepository membreRepository=new MembreRepository();
        Membre targetMembre=membreRepository.findById(memberId);
        int sportId=Integer.parseInt(req.getParameter("group"));
        SportRepository sportRepository=new SportRepository();
        Sport targetSport=sportRepository.findById(sportId);
        int groupId=Integer.parseInt(req.getParameter("group"));
        GroupeRepository groupeRepository=new GroupeRepository();
        Groupe targetGroup=groupeRepository.findById(groupId);
        targetMembre.setGroupe(targetGroup);
        targetMembre.setSports(targetSport);

        membreRepository.update(targetMembre);

        req.getRequestDispatcher("admin.jsp").forward(req,resp);

    }
}
