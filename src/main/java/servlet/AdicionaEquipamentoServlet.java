package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controle.EquipamentoDAO;
import modelo.Equipamento;

@WebServlet("/adicionaEquipamento")
public class AdicionaEquipamentoServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// busca	o	writer
		//PrintWriter out = response.getWriter();

		//	buscando	os	parâmetros	no	request
		String nomeEquipamento = request.getParameter("nomeequipamento");
		String precoCompra = request.getParameter("precocompra");
		String validade = request.getParameter("validade");
		String lote = request.getParameter("lote");
		String quantidade = request.getParameter("quantidade");
		String marca= request.getParameter("marca");
		String tecnicoResponsavel = request.getParameter("tecnicoresponsavel");
		String dataEmTexto = request.getParameter("datacompra");
		Calendar dataCompra = null;

//		fazendo	a	conversão	da	data
			try {
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
				dataCompra = Calendar.getInstance();
				dataCompra.setTime(date);
			} catch (ParseException e) {
				//out.println("Erro	de	conversão	da	data");
				
				//Redireciona para o jsp mensagem de erro
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/visao/mensagem-erro_equipamento.jsp");
				rd.forward(request, response);
				
				return; // para a execução do método
			}
			
			Double PrecoCompra = Double.parseDouble(precoCompra);
			
			int Quantidade = Integer.parseInt(quantidade);
			   

			//	monta	um	objeto	equipamento
			Equipamento equipamento = new Equipamento();
			equipamento.setNomeEquipamento(nomeEquipamento);
			equipamento.setPrecoCompra(PrecoCompra);
			equipamento.setValidade(validade);
			equipamento.setLote(lote);
			equipamento.setQuantidade(Quantidade);
			equipamento.setMarca(marca);
			equipamento.setTecnicoResponsavel(tecnicoResponsavel);
			equipamento.setDataCompra(dataCompra);

			//	salva	o	equipamento
			EquipamentoDAO dao = new EquipamentoDAO();
			dao.adiciona(equipamento);
			
			//redireciona para o jsp mandar mensagem
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/visao/equipamento-adicionado.jsp");
			rd.forward(request, response);

			
		}

	}
