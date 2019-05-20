package aplicacao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Semestre;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner(System.in);
		
		EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager entityManager= entityManagerFactory.createEntityManager();
		
		System.out.println("Digite 1 para: Listar Semestre cadastrados\n"+"Digite 2 para: "
				+ "Buscar um Semestre por ID\n"+"Digite 3 para: Cadastrar um Semestre\n"+
				"Digite 4 para: Atualizar Semestre\n"+"Digite 5 para: Remover um Semestre\n"+
				"Digite 0 para: Sair do Banco\n");
		int escolha = ler.nextInt();
		while(escolha != 0) {
		if(escolha==1) {
			String jpql="SELECT s FROM Semestre s";
			List<Semestre>semestre = entityManager.createQuery(jpql,Semestre.class).getResultList();
			System.out.println(semestre);
			System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
					+"Digite 1 para: Listar Semestre cadastrados\n"+"Digite 2 para: "
					+ "Buscar um Semestre por ID\n"+"Digite 3 para: Cadastrar um Semestre\n"+
					"Digite 4 para: Atualizar Semestre\n"+"Digite 5 para: Remover um Semestre\n"+
					"Digite 0 para: Sair do Banco\n");
			escolha = ler.nextInt();
		}
		else if(escolha==2) {
			System.out.println("Digite o ID a ser procurado:");
			int id=ler.nextInt();
			Semestre semestreFound= entityManager.find(Semestre.class,id);
			if(semestreFound != null) {
			System.out.println(semestreFound);
			System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
					+"Digite 1 para: Listar Semestre cadastrados\n"+"Digite 2 para: "
					+ "Buscar um Semestre por ID\n"+"Digite 3 para: Cadastrar um Semestre\n"+
					"Digite 4 para: Atualizar Semestre\n"+"Digite 5 para: Remover um Semestre\n"+
					"Digite 0 para: Sair do Banco\n");
			escolha = ler.nextInt();
			}
			else if(semestreFound==null ) {
				System.out.println("Id não encontrado!");
			System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
					+"Digite 1 para: Listar Semestre cadastrados\n"+"Digite 2 para: "
					+ "Buscar um Semestre por ID\n"+"Digite 3 para: Cadastrar um Semestre\n"+
					"Digite 4 para: Atualizar Semestre\n"+"Digite 5 para: Remover um Semestre\n"+
					"Digite 0 para: Sair do Banco\n");
			escolha = ler.nextInt();
			}
		}
		  else if (escolha==3) {
			Integer ano=0;
			Integer periodo=0;
			System.out.println("Digite o ano entre 2014 e 2020:");
			ano =ler.nextInt();
			System.out.println("Digite o periodo:1 ou 2");
			periodo=ler.nextInt();
			if(ano>2013 && ano<2021 && periodo==1|| periodo == 2) {
			Semestre semestre = new Semestre(null, ano, periodo);
			entityManager.getTransaction().begin();
			entityManager.persist(semestre);
			entityManager.getTransaction().commit();
			System.out.println("Cadastro feito com sucesso!");
			System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
					+"Digite 1 para: Listar Semestre cadastrados\n"+"Digite 2 para: "
					+ "Buscar um Semestre por ID\n"+"Digite 3 para: Cadastrar um Semestre\n"+
					"Digite 4 para: Atualizar Semestre\n"+"Digite 5 para: Remover um Semestre\n"+
					"Digite 0 para: Sair do Banco\n");
			escolha = ler.nextInt();
			}else
				System.out.println("Tente novamente, Id ou Periodo Inválido");
		}
		else if(escolha==4) {
			System.out.println("Digite o ID a ser atualizado:");
			int id=ler.nextInt();
			Semestre semestreFound= entityManager.find(Semestre.class,id);
			if(semestreFound==null) {
				System.out.println("Id não existe!");
				System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
						+"Digite 1 para: Listar Semestre cadastrados\n"+"Digite 2 para: "
						+ "Buscar um Semestre por ID\n"+"Digite 3 para: Cadastrar um Semestre\n"+
						"Digite 4 para: Atualizar Semestre\n"+"Digite 5 para: Remover um Semestre\n"+
						"Digite 0 para: Sair do Banco\n");
				escolha = ler.nextInt();
			}
			else if(semestreFound!=null) {
			System.out.println("Se deseja atualizar:\n ano:Digite 1\n periodo:Digite 2\n"
					+ "os dois anteriores: Digite 3");
			int escolhaDeAlteracao = ler.nextInt();
			if(escolhaDeAlteracao==1) {
				System.out.println("Alterar ano para:");
				Integer novoAno= ler.nextInt();
				semestreFound.setAno(novoAno);
				entityManager.getTransaction().begin();
				entityManager.persist(semestreFound);
				entityManager.getTransaction().commit();
				System.out.println("Alteração feita com sucesso!");
				System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
						+"Digite 1 para: Listar Semestre cadastrados\n"+"Digite 2 para: "
						+ "Buscar um Semestre por ID\n"+"Digite 3 para: Cadastrar um Semestre\n"+
						"Digite 4 para: Atualizar Semestre\n"+"Digite 5 para: Remover um Semestre\n"+
						"Digite 0 para: Sair do Banco\n");
				escolha = ler.nextInt();
			}
			else if(escolhaDeAlteracao==2) {
				System.out.println("Alterar periodo para:");
				Integer novoPeriodo= ler.nextInt();
				semestreFound.setPeriodo(novoPeriodo);
				entityManager.getTransaction().begin();
				entityManager.persist(semestreFound);
				entityManager.getTransaction().commit();
				System.out.println("Alteração feita com sucesso!");
				System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
						+"Digite 1 para: Listar Semestre cadastrados\n"+"Digite 2 para: "
						+ "Buscar um Semestre por ID\n"+"Digite 3 para: Cadastrar um Semestre\n"+
						"Digite 4 para: Atualizar Semestre\n"+"Digite 5 para: Remover um Semestre\n"+
						"Digite 0 para: Sair do Banco\n");
				escolha = ler.nextInt();
			}
			else if(escolhaDeAlteracao==3) {
				System.out.println("Alterar ano para:");
				Integer novoAno= ler.nextInt();
				semestreFound.setAno(novoAno);
				System.out.println("Alterar periodo para:");
				Integer novoPeriodo= ler.nextInt();
				semestreFound.setPeriodo(novoPeriodo);
				entityManager.getTransaction().begin();
				entityManager.persist(semestreFound);
				entityManager.getTransaction().commit();
				System.out.println("Alteração feita com sucesso!");
				System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
						+"Digite 1 para: Listar Semestre cadastrados\n"+"Digite 2 para: "
						+ "Buscar um Semestre por ID\n"+"Digite 3 para: Cadastrar um Semestre\n"+
						"Digite 4 para: Atualizar Semestre\n"+"Digite 5 para: Remover um Semestre\n"+
						"Digite 0 para: Sair do Banco\n");
				escolha = ler.nextInt();
			}
			
			}
		}
		else if(escolha==5) {
			System.out.println("Digite o ID a ser removido:");
			int id=ler.nextInt();
			Semestre semestreFound= entityManager.find(Semestre.class,id);
			if(semestreFound!=null) {
			entityManager.getTransaction().begin();
			entityManager.remove(semestreFound);
			entityManager.getTransaction().commit();
			System.out.println("Removido com sucesso!");
			System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
					+"Digite 1 para: Listar Semestre cadastrados\n"+"Digite 2 para: "
					+ "Buscar um Semestre por ID\n"+"Digite 3 para: Cadastrar um Semestre\n"+
					"Digite 4 para: Atualizar Semestre\n"+"Digite 5 para: Remover um Semestre\n"+
					"Digite 0 para: Sair do Banco\n");
			escolha = ler.nextInt();
			}
			else if(semestreFound==null) {
				System.out.println("Id não existe!");
				System.out.println("Se deseja fazer mais alterações no Banco de Dados:\n"
						+"Digite 1 para: Listar Semestre cadastrados\n"+"Digite 2 para: "
						+ "Buscar um Semestre por ID\n"+"Digite 3 para: Cadastrar um Semestre\n"+
						"Digite 4 para: Atualizar Semestre\n"+"Digite 5 para: Remover um Semestre\n"+
						"Digite 0 para: Sair do Banco\n");
				escolha = ler.nextInt();
				
			}
		}

		
	 }	
		if(escolha==0) {
			entityManager.close();
			entityManagerFactory.close();
			System.out.println("Bye!");
			}
	

		
	}
	

}
