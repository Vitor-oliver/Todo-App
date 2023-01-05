package Controler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Project;
import util.ConnectionFactory;

public class projectControler {
	
	public void save(Project project) {
			
			String sql = "INSERT INTO projects (name, description, creatAt, updateAt) VALUES (?, ?, ?, ?)";
			Connection connection = null;
			PreparedStatement statement = null;
			
			try {
				connection = ConnectionFactory.getConnection();
				statement = connection.prepareStatement(sql);
				statement.setString(1, project.getName());
				statement.setString(2, project.getDescription());
				statement.setDate(3, new Date(project.getCratedAt().getTime()));
				statement.setDate(4, new Date(project.getUpdateAt().getTime()));
				statement.execute();
			} catch (Exception ex) {
				throw new RuntimeException("Erro ao salvar o Projeto: " + ex.getMessage(), ex);
			} finally {
				ConnectionFactory.closeConnection(connection, statement);
			}
		}

	public void update(Project project) {
		
			String sql = "UPDATE projects SET name = ?, description = ?, creatAt = ?, updateAt = ? WHERE id = ?";
			Connection connection = null;
			PreparedStatement statement = null;
		
			try {
				//Estabelecendo a conexão com o banco de dados 
				connection = ConnectionFactory.getConnection();
				// Preparando a quer
				statement = connection.prepareStatement(sql);
				//Setando os valores no statement
				statement.setString(1, project.getName());
				statement.setString(2, project.getDescription());
				statement.setDate(3,new Date(project.getCratedAt().getTime()));
				statement.setDate(4,new Date(project.getUpdateAt().getTime()));
				statement.setInt(5, project.getId());
				//Executando a query
				statement.execute();
			} catch (Exception ex) {
				throw new RuntimeException("Erro ao atualizar o Projeto: " + ex.getMessage(), ex);
			} finally {
				ConnectionFactory.closeConnection(connection, statement);
			}
		}
	
	public void removeById(int idProject) {
		
		String sql = "DELETE FROM projects WHERE id = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			//Criação da connexcao com o bando de dados
			connection = ConnectionFactory.getConnection();
			//Preparando a query
			statement = connection.prepareStatement(sql);
			//setando valores
			statement.setInt(1, idProject);
			//Executando a query
			statement.execute();
		} catch (SQLException ex) {
			throw new RuntimeException("Erro ao deletar a tarefa: " + ex.getMessage(), ex);
		} finally {
			ConnectionFactory.closeConnection(connection, statement);
		}
		
	}
	
	public static List<Project> getAll(){
			
			String sql = "SELECT * FROM projects";
			Connection connection = null;
			PreparedStatement statement = null;
			ResultSet resultSet = null;
			
			//Lista de tarefas que será devolvida quando a chamada do método acontecer
			List<Project> projects = new ArrayList<Project>();
			
			try {
				//Criacao da conexão
				connection = ConnectionFactory.getConnection();
				statement = connection.prepareStatement(sql);
				//Valor retornado pela execusão da query
				resultSet = statement.executeQuery();
				
				//Enquanto houverem valores a serem percorridos no result set
				while (resultSet.next()) {
					Project project = new Project();
					
					project.setId(resultSet.getInt("id"));
					project.setName(resultSet.getString("name"));
					project.setDescription(resultSet.getString("description"));
					project.setCratedAt(resultSet.getDate("creatAt"));
					project.setUpdateAt(resultSet.getDate("updateAt"));
					
					projects.add(project);
				}
				
			} catch (SQLException ex) {
				throw new RuntimeException("Erro ao listar os projetos: " + ex.getMessage(), ex);
			} finally {
				ConnectionFactory.closeConnection(connection, statement, resultSet);
			}
			
			//Lista de tarefas que foi criada e carregada do banco de dados
			return projects;
		}



}
