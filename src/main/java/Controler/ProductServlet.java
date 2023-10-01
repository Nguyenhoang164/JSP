package Controler;

import Model.Customer;
import Model.Product;
import Service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet",value = "/products")
public class ProductServlet extends HttpServlet {
    public static ProductServiceImpl productServlet = new ProductServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create" :
               createProduct(req,resp);
               break;
            case "edit" :
                updateProduct(req,resp);
                break;
            case "delete" :
                deleteProduct(req,resp);
                break;
            case "search" :
                searchProduct(req,resp);
                break;
            default:
                break;
        }
    }
    public void createProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String prize = request.getParameter("prize");
        String status = request.getParameter("status");
        String houseCreate = request.getParameter("houseCreate");
        int id = (int) (Math.random()*100000);
        productServlet.createProduct(new Product(id,name,prize,status,houseCreate));
        request.setAttribute("message","create new product suscess");
        request.getRequestDispatcher("product/create.jsp").forward(request,response);
    }
    public void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String prize = request.getParameter("prize");
        String status = request.getParameter("status");
        String houseCreate = request.getParameter("houseCreate");
        Product product =  productServlet.findById(id);
        if (product == null){
            request.getRequestDispatcher("product/error.jsp");
        }else{
            product.setName(name);
            product.setPrize(prize);
            product.setStatus(status);
            product.setHouseProduct(houseCreate);
            productServlet.updateProduct(id,product);
            request.setAttribute("product",product);
            request.setAttribute("message","update product complete");
            request.getRequestDispatcher("product/edit.jsp").forward(request,response);

        }
    }
    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productServlet.findById(id);

        if (product == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/error.jsp");
        } else {
            productServlet.deleteProduct(id);
            try {
                response.sendRedirect("/products");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void searchProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String prize = request.getParameter("prize");
        String status = request.getParameter("status");
        String houseProduct = request.getParameter("product");
        List<Product> listCheck = productServlet.findAll();
        List<Product> productList = new ArrayList<Product>();
        for (Product item: listCheck) {
            if (id == item.getId() || name.equals(item.getName()) || prize.equals(item.getPrize()) || status.equals(item.getStatus()) || houseProduct.equals(item.getHouseProduct())){
                productList.add(item);
            }
        }
        if (productList != null){
            request.setAttribute("listResult",productList);
            request.getRequestDispatcher("product/search.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("product/error.jsp").forward(request,response);
        }

    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String action = req.getParameter("action");
         if (action == null){
             action = "";
         }
             switch (action){
                 case "create" :
                      showFormCreate(req,resp);
                      break;
                 case "edit" :
                      showEditForm(req,resp);
                      break;
                 case "delete" :
                      showDeleteForm(req,resp);
                      break;
                 case "view" :
                      viewForm(req,resp);
                      break;
                 case "search" :
                     searchForm(req,resp);
                 default:
                     listProduct(req,resp);
                     break;
             }
         }
    public void showFormCreate(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("product/create.jsp").forward(request,response);
    }
    public void showEditForm(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productServlet.findById(id);
        if (product == null){
            request.getRequestDispatcher("product/error.jsp").forward(request,response);
        }else{
            request.setAttribute("product",product);
            request.getRequestDispatcher("product/edit.jsp").forward(request,response);
        }
    }
    public void showDeleteForm(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productServlet.findById(id);
        if (product == null){
            request.getRequestDispatcher("product/error.jsp").forward(request,response);
        }else {
            request.setAttribute("product",product);
            request.getRequestDispatcher("product/delete.jsp").forward(request,response);
        }

    }
    public void viewForm(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productServlet.findById(id);
        if (product == null){
            request.getRequestDispatcher("product/error").forward(request,response);
        }else {
            request.setAttribute("product",product);
            request.getRequestDispatcher("product/view.jsp").forward(request,response);
        }
    }
    public void searchForm(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("product/search.jsp").forward(request,response);

    }
    public void listProduct(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        List<Product> list = productServlet.findAll();
        request.setAttribute("list",list);
        request.getRequestDispatcher("product/list.jsp").forward(request,response);
    }

}
