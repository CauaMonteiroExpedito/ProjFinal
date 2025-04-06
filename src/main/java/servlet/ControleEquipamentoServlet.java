/**
 * 
 */
package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Serlet implementation class adicionaEquipamento
 */
@WebServlet("/controleEquipamento")
public class ControleEquipamentoServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String botao = request.getParameter("operacao");
	
		
		try {
			
			
			if (botao.equals("Novo Equipamento")) {

				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/visao/adiciona-equipamento.jsp");
				rd.forward(request,response);
				
			}
			
			if (botao.equals("Alterar")) {
				
				//redireciona para o jsp mandar mensagem
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/visao/altera-equipamento.jsp");
				rd.forward(request, response);
				
				
			}
			
			if (botao.equals("Excluir")) {
				
				RequestDispatcher rd = request.getRequestDispatcher("/removeEquipamento");
				rd.forward(request, response);
				
			}			
			
		} catch (Exception ex) {
			
			//Redireciona para o jsp mensagem de erro
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/visao/mensagem-erro.jsp");
			rd.forward(request, response);
			
		}
	}

}
