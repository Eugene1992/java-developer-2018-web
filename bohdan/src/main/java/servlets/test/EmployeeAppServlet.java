package servlets.test;

import jdbc.Employee;
import jdbc.dao.EmployeeDao;
import jdbc.dao.EmployeeDaoJDBCImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static servlets.test.LoginServlet.LOGIN_JSP;


public class EmployeeAppServlet extends HttpServlet {

    public static final String INDEX_JSP = "/index.jsp";
    private static final String EMPLOYEES = "employees";
    private static final String PAGE_AMOUNT = "pageAmount";
    private static final String ACTION = "action";
    private static final String SEARCH = "search";
    private static final String PAGE = "page";
    private static final String SORT = "sort";
    private static final String LOGOUT = "logout";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String AGE = "age";
    private static final String SALARY = "salary";
    private static final String IS_MARRIED = "isMarried";
    private static final String POSITION = "position";
    private static final String UPDATED_EMPLOYEE = "updatedEmployee";
    private static final String ID = "id";
    private static final String UPDATE = "update";
    private static final String UPDATE_CANCEL = "updateCancel";
    private static final String DELETED_EMPLOYEE = "deletedEmployee";
    private static final String DELETE = "delete";
    private static final String DELETE_CANCEL = "deleteCancel";
    private static final String ID_DEL = "idDel";
    private static final String ID_UPD = "idUpd";
    private static final String FIRST_NAME_UPD = "firstNameUpd";
    private static final String LAST_NAME_UPD = "lastNameUpd";
    private static final String AGE_UPD = "ageUpd";
    private static final String SALARY_UPD = "salaryUpd";
    private static final String IS_MARRIED_UPD = "isMarriedUpd";
    private static final String POSITION_UPD = "positionUpd";

    private List<Employee> employees;
    private EmployeeDao crud;

    @Override
    public void init() {
        crud = new EmployeeDaoJDBCImpl();
        employees = crud.getEmployeesPage(1, "asc");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter(ACTION);
        if (action != null) {
            switch (action) {
                case LOGOUT:
                    req.getSession(false).invalidate();
                    req.getRequestDispatcher(LOGIN_JSP).forward(req, resp);
                    break;
                case UPDATE:
                    String idUpd = req.getParameter(ID_UPD);
                    Employee updatedEmployee = crud.get(Integer.parseInt(idUpd));
                    req.setAttribute(UPDATED_EMPLOYEE, updatedEmployee);
                    break;
                case DELETE:
                    String idDel = req.getParameter(ID_DEL);
                    Employee deletedEmployee = crud.get(Integer.parseInt(idDel));
                    req.setAttribute(DELETED_EMPLOYEE, deletedEmployee);
                    break;
            }
        }
        req.setAttribute(PAGE_AMOUNT, crud.getAll().size() / 10 + 1);


        HttpSession session = req.getSession(false);


        String search = req.getParameter(SEARCH);
        if (search != null) {
            employees = crud.getByName(search);
        } else {
            int pageNum;
            if (session.getAttribute(PAGE) == null) {
                String page = req.getParameter(PAGE);
                pageNum = page != null ? Integer.parseInt(page) : 1;
                session.setAttribute(PAGE, pageNum);
            } else {
                if (req.getParameter(PAGE) != null) {
                    session.setAttribute(PAGE, req.getParameter(PAGE));
                }
                pageNum = Integer.parseInt(session.getAttribute(PAGE).toString());
            }


            String sort;
            if (session.getAttribute(SORT) == null) {
                sort = req.getParameter(SORT);
                session.setAttribute(SORT, sort);
            } else {
                if (req.getParameter(SORT) != null) {
                    session.setAttribute(SORT, req.getParameter(SORT));
                }
                sort = session.getAttribute(SORT).toString();
            }
            if (sort != null) {
                employees = crud.getEmployeesPage(pageNum, sort);
            } else {
                employees = crud.getEmployeesPage(pageNum, "asc");
            }
        }


        req.setAttribute(EMPLOYEES, employees);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(INDEX_JSP);
        requestDispatcher.include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(ACTION);
        if (action != null) {
            switch (action) {
                case DELETE_CANCEL:
                    req.removeAttribute(DELETED_EMPLOYEE);
                    req.getRequestDispatcher(INDEX_JSP).forward(req, resp);
                    break;
                case UPDATE_CANCEL:
                    req.removeAttribute(UPDATED_EMPLOYEE);
                    req.getRequestDispatcher(INDEX_JSP).forward(req, resp);
                    break;
            }
        }

        String id = req.getParameter(ID);
        if (id != null) {
            String firstName = req.getParameter(FIRST_NAME);
            String lastName = req.getParameter(LAST_NAME);
            Integer age = Integer.valueOf(req.getParameter(AGE));
            Integer salary = Integer.valueOf(req.getParameter(SALARY));
            Boolean isMarried = req.getParameter(IS_MARRIED) != null;
            String position = req.getParameter(POSITION);
            Employee employee = new Employee(firstName, lastName, age, salary, isMarried, position);
            crud.create(employee);
            req.getRequestDispatcher(INDEX_JSP).forward(req, resp);
        }

        String idDel = req.getParameter(ID_DEL);
        if (idDel != null) {
            crud.delete(Integer.parseInt(idDel));
            req.getRequestDispatcher(INDEX_JSP).forward(req, resp);
        }
        String idUpd = req.getParameter(ID_UPD);
        if (idUpd != null) {
            String firstNameUpd = req.getParameter(FIRST_NAME_UPD);
            String lastNameUpd = req.getParameter(LAST_NAME_UPD);
            Integer ageUpd = Integer.valueOf(req.getParameter(AGE_UPD));
            Integer salaryUpd = Integer.valueOf(req.getParameter(SALARY_UPD));
            Boolean isMarriedUpd = req.getParameter(IS_MARRIED_UPD) != null;
            String positionUpd = req.getParameter(POSITION_UPD);
            Employee employeeUpd = new Employee(firstNameUpd, lastNameUpd, ageUpd, salaryUpd, isMarriedUpd, positionUpd);
            employeeUpd.setId(Integer.parseInt(idUpd));
            crud.update(employeeUpd);
            req.getRequestDispatcher(INDEX_JSP).forward(req, resp);
        }

        req.setAttribute(EMPLOYEES, crud.getAll());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(INDEX_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        crud.close();
    }
}
