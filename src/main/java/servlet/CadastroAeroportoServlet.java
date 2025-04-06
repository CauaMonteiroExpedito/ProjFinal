package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.AeroportoDao;
import modelo.Aeroportos;

@WebServlet("/cadastroAeroporto")
public class CadastroAeroportoServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
		
		
		// BUSCA OS PARAMETROS NO REQUEST
		    String nome = request.getParameter("nome");
	        int quantidadeTerminais = Integer.parseInt(request.getParameter("quantidadeTerminais"));
	        double tamanhoAreaTotal = Double.parseDouble(request.getParameter("tamanhoAreaTotal"));
	        int capacidadeAvioes = Integer.parseInt(request.getParameter("capacidadeAvioes"));
	        int torresControle = Integer.parseInt(request.getParameter("torresControle"));
	        int pistasVoo = Integer.parseInt(request.getParameter("pistasVoo"));
	        String localizacao = request.getParameter("localizacao");
	        

	        // Monta um objeto aeroporto
	        Aeroportos aeroporto = new Aeroportos();
	        aeroporto.setNome(nome);
	        aeroporto.setQuantidadeTerminais(quantidadeTerminais);
	        aeroporto.setTamanhoAreaTotal(tamanhoAreaTotal);
	        aeroporto.setCapacidadeAvioes(capacidadeAvioes);
	        aeroporto.setTorresControle(torresControle);
	        aeroporto.setPistasVoo(pistasVoo);
	        aeroporto.setLocalizacao(localizacao);

	        // Salva o aeroporto
	        AeroportoDao dao = new AeroportoDao();
	        dao.adiciona(aeroporto);
	        
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/aeroporto-adicionado.jsp");
			rd.forward(request,response);
		
	}

}
