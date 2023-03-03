package com.customer_web.controller;

import com.customer_web.model.Customer;
import com.customer_web.service.CustomerService;
import com.customer_web.service.CustomerServicesImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@WebServlet(name = "CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    CustomerService service=new CustomerServicesImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomerForm(request,response);
                break;
            case "edit":
                editCustomerForm(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            case "view":
                break;
            default:
                listCustomer(request,response);
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        service.remove(Integer.parseInt(request.getParameter("id")));
        listCustomer(request, response);
    }

    private void editCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher=request.getRequestDispatcher("customer/edit.jsp");
        Customer customer=service.findById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("customer",customer);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher=request.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = this.service.findAll();
        request.setAttribute("list",customers);
        RequestDispatcher dispatcher=request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "create":
                createNewCustomer(request,response);
                break;
            case "edit":
                editCustomer(request,response);
                break;
            case "view":
                break;
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        service.update(id,new Customer(id,name,email,address));
        listCustomer(request,response);
    }

    private void createNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        String name=request.getParameter("name");
        int id=(int)(Math.random()*10000);
        service.save(new Customer(id,name,email,address));
        listCustomer(request,response);
    }
}
