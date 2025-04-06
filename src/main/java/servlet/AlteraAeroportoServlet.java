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

@WebServlet("/alteraAeroporto")
public class AlteraAeroportoServlet extends HttpServlet{
	
	private static final long serialVersionUID = 9100795197695392325L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String quantidadeTerminais = request.getParameter("quantidadeTerminais");
			String tamanhoAreaTotal = request.getParameter("tamanhoAreaTotal");
			String capacidadeAvioes = request.getParameter("capacidadeAvioes");
			String torresControle = request.getParameter("torresControle");
			String pistasVoo = request.getParameter("pistasVoo");
	        String localizacao = request.getParameter("localizacao");
	        
	        int identificador = Integer.parseInt(id);
	        int QtdTerminais = Integer.parseInt(quantidadeTerminais);
	        double tmAreaTotal = Double.parseDouble(tamanhoAreaTotal);
	        int capacidadeDeAvioes = Integer.parseInt(capacidadeAvioes);
	        int torresdeControle = Integer.parseInt(torresControle);
	        int pistasdeVoo = Integer.parseInt(pistasVoo);
	        
            System.out.println(identificador);
	        
	        // Monta um objeto aeroporto
	        Aeroportos aeroporto = new Aeroportos();
	        
	        
	        aeroporto.setId(identificador);
	        aeroporto.setNome(nome);
	        aeroporto.setQuantidadeTerminais(QtdTerminais);
	        aeroporto.setTamanhoAreaTotal(tmAreaTotal);
	        aeroporto.setCapacidadeAvioes(capacidadeDeAvioes);
	        aeroporto.setTorresControle(torresdeControle);
	        aeroporto.setPistasVoo(pistasdeVoo);
	        aeroporto.setLocalizacao(localizacao);

	        // Salva o aeroporto
	        AeroportoDao dao = new AeroportoDao();
	        dao.altera(aeroporto);
	        
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/visao/aeroporto-alterado.jsp");
			rd.forward(request,response);
		
	}

}
