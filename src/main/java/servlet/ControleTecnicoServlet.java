package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controleTecnico")
public class ControleTecnicoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		
		//String identificador = request.getParameter("identificador");
		String botao = request.getParameter("operacao");
		
		//System.out.println(identificador);
			
		
		
		try {
			
			//int id = Integer.parseInt(identificador);
			
			if (botao.equals("Novo Tecnico")) {
			
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/adiciona_tecnico.jsp");
				rd.forward(request,response);
			}
			
			if (botao.equals("Alterar")) {
			
				// Redireciona para o jsp mandar uma mensagem 
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/altera_tecnico.jsp");
				rd.forward(request,response);
				
				
			}
				  if (botao.equals("Excluir")) {
					  
					// Redireciona para o jsp mandar uma mensagem 
						RequestDispatcher rd = request.getRequestDispatcher("/removeTecnico");
						rd.forward(request,response);
				  
						/*
						 * // monta um objeto contato Contato contato = new Tecnico();
						 * contato.setId((long) id);
						 * 
						 * // salva o tecnico TecnicoDao dao = new TecnicoDao(); dao.remove(tecnico);
						 */
				 
			}			
			
		} catch (Exception ex) {
			
			// Redireciona para o jsp mandar uma mensagem 
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/mensagem-erro.jsp");
			rd.forward(request,response);
			
		
		}
	}


}
