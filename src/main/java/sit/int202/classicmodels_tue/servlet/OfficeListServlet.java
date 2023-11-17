package sit.int202.classicmodels_tue.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels_tue.entities.Office;
import sit.int202.classicmodels_tue.repository.OfficeRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@WebServlet(name = "OfficeListServlet", value = "/office-list")
public class OfficeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            OfficeRepository officeRepository = new OfficeRepository();
            request.setAttribute("offices", officeRepository.findAll());
            String officeCode = request.getParameter("officeCode");
            String cityOrCountry = request.getParameter("cityOrCountry");
            if (cityOrCountry != null && !cityOrCountry.isEmpty()) {
                List<Office> matchingOffices = officeRepository.findByCityOrCountry(cityOrCountry);
                if (!matchingOffices.isEmpty()) {
                    request.setAttribute("offices", matchingOffices);
                } else {
                    request.setAttribute("errorCityOrCountry", "No offices found for the specified City/Country name " + cityOrCountry +".");
                }
            } else if (officeCode != null) {
                request.setAttribute("selectedOffice", officeRepository.find(officeCode));
            }
//        getServletContext().getRequestDispatcher("/new-office-list.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception to the console for debugging
            String cityOrCountry = request.getParameter("cityOrCountry");
            request.setAttribute("errorCityOrCountry", "No offices found for the specified City/Country name " + cityOrCountry +".");

        }
        getServletContext().getRequestDispatcher("/office-list.jsp").forward(request, response);
    }
}
