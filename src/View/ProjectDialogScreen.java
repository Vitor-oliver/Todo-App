package View;

import java.awt.BorderLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import Controler.projectControler;
import Model.Project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProjectDialogScreen extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jTextFieldName;

	projectControler controller;
	
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
			ProjectDialogScreen dialog = new ProjectDialogScreen();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProjectDialogScreen() {
		setMinimumSize(new Dimension(450, 370));
		setBounds(100, 100, 458, 384);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JPanel jPanelToolBar = new JPanel();
		jPanelToolBar.setBackground(new Color(0, 153, 102));
		JPanel jPanelProjec = new JPanel();
		jPanelProjec.setBackground(new Color(255, 255, 255));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(jPanelProjec, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
				.addComponent(jPanelToolBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(jPanelToolBar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jPanelProjec, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
		);
		JLabel jLabelName = new JLabel("Nome:");
		jLabelName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		jTextFieldName = new JTextField();
		jTextFieldName.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		jTextFieldName.setColumns(10);
		
		JLabel jLabelDescription = new JLabel("Descrição:");
		jLabelDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JTextArea jTextAreaDescription = new JTextArea();
		jTextAreaDescription.setBorder(new LineBorder(new Color(0, 0, 0)));
		jTextAreaDescription.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		GroupLayout gl_jPanelProjec = new GroupLayout(jPanelProjec);
		gl_jPanelProjec.setHorizontalGroup(
			gl_jPanelProjec.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_jPanelProjec.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jPanelProjec.createParallelGroup(Alignment.TRAILING)
						.addComponent(jTextAreaDescription, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(jTextFieldName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(jLabelName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addComponent(jLabelDescription, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_jPanelProjec.setVerticalGroup(
			gl_jPanelProjec.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelProjec.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabelName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jTextFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(jLabelDescription)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jTextAreaDescription, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
					.addContainerGap())
		);
		jPanelProjec.setLayout(gl_jPanelProjec);
		JLabel jLabelToolBarTitle = new JLabel("Projeto");
		jLabelToolBarTitle.setForeground(new Color(255, 255, 255));
		jLabelToolBarTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		JLabel jLabelToolBarSave = new JLabel("");
		jLabelToolBarSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					if (!jTextFieldName.getText().equals("")) {
						Project project = new Project();
						project.setName(jTextFieldName.getText());
						project.setDescription(jTextAreaDescription.getText());
						
						controller.save(project);
						JOptionPane.showMessageDialog(rootPane, "Projeto salvo com sucesso");
						dispose();
					} else {
						JOptionPane.showMessageDialog(rootPane, "O projeto não foi salvo, pois o campo nome não foi preenchido ");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(rootPane, ex.getMessage());
				}
				
				
			}

			
		});
		jLabelToolBarSave.setIcon(new ImageIcon(ProjectDialogScreen.class.getResource("/todoApp/resources/check.png")));
		GroupLayout gl_jPanelToolBar = new GroupLayout(jPanelToolBar);
		gl_jPanelToolBar.setHorizontalGroup(
			gl_jPanelToolBar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelToolBar.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabelToolBarTitle, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(jLabelToolBarSave, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
		);
		gl_jPanelToolBar.setVerticalGroup(
			gl_jPanelToolBar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanelToolBar.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabelToolBarTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
				.addComponent(jLabelToolBarSave, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
		);
		jPanelToolBar.setLayout(gl_jPanelToolBar);
		contentPanel.setLayout(gl_contentPanel);
		
		controller = new projectControler();
		
		
		
	}
}
