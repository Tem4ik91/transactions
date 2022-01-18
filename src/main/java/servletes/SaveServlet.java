package servletes;

import DAO.DAOImple;
import DAO.DAOImpleRoles;
import bd.RolesEntity;
import bd.UsersEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SaveServlet", value = "/SaveServlet")
public class SaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DAOImple daoImple = new DAOImple();
        DAOImpleRoles daoImpleRoles = new DAOImpleRoles();
        //INDEX.JSP
        if(request.getParameter("add") != null) { //при нажатии на кнопку add
            UsersEntity usersEntity = new UsersEntity();
            usersEntity.setId(Integer.parseInt(request.getParameter("id"))); //задаём ему id взятый из поля c именем id
            usersEntity.setLogin(request.getParameter("login"));
            daoImple.saveUsers(usersEntity);//сохраняем в базу данных полученный объект
            request.setAttribute("list", daoImple.getAll()); //создаём аттрибут который взял в себя всё что есть в базе данных
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp"); //перебрасываемся на list.jsp
            requestDispatcher.forward(request,response);
        }
        if (request.getParameter("showAll")!= null){ //при нажатии на кнопку showALL
            request.setAttribute("list",daoImple.getAll());
            request.setAttribute("listR",daoImpleRoles.getAllRoles());
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");//перебрасываемся на list.jsp
            requestDispatcher.forward(request,response);
        }
        //roles
        if(request.getParameter("addR") != null) { //при нажатии на кнопку add
            RolesEntity rolesEntity = new RolesEntity();
            rolesEntity.setId(Integer.parseInt(request.getParameter("idR"))); //задаём ему id взятый из поля c именем id
            rolesEntity.setName(request.getParameter("name"));
            daoImpleRoles.saveRoles(rolesEntity);//сохраняем в базу данных полученный объект
            request.setAttribute("listR", daoImpleRoles.getAllRoles()); //создаём аттрибут который взял в себя всё что есть в базе данных
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp"); //перебрасываемся на list.jsp
            requestDispatcher.forward(request,response);
        }
        if (request.getParameter("showAllR")!= null){ //при нажатии на кнопку showALL
            request.setAttribute("listR",daoImpleRoles.getAllRoles());
            request.setAttribute("list",daoImple.getAll());
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");//перебрасываемся на list.jsp
            requestDispatcher.forward(request,response);
        }

        //LIST.JSP
       String action = request.getParameter("action"); //создаём action который будет реагировать на те или иные действия
        if (action.equalsIgnoreCase("update")) {
            request.setAttribute("login",daoImple.getUserById(Integer.parseInt(request.getParameter("id"))));//создаём атрибут который по id возвращает определённого user
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("update.jsp");////перебрасываемся на update.jsp
            requestDispatcher.forward(request,response);
        }
        if (action.equalsIgnoreCase("delete")){//если action отреагировал на update
            daoImple.deleteUsers(Integer.parseInt(request.getParameter("id")));//удаляем по id
            request.setAttribute("list",daoImple.getAll());//создаём аттрибут который взял в себя всё что есть в базе данных
            request.setAttribute("listR",daoImpleRoles.getAllRoles());
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");//перебрасываемся на list.jsp
            requestDispatcher.forward(request,response);
        }
        //Roles
        if (action.equalsIgnoreCase("updateR")) {
            request.setAttribute("name",daoImpleRoles.getRolesId(Integer.parseInt(request.getParameter("id"))));//создаём атрибут который по id возвращает определённого user
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("updateR.jsp");////перебрасываемся на update.jsp
            requestDispatcher.forward(request,response);
        }
        if (action.equalsIgnoreCase("deleteR")){//если action отреагировал на update
            daoImpleRoles.deleteRoles(Integer.parseInt(request.getParameter("id")));//удаляем по id
            request.setAttribute("listR",daoImpleRoles.getAllRoles());//создаём аттрибут который взял в себя всё что есть в базе данных
            request.setAttribute("list",daoImple.getAll());
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");//перебрасываемся на list.jsp
            requestDispatcher.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOImple daoImple = new DAOImple();
        DAOImpleRoles daoImpleRoles = new DAOImpleRoles();

            // UPDATE.JSP
        if (request.getParameter("update") != null) {//при нажатии на кнопку update
            UsersEntity usersEntity = new UsersEntity();//создаём экземпляр класса
            usersEntity.setId(Integer.parseInt(request.getParameter("id")));//задаём id из поля id
            usersEntity.setLogin(request.getParameter("login"));//задаём name из поля login
            daoImple.update(usersEntity);//апдейтим
            request.setAttribute("list", daoImple.getAll());//создаём аттрибут который взял в себя всё что есть в базе данных
            request.setAttribute("listR", daoImpleRoles.getAllRoles());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");//перебрасываемся на list.jsp
            requestDispatcher.forward(request, response);
        }
        //roles
        if (request.getParameter("updateR") != null) {//при нажатии на кнопку update
            RolesEntity rolesEntity = new RolesEntity();//создаём экземпляр класса
            rolesEntity.setId(Integer.parseInt(request.getParameter("id")));//задаём id из поля id
            rolesEntity.setName(request.getParameter("name"));//задаём name из поля login
            daoImpleRoles.updateRoles(rolesEntity);//апдейтим
            request.setAttribute("listR", daoImpleRoles.getAllRoles());//создаём аттрибут который взял в себя всё что есть в базе данных
            request.setAttribute("list", daoImple.getAll());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");//перебрасываемся на list.jsp
            requestDispatcher.forward(request, response);
        }



    }
}
