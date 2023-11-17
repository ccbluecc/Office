package sit.int202.classicmodels_tue.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels_tue.entities.Employee;
import sit.int202.classicmodels_tue.entities.Office;
import sit.int202.classicmodels_tue.repository.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeDeleteServlet", value = "/office-delete")
public class OfficeDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/office-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            OfficeRepository officeRepository = new OfficeRepository();
            String officeCode = request.getParameter("officeCode");

            // Check if the office is deleted successfully
            if(officeCode != null) {
                request.setAttribute("offices", officeRepository.delete(officeCode));
            }
            // Retrieve the list of offices
            request.setAttribute("offices", officeRepository.findAll());
        } catch (Exception e) {
            e.printStackTrace();  // Log the exception to the console for debugging
            request.setAttribute("error", "Cannot delete this office. It have associated employees.");

        }
        getServletContext().getRequestDispatcher("/office-list.jsp").forward(request, response);
    }
}