package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import Controler.projectControler;
import Controler.taskController;
import Model.Project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class MainScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable jTableTasks;
	
	projectControler projectController;
	taskController taskController;
	
	DefaultListModel projectModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainScreen() {
		
		setMinimumSize(new Dimension(600, 800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 679);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(600, 800));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel jPanelToolBar = new JPanel();
		jPanelToolBar.setMinimumSize(new Dimension(0, 0));
		jPanelToolBar.setBackground(new Color(0, 153, 102));
		
		JPanel jPanelProjects = new JPanel();
		jPanelProjects.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanelProjects.setBackground(new Color(255, 255, 255));
		
		JPanel jPanelTasks = new JPanel();
		jPanelTasks.setBackground(new Color(255, 255, 255));
		jPanelTasks.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel jPanelProjectList = new JPanel();
		jPanelProjectList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanelProjectList.setBackground(new Color(255, 255, 255));
		
		JPanel jPanel = new JPanel();
		jPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(jPanelToolBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(jPanelProjectList, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jPanelProjects, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(jPanel, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
								.addComponent(jPanelTasks, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE))))
					.addGap(0))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(jPanelToolBar, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(jPanelTasks, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jPanelProjects, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(jPanelProjectList, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
						.addComponent(jPanel, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)))
		);
		
		JScrollPane jScrollPanelProjects = new JScrollPane();
		GroupLayout gl_jPanelProjectList = new GroupLayout(jPanelProjectList);
		gl_jPanelProjectList.setHorizontalGroup(
			gl_jPanelProjectList.createParallelGroup(Alignment.LEADING)
				.addComponent(jScrollPanelProjects, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
		);
		gl_jPanelProjectList.setVerticalGroup(
			gl_jPanelProjectList.createParallelGroup(Alignment.LEADING)
				.addComponent(jScrollPanelProjects, GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
		);
		
		JList jListProjects = new JList();
		//jListProjects.setModel(projectModel);
		jListProjects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListProjects.setSelectionBackground(new Color(0, 153, 102));
		jListProjects.setFont(new Font("Segoe UI", Font.BOLD, 18));
		jListProjects.setFixedCellHeight(50);
		jScrollPanelProjects.setViewportView(jListProjects);
		jPanelProjectList.setLayout(gl_jPanelProjectList);
		
		JLabel jLabelTesksTitle = new JLabel("Tarefas");
		jLabelTesksTitle.setForeground(new Color(0, 153, 102));
		jLabelTesksTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
		
		JLabel jLabelTasksAdd = new JLabel("");
		jLabelTasksAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TaskDialogScreen taskDialogScreen = new TaskDialogScreen();
				//taskDialogScreen.setProject(null);
				taskDialogScreen.setVisible(rootPaneCheckingEnabled);
			}
		});
		jLabelTasksAdd.setIcon(new ImageIcon(MainScreen.class.getResource("/todoApp/resources/add.png")));
		GroupLayout gl_jPanelTasks = new GroupLayout(jPanelTasks);
		gl_jPanelTasks.setHorizontalGroup(
			gl_jPanelTasks.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelTasks.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabelTesksTitle, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 468, Short.MAX_VALUE)
					.addComponent(jLabelTasksAdd)
					.addContainerGap())
		);
		gl_jPanelTasks.setVerticalGroup(
			gl_jPanelTasks.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelTasks.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabelTesksTitle, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
				.addComponent(jLabelTasksAdd, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
		);
		jPanelTasks.setLayout(gl_jPanelTasks);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel jPanelEmptyList = new JPanel();
		tabbedPane.addTab("Sem tarefa", null, jPanelEmptyList, null);
		jPanelEmptyList.setBackground(new Color(255, 255, 255));
		
		JLabel jLabelEmptyListIcon = new JLabel("");
		jLabelEmptyListIcon.setIcon(new ImageIcon(MainScreen.class.getResource("/todoApp/resources/lists.png")));
		jLabelEmptyListIcon.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel jLabelEmptyListTitle = new JLabel("Nenhuma tarefa por aqui :D");
		jLabelEmptyListTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelEmptyListTitle.setFont(new Font("Segoe UI", Font.BOLD, 14));
		jLabelEmptyListTitle.setForeground(new Color(0, 153, 102));
		
		JLabel jLabelEmptyListSubTitle = new JLabel("Clique no botão + para adicionar uma nova tarefa");
		jLabelEmptyListSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelEmptyListSubTitle.setForeground(new Color(192, 192, 192));
		jLabelEmptyListSubTitle.setFont(new Font("Segoe UI", Font.BOLD, 12));
		GroupLayout gl_jPanelEmptyList = new GroupLayout(jPanelEmptyList);
		gl_jPanelEmptyList.setHorizontalGroup(
			gl_jPanelEmptyList.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelEmptyList.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jPanelEmptyList.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabelEmptyListIcon, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
						.addComponent(jLabelEmptyListTitle, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
						.addComponent(jLabelEmptyListSubTitle, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_jPanelEmptyList.setVerticalGroup(
			gl_jPanelEmptyList.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelEmptyList.createSequentialGroup()
					.addGap(194)
					.addComponent(jLabelEmptyListIcon)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jLabelEmptyListTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jLabelEmptyListSubTitle)
					.addContainerGap(252, Short.MAX_VALUE))
		);
		jPanelEmptyList.setLayout(gl_jPanelEmptyList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		jTableTasks = new JTable();
		jTableTasks.setBackground(new Color(255, 255, 255));
		jTableTasks.setGridColor(new Color(255, 255, 255));
		jTableTasks.setRowHeight(50);
		jTableTasks.setShowVerticalLines(false);
		jTableTasks.setSelectionBackground(new Color(0, 255, 172));
		/*jTableTasks.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nome", "Descri\u00E7\u00E3o", "Prazo", "Tarefa Concluida"
			}
		) {
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});*/
		scrollPane.setViewportView(jTableTasks);
		GroupLayout gl_jPanel = new GroupLayout(jPanel);
		gl_jPanel.setHorizontalGroup(
			gl_jPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_jPanel.setVerticalGroup(
			gl_jPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel.createSequentialGroup()
					.addGap(11)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
					.addGap(11))
		);
		jPanel.setLayout(gl_jPanel);
		
		JLabel jLabelProjectsTitle = new JLabel("Projetos");
		jLabelProjectsTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
		jLabelProjectsTitle.setForeground(new Color(0, 153, 102));
		jLabelProjectsTitle.setBackground(new Color(255, 255, 255));
		
		JLabel jLabelProjectsAdd = new JLabel("");
		jLabelProjectsAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProjectDialogScreen projectDialogScreen = new ProjectDialogScreen();
				projectDialogScreen.setVisible(true);
				
				projectDialogScreen.addWindowListener(new WindowAdapter() {
					public void windowClosed(WindowEvent e) {
						loadProjects();
					}
				});
			}
		});
		jLabelProjectsAdd.setIcon(new ImageIcon(MainScreen.class.getResource("/todoApp/resources/add.png")));
		GroupLayout gl_jPanelProjects = new GroupLayout(jPanelProjects);
		gl_jPanelProjects.setHorizontalGroup(
			gl_jPanelProjects.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_jPanelProjects.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabelProjectsTitle, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addComponent(jLabelProjectsAdd)
					.addContainerGap())
		);
		gl_jPanelProjects.setVerticalGroup(
			gl_jPanelProjects.createParallelGroup(Alignment.LEADING)
				.addComponent(jLabelProjectsAdd, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
				.addGroup(gl_jPanelProjects.createSequentialGroup()
					.addGap(11)
					.addComponent(jLabelProjectsTitle, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
		);
		jPanelProjects.setLayout(gl_jPanelProjects);
		
		JLabel jLabelToolBarTitle = new JLabel("Todo App");
		jLabelToolBarTitle.setIcon(new ImageIcon(MainScreen.class.getResource("/todoApp/resources/tick.png")));
		jLabelToolBarTitle.setForeground(new Color(255, 255, 255));
		jLabelToolBarTitle.setFont(new Font("Segoe UI", Font.BOLD, 36));
		
		JLabel jLabelToolBarSubTitle = new JLabel("Anote tudo não esqueça de nada");
		jLabelToolBarSubTitle.setForeground(new Color(255, 255, 255));
		jLabelToolBarSubTitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GroupLayout gl_jPanelToolBar = new GroupLayout(jPanelToolBar);
		gl_jPanelToolBar.setHorizontalGroup(
			gl_jPanelToolBar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelToolBar.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jPanelToolBar.createParallelGroup(Alignment.LEADING)
						.addComponent(jLabelToolBarTitle, GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
						.addComponent(jLabelToolBarSubTitle, GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_jPanelToolBar.setVerticalGroup(
			gl_jPanelToolBar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelToolBar.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabelToolBarTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jLabelToolBarSubTitle)
					.addContainerGap(47, Short.MAX_VALUE))
		);
		jPanelToolBar.setLayout(gl_jPanelToolBar);
		contentPane.setLayout(gl_contentPane);
		decorateTableTask();
		initDataController();
		initComponentsModel();
		jListProjects.setModel(projectModel);
	}
	
	
	public void decorateTableTask() {
		//Customizando o Header da table de tarefas
		jTableTasks.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		jTableTasks.getTableHeader().setBackground(new Color(0,153,102));
		jTableTasks.getTableHeader().setForeground(new Color(0,153,102));
		//Criando um sort automatico para as colunas da table
		jTableTasks.setAutoCreateRowSorter(true);
	}
	
	public void initDataController() {
		projectController = new projectControler();
		taskController = new taskController();
	}
	
	public void initComponentsModel() {
		projectModel = new DefaultListModel(); 
		loadProjects();
	}
	
	public void loadProjects() {
		List<Project> projects = projectControler.getAll();
		
		projectModel.clear();
		
		for (int i = 0; i < projects.size(); i++) {
			Project project = projects.get(i);
			
			projectModel.addElement(project);
		}
		
		
	}
	
}