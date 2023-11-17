package sit.int202.classicmodels_tue.servlet;

import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.classicmodels_tue.entities.Office;
import sit.int202.classicmodels_tue.repository.OfficeRepository;

import java.io.IOException;

import static sit.int202.classicmodels_tue.repository.EntityManagerBuilder.getEntityManager;

@WebServlet(name = "OfficeInsertServlet", value = "/office-insert")
public class OfficeInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/office-insert.jsp").forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            OfficeRepository officeRepository = new OfficeRepository();
            String officeCode = String.valueOf(officeRepository.getNextId());
            String city = request.getParameter("city");
            String country = request.getParameter("country");
            String state = request.getParameter("state");
            String postalCode = request.getParameter("postalCode");
            String phone = request.getParameter("phone");
            String territory = request.getParameter("territory");
            String addressLine1 = request.getParameter("addressLine1");
            String addressLine2 = request.getParameter("addressLine2");

            Office office = new Office();
            office.setOfficeCode(officeCode);
            office.setCity(city);
            office.setCountry(country);
            office.setState(state);
            office.setPostalCode(postalCode);
            office.setPhone(phone);
            office.setTerritory(territory);
            office.setAddressLine1(addressLine1);
            office.setAddressLine2(addressLine2);

            boolean officeInsert = officeRepository.insert(office);
            if(officeInsert == false){
                request.setAttribute("error", "Invalid Input");
                getServletContext().getRequestDispatcher("/office-insert.jsp").forward(request, response);
            }
            request.setAttribute("offices", officeRepository.insert(office));
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception to the console for debugging
            request.setAttribute("error", "Invalid Input");

        }
        response.sendRedirect(request.getContextPath() + "/office-list");
    }
}