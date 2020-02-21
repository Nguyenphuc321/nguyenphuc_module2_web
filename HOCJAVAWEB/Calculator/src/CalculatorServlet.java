import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/caculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firtnumber = Integer.parseInt(request.getParameter("firtnumber"));
        float secondnumber = Integer.parseInt(request.getParameter("secondnumber"));
        char opert = request.getParameter("opert").charAt(0);
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Result:</h1>");
        try {
            float result = Calculator.caculator(firtnumber, secondnumber, opert);
            writer.println(firtnumber + " " + opert + " " + secondnumber + " = " + result);
        } catch (Exception ex) {
            writer.println("Error: " + ex.getMessage());
        }
        writer.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
