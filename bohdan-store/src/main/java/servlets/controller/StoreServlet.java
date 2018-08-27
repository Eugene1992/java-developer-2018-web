package servlets.controller;

import dao.model.Product;
import dao.service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/store")
public class StoreServlet extends HttpServlet {

    public static final String CARTED_PRODUCTS = "cartedProducts";
    private static final String LOGIN_JSP = "/login.jsp";
    private static final String ACTION = "action";
    private static final String LOGOUT = "logout";
    private static final String UPDATE = "update";
    private static final String ID_UPD = "idUpd";
    private static final String UPDATED_PRODUCT = "updatedProduct";
    private static final String DELETE = "delete";
    private static final String ID_DEL = "idDel";
    private static final String DELETED_PRODUCT = "deletedProduct";
    private static final String SEARCH = "search";
    private static final String PRODUCTS = "products";
    private static final String STORE_JSP = "/store.jsp";
    private static final String DELETE_CANCEL = "deleteCancel";
    private static final String UPDATE_CANCEL = "updateCancel";
    private static final String ID_CR = "idCr";
    private static final String NAME_CR = "nameCr";
    private static final String PRICE_CR = "priceCr";
    private static final String IMAGE_CR = "imageCr";
    private static final String NAME_UPD = "nameUpd";
    private static final String PRICE_UPD = "priceUpd";
    private static final String IMAGE_UPD = "imageUpd";
    private static final String ID = "id";
    private List<Product> cartedProducts;
    //private Map<Integer, String> cartedProducts = new TreeMap<>();
    private ProductService productService;
    private List<Product> products;

    @Override
    public void init() {
        productService = new ProductService();
        products = productService.getAllProducts();
        cartedProducts = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            //cartedProducts.putIfAbsent(Integer.valueOf(cookie.getName()), cookie.getValue());
            cartedProducts.add(productService.getProduct(Integer.parseInt(cookie.getName())));
        }

        req.setAttribute(CARTED_PRODUCTS, cartedProducts);

        String action = req.getParameter(ACTION);
        if (action != null) {
            switch (action) {
                case LOGOUT:
                    req.getSession(false).invalidate();
                    req.getRequestDispatcher(LOGIN_JSP).forward(req, resp);
                    break;
                case UPDATE:
                    String idUpd = req.getParameter(ID_UPD);
                    Product updatedProduct = productService.getProduct(Integer.parseInt(idUpd));
                    req.setAttribute(UPDATED_PRODUCT, updatedProduct);
                    break;
                case DELETE:
                    String idDel = req.getParameter(ID_DEL);
                    Product deletedEmployee = productService.getProduct(Integer.parseInt(idDel));
                    req.setAttribute(DELETED_PRODUCT, deletedEmployee);
                    break;
            }
        }

        String search = req.getParameter(SEARCH);
        if (search != null) {
            products = productService.getProductsByName(search);
        } else {
            products = productService.getAllProducts();
        }

        req.setAttribute(PRODUCTS, products);
        req.getRequestDispatcher(STORE_JSP).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter(ACTION);
        if (action != null) {
            switch (action) {
                case DELETE_CANCEL:
                    req.removeAttribute(DELETED_PRODUCT);
                    req.getRequestDispatcher(STORE_JSP).forward(req, resp);
                    break;
                case UPDATE_CANCEL:
                    req.removeAttribute(UPDATED_PRODUCT);
                    req.getRequestDispatcher(STORE_JSP).forward(req, resp);
                    break;
            }
        }

        String idCr = req.getParameter(ID_CR);
        if (idCr != null) {
            String nameCr = req.getParameter(NAME_CR);
            Integer price = Integer.valueOf(req.getParameter(PRICE_CR));
            String imageCr = req.getParameter(IMAGE_CR);
            Product product = new Product(nameCr, price, imageCr);
            productService.createProduct(product);
            req.getRequestDispatcher(STORE_JSP).forward(req, resp);
        }

        String idDel = req.getParameter(ID_DEL);
        if (idDel != null) {
            productService.deleteProduct(Integer.parseInt(idDel));
            req.getRequestDispatcher(STORE_JSP).forward(req, resp);
        }
        String idUpd = req.getParameter(ID_UPD);
        if (idUpd != null) {
            String nameUpd = req.getParameter(NAME_UPD);
            Integer priceUpd = Integer.valueOf(req.getParameter(PRICE_UPD));
            String imageUpd = req.getParameter(IMAGE_UPD);
            Product product = new Product(nameUpd, priceUpd, imageUpd);
            product.setId(Integer.parseInt(idUpd));
            productService.updateProduct(product);
            req.getRequestDispatcher(STORE_JSP).forward(req, resp);
        }

        String id = req.getParameter(ID);
        if (id != null) {
            Product product = productService.getProduct(Integer.parseInt(id));
            Cookie cookie = new Cookie(String.valueOf(product.getId()), product.getName());
            cookie.setMaxAge(600);
            resp.addCookie(cookie);
        }

        req.setAttribute(PRODUCTS, productService.getAllProducts());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(STORE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
