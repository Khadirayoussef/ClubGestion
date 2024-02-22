package org.example.club_sportif.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Bool;
import org.example.club_sportif.Entities.Endroit;
import org.example.club_sportif.Entities.Sport;
import org.example.club_sportif.Repository.EndroitRepository;
import org.example.club_sportif.Repository.SportRepository;

import java.io.IOException;

@WebServlet("/updateFacility")
public class UpdateFacility extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int targetFacilityId=Integer.parseInt(req.getParameter("facilityId"));
        EndroitRepository endroitRepository=new EndroitRepository();
        Endroit targetFacility=endroitRepository.findById(targetFacilityId);
        String name=req.getParameter("name");
        SportRepository sportRepository=new SportRepository();
        int idSport=Integer.parseInt(req.getParameter("sport"));
        Sport sport=sportRepository.findById(idSport);
        Boolean dispo;
        if(req.getParameter("access").equalsIgnoreCase("available")){
            dispo=true;
        }
        else {
            dispo=false;
        }
        targetFacility.setSport(sport);
        targetFacility.setNomEndroit(name);
        targetFacility.setDisponibilite(dispo);
        endroitRepository.update(targetFacility);
        req.getRequestDispatcher("admin.jsp").forward(req,resp);
    }

}
