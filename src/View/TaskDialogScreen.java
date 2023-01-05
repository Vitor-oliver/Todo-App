package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import Controler.taskController;
import Model.Project;
import Model.Task;

import java.awt.Dimension;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TaskDialogScreen extends JDialog {
	
	

	private final JPanel contentPanel = new JPanel();
	private JTextField jTextFieldName;
	
	taskController controller;
	Project project;

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
		
		try {
			TaskDialogScreen dialog = new TaskDialogScreen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TaskDialogScreen() {
		setMinimumSize(new Dimension(450, 550));
		setBounds(100, 100, 450, 561);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JPanel jPanelToolBar = new JPanel();
		jPanelToolBar.setBackground(new Color(0, 153, 102));
		JPanel jPanelTask = new JPanel();
		jPanelTask.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(jPanelToolBar, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(jPanelTask, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(jPanelToolBar, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jPanelTask, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE))
		);
		JLabel jLabelName = new JLabel("Nome: ");
		jTextFieldName = new JTextField();
		jTextFieldName.setColumns(10);
		JLabel jLabelDescription = new JLabel("Descrição:");
		JTextArea jTextAreaDescription = new JTextArea();
		jTextAreaDescription.setBorder(new LineBorder(new Color(0, 0, 0)));
		JLabel jLabelDeadline = new JLabel("Prazo: ");
		JLabel jLabelNotes = new JLabel("Notas: ");
		
		JTextArea jTextAreaNotes = new JTextArea();
		jTextAreaNotes.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		MaskFormatter mascaraData = null;
		
		try {
			mascaraData = new MaskFormatter("##/##/####");
	        mascaraData.setPlaceholderCharacter('_');
		} catch (ParseException excp) {
            System.err.println("Erro na formatação: " + excp.getMessage());
		}
		
		JFormattedTextField jFormatedTextFieldDeadline = new JFormattedTextField(mascaraData);
		jFormatedTextFieldDeadline.setBounds(150,160,100,20); 
        
		GroupLayout gl_jPanelTask = new GroupLayout(jPanelTask);
		gl_jPanelTask.setHorizontalGroup(
			gl_jPanelTask.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_jPanelTask.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jPanelTask.createParallelGroup(Alignment.LEADING)
						.addComponent(jTextAreaNotes, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(jTextAreaDescription, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(jTextFieldName, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(jLabelName, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(jLabelDescription, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(jLabelDeadline, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(jLabelNotes, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(jFormatedTextFieldDeadline, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_jPanelTask.setVerticalGroup(
			gl_jPanelTask.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelTask.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabelName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jTextFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jLabelDescription)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jTextAreaDescription, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jLabelDeadline)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jFormatedTextFieldDeadline, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(jLabelNotes)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jTextAreaNotes, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
					.addContainerGap())
		);
		jPanelTask.setLayout(gl_jPanelTask);
		JLabel jLabelToolBarTitle = new JLabel("Tarefa");
		jLabelToolBarTitle.setForeground(new Color(255, 255, 255));
		jLabelToolBarTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
		JLabel jLabelToolBarSave = new JLabel("");
		jLabelToolBarSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				try {
					Task task = new Task();
					task.setIdProject(project.getId());
					task.setName(jTextFieldName.getText());
					task.setDescription(jTextAreaDescription.getText());
					task.setNotes(jTextAreaNotes.getText());
					task.setCompleted(false);
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					Date deadLine = null;
					
					deadLine = dateFormat.parse(jFormatedTextFieldDeadline.getText());
					task.setDeadline(deadLine);
					controller.save(task);
					JOptionPane.showMessageDialog(rootPane, "Tarefa salva com sucesso");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(rootPane, e.getMessage());
				}
				
				dispose();
			}
		});
		jLabelToolBarSave.setIcon(new ImageIcon(TaskDialogScreen.class.getResource("/todoApp/resources/check.png")));
		GroupLayout gl_jPanelToolBar = new GroupLayout(jPanelToolBar);
		gl_jPanelToolBar.setHorizontalGroup(
			gl_jPanelToolBar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelToolBar.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabelToolBarTitle, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
					.addComponent(jLabelToolBarSave, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
		);
		gl_jPanelToolBar.setVerticalGroup(
			gl_jPanelToolBar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelToolBar.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabelToolBarTitle, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(jLabelToolBarSave, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
		);
		jPanelToolBar.setLayout(gl_jPanelToolBar);
		contentPanel.setLayout(gl_contentPanel);
	
		controller = new taskController();
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
		
}
