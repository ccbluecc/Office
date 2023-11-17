package sit.int202.classicmodels_tue.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.classicmodels_tue.entities.Office;
import sit.int202.classicmodels_tue.repository.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeUpdateServlet", value = "/office-update")
public class OfficeUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        String officeCode = request.getParameter("officeCode");

        Office foundOffice = officeRepository.find(officeCode);
        request.setAttribute("offices", foundOffice);
        getServletContext().getRequestDispatcher("/office-update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {


            OfficeRepository officeRepository = new OfficeRepository();
            String officeCode = request.getParameter("officeCode");
            Office foundOffice = officeRepository.find(officeCode);
            if (foundOffice == null) {
                return;
            }

            String city = request.getParameter("city");
            String country = request.getParameter("country");
            String state = request.getParameter("state");
            String postalCode = request.getParameter("postalCode");
            String phone = request.getParameter("phone");
            String territory = request.getParameter("territory");
            String addressLine1 = request.getParameter("addressLine1");
            String addressLine2 = request.getParameter("addressLine2");

            Office newoffice = new Office();
            newoffice.setOfficeCode(officeCode);
            newoffice.setCity(city);
            newoffice.setCountry(country);
            newoffice.setState(state);
            newoffice.setPostalCode(postalCode);
            newoffice.setPhone(phone);
            newoffice.setTerritory(territory);
            newoffice.setAddressLine1(addressLine1);
            newoffice.setAddressLine2(addressLine2);
            officeRepository.update(newoffice);
            request.setAttribute("offices", newoffice);
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception to the console for debugging
            request.setAttribute("error", "Invalid Input");
        }
        response.sendRedirect(request.getContextPath() + "/office-list");
    }
}