package Controller;

import Dao.CustomerDao;
import Model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/create":
                createCustomer(request, response);
                break;
            case "/update":
                updateCustomer(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/new":
                showNewFrom(request, response);
                break;
            case "/delete":
                deleteCustomerById(request, response);
                break;
            case "/edit":
                showEditFrom(request, response);
                break;
            default:
                //mặt định tất cả các action trên đều trả về trang list
                listCustomer(request, response);
                break;
        }
    }

    //viết phương thức lấy dữ liệu và trả về trang list
    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> listCustomer = CustomerDao.getAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/index.jsp");
        dispatcher.forward(request, response);
    }

    //viết phương thức delete customer theo id
    private void deleteCustomerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCustomer = Integer.parseInt(request.getParameter("id"));
        CustomerDao.deleteCustomer(idCustomer);
        response.sendRedirect("/");
    }

    //viết phương thức hiển thị trang thêm mới customer
    private void showNewFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/newCustomer.jsp");
        dispatcher.forward(request, response);
    }

    //viết phương thức lưu thông tin customer vào data thông qua dopost
    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer checkCustomer = CustomerDao.getCustomer(id);
        if (checkCustomer == null) {
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            Customer newCustomer = new Customer(id, name, phone, email);
            CustomerDao.addCustomer(newCustomer);
            response.sendRedirect("/");
        } else {
            String message = " this Id already exits";
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            Customer ExitCustomer = new Customer(id, name, phone, email);
            request.setAttribute("message", message);
            request.setAttribute("customer", ExitCustomer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/newCustomer.jsp");
            dispatcher.forward(request, response);
        }
    }

    //viết phương thức hiển thị trang edit
    private void showEditFrom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customerEdit = CustomerDao.getCustomer(id);
        request.setAttribute("customer", customerEdit);

        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/editCustomer.jsp");
        dispatcher.forward(request, response);
    }

    //viết phương thức update customer
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Customer updateCustomer = new Customer(id, name, phone, email);
        CustomerDao.addCustomer(updateCustomer);
        response.sendRedirect("list");
    }
}
