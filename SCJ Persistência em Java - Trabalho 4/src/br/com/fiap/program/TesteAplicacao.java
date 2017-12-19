package br.com.fiap.program;

import java.util.Date;
import java.util.List;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.entity.Agenda;
import br.com.fiap.entity.MaterialMedicamento;
import br.com.fiap.entity.Paciente;
import br.com.fiap.entity.Procedimento;

public class TesteAplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			GenericDAO<Paciente> daoPaciente = new GenericDAO<>(Paciente.class);
			GenericDAO<Agenda> daoAgenda = new GenericDAO<>(Agenda.class);
			
			//Definindo uma agenda
			Agenda agenda = new Agenda();
			agenda.setDescricao("Consulta");
			agenda.setData(new Date());
			agenda.setHora(new Date());

			//Definindo o primeiro paciente
			Paciente paciente = new Paciente();
			paciente.setCpf("11122233344");
			paciente.setNome("ADEMIR SAMPAIO");
			paciente.setDataNascimento(new Date());
			paciente.setTelefone("988887777");
			agenda.getPacientes().add(paciente);
			
			//Definindo dois procedimentos - primeiro paciente
			Procedimento procedimento = new Procedimento();
			procedimento.setDescricao("Curativo");
			procedimento.setPreco(100.0);
			procedimento.setPaciente(paciente);
			paciente.getProcedimentos().add(procedimento);
			
			procedimento = new Procedimento();
			procedimento.setDescricao("Inalação");
			procedimento.setPreco(75.0);
			procedimento.setPaciente(paciente);
			paciente.getProcedimentos().add(procedimento);
			
			//Definindo Material/Medicamento - primeiro paciente
			MaterialMedicamento materialMedicamento = new MaterialMedicamento();
			materialMedicamento.setDescricao("Esparadrapo");
			materialMedicamento.setPreco(5.0);
			materialMedicamento.setFabricante("Cremer");
			materialMedicamento.setPaciente(paciente);
			paciente.getMateriaisMedicamentos().add(materialMedicamento);

			materialMedicamento = new MaterialMedicamento();
			materialMedicamento.setDescricao("Berotec");
			materialMedicamento.setPreco(25.0);
			materialMedicamento.setFabricante("Boehringher Ingelheim");
			materialMedicamento.setPaciente(paciente);
			paciente.getMateriaisMedicamentos().add(materialMedicamento);
			
			daoPaciente.adicionar(paciente);
			
			daoAgenda.adicionar(agenda);
			
			System.out.println("Primeiro paciente inserido com sucesso!");

			//Definindo segunda agenda
			agenda = new Agenda();
			agenda.setDescricao("Retorno");
			agenda.setData(new Date());
			agenda.setHora(new Date());

			//Definindo o segundo paciente
			paciente = new Paciente();
			paciente.setCpf("55566677788");
			paciente.setNome("ALMIR RAMOS");
			paciente.setDataNascimento(new Date());
			paciente.setTelefone("999911212");
			agenda.getPacientes().add(paciente);
			
			//Definindo procedimento - segundo paciente
			procedimento = new Procedimento();
			procedimento.setDescricao("Aplicação injeção");
			procedimento.setPreco(5.0);
			procedimento.setPaciente(paciente);
			paciente.getProcedimentos().add(procedimento);
			
			//Definindo Material/Medicamento - segundo paciente
			materialMedicamento = new MaterialMedicamento();
			materialMedicamento = new MaterialMedicamento();
			materialMedicamento.setDescricao("Celestamine");
			materialMedicamento.setPreco(25.0);
			materialMedicamento.setFabricante("Schering");
			materialMedicamento.setPaciente(paciente);
			paciente.getMateriaisMedicamentos().add(materialMedicamento);
			
			daoPaciente.adicionar(paciente);
			
			daoAgenda.adicionar(agenda);
			
			System.out.println("Segundo paciente inserido com sucesso!");

			//Definindo o terceiro paciente
			paciente = new Paciente();
			paciente.setCpf("99900011122");
			paciente.setNome("MARCIO XAVIER");
			paciente.setDataNascimento(new Date());
			paciente.setTelefone("81829922");
			agenda.getPacientes().add(paciente);
		
			daoPaciente.adicionar(paciente);
			
			daoAgenda.atualizar(agenda);
			
			System.out.println("Terceiro paciente inserido com sucesso!");	
			
			//Listar pacientes
			listarPacientes(daoPaciente.listar("A"));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void listarPacientes(List<Paciente> lista) {
		System.out.println("--- Clientes / Pedidos ---");
		for(Paciente p : lista){
			System.out.println("Paciente: " + p.getCpf() + " Nome: " + p.getNome() + " Telefone: " + p.getTelefone());
			System.out.println("------------Procedimentos-------------------");
			for(Procedimento pr : p.getProcedimentos()) {
				System.out.println("    Procedimento: " + pr.getId() + " Descrição: " + pr.getDescricao() + " Preço: " + pr.getPreco());
			}
			System.out.println("------------Materiais/Medicamentos----------");
			for(MaterialMedicamento mm : p.getMateriaisMedicamentos()) {
				System.out.println("    Material/Medicamento: " + mm.getId() + " Descrição: " + mm.getDescricao() + " Preço: " + mm.getPreco() + "Fabricante: " + mm.getFabricante());
			}
			System.out.println("--------------------------------");
		}	
	}	
}



