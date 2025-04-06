package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/alteraEquipamento")
public class AlteraEquipamentoServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// busca	o	writer
				PrintWriter out = response.getWriter();

				//	buscando	os	parâmetros	no	request
				String id = request.getParameter("identificador");
				String nomeEquipamento = request.getParameter("nomeequipamento");
				String precoCompra = request.getParameter("precocompra");
				String validade = request.getParameter("validade");
				String dataEmTexto = request.getParameter("datacompra");
				Calendar dataCompra = null;
				String lote = request.getParameter("lote");
				String quantidades = request.getParameter("quantidade");
				String marca = request.getParameter("marca");
				String tecnicoResponsavel = request.getParameter("tecnicoresponsavel");
				
				
				//	fazendo	a	conversão	da	data
				try {
					Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
					dataCompra = Calendar.getInstance();
					dataCompra.setTime(date);
				} catch (ParseException e) {
					out.println("Erro	de	conversão	da	data");
					return; // para a execução do método
				}
				
				long identificador = Long.parseLong(id);
				
				double PrecoCompra = Double.parseDouble(precoCompra);
				
				int quantidade = Integer.parseInt(quantidades);
				
				
				//	monta	um	objeto	contato
				
				Equipamento equipamento = new Equipamento();
				equipamento.setId(identificador);
				equipamento.setNomeEquipamento(nomeEquipamento);
				equipamento.setDataCompra(dataCompra);
				equipamento.setPrecoCompra(PrecoCompra);
				equipamento.setValidade(validade);
				equipamento.setLote(lote);
				equipamento.setQuantidade(quantidade);
				equipamento.setMarca(marca);
				equipamento.setTecnicoResponsavel(tecnicoResponsavel);
				
				
				//	salva	o	equipamento
				EquipamentoDAO dao = new EquipamentoDAO();
				dao.altera(equipamento);

				//redireciona para o jsp mandar mensagem
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/visao/equipamento-alterado.jsp");
				rd.forward(request, response);
			}

		}
