package sit.int202.classicmodels_tue.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels_tue.entities.Product;
import sit.int202.classicmodels_tue.models.Cart;
import sit.int202.classicmodels_tue.models.ClassicModelLineItem;
import sit.int202.classicmodels_tue.repository.ProductRepository;

import java.io.IOException;

@WebServlet(name = "AddToCartServlet", value = "/add-to-cart")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productCode = request.getParameter("productCode");
        HttpSession session = request.getSession();
        Cart<String, ClassicModelLineItem> cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart<>();
            session.setAttribute("cart", cart);
        }
        ProductRepository productRepository = new ProductRepository();
        Product product = productRepository.findProduct(productCode);
        if (product != null) {
            cart.addItem(productCode, new ClassicModelLineItem(product));
        }
        response.getWriter().print(cart.getNoOfItem());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}