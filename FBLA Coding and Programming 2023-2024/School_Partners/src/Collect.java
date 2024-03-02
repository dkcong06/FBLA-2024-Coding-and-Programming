
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class Collect extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel collectMainText;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JTextField resourceTextField;
	private JTextField contactTextField;
	private JTextField donatedTextField;
	private JLabel resourceLabel;
	private JLabel contactLabel;
	private JLabel organizationLabel;
	private JLabel donatedLabel;
	private JComboBox monthBox;
	private JComboBox dateBox;
	private JComboBox yearBox;
	private JTextField textType;

	/**
	 * Create the frame.
	 */
	public Collect(PartnerTableModel partnerModel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(67, 149, 732, 540);
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		panel.setBackground(new Color(255, 255, 224));
		contentPane.add(panel);
		panel.setLayout(null);

		// text field to put name
		nameTextField = new JTextField();
		nameTextField.setBounds(327, 33, 364, 36);
		nameTextField.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		panel.add(nameTextField);
		nameTextField.setColumns(10);

		// text field to put resources available.
		resourceTextField = new JTextField();
		resourceTextField.setBounds(327, 171, 364, 36);
		resourceTextField.setColumns(10);
		panel.add(resourceTextField);

		// text field to put contact information
		contactTextField = new JTextField();
		contactTextField.setBounds(327, 240, 364, 36);
		contactTextField.setColumns(10);
		panel.add(contactTextField);

		// text field to put amount donated
		donatedTextField = new JTextField();
		donatedTextField.setBounds(327, 378, 364, 36);
		donatedTextField.setColumns(10);
		panel.add(donatedTextField);

		// name label
		nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(34, 22, 149, 51);
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setFont(new Font("Sylfaen", Font.PLAIN, 28));
		panel.add(nameLabel);

		// date label
		JLabel dateLabel = new JLabel("Date:");
		dateLabel.setBounds(34, 95, 149, 51);
		dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dateLabel.setFont(new Font("Sylfaen", Font.PLAIN, 28));
		panel.add(dateLabel);

		// resources available label
		resourceLabel = new JLabel("Resource Available: ");
		resourceLabel.setBounds(34, 168, 276, 51);
		resourceLabel.setHorizontalAlignment(SwingConstants.LEFT);
		resourceLabel.setFont(new Font("Sylfaen", Font.PLAIN, 28));
		panel.add(resourceLabel);

		// contact information label
		contactLabel = new JLabel("Contact Information:");
		contactLabel.setBounds(34, 241, 276, 51);
		contactLabel.setHorizontalAlignment(SwingConstants.LEFT);
		contactLabel.setFont(new Font("Sylfaen", Font.PLAIN, 28));
		panel.add(contactLabel);

		// type of organization label
		organizationLabel = new JLabel("Type of Organization:");
		organizationLabel.setBounds(34, 314, 276, 51);
		organizationLabel.setHorizontalAlignment(SwingConstants.LEFT);
		organizationLabel.setFont(new Font("Sylfaen", Font.PLAIN, 28));
		panel.add(organizationLabel);

		// amount donated label
		donatedLabel = new JLabel("Amount Donated:");
		donatedLabel.setBounds(34, 387, 276, 51);
		donatedLabel.setHorizontalAlignment(SwingConstants.LEFT);
		donatedLabel.setFont(new Font("Sylfaen", Font.PLAIN, 28));
		panel.add(donatedLabel);

		// drop down box for month
		monthBox = new JComboBox();
		monthBox.setBounds(327, 100, 98, 36);
		monthBox.setMaximumRowCount(13);
		String[] months = new String[13];
		months[0] = "mm";
		for (int i = 1; i < 13; i++) {
			months[i] = String.format("%02d", i);
		}
		monthBox.setModel(new DefaultComboBoxModel(months));
		panel.add(monthBox);

		// drop down box for date
		dateBox = new JComboBox();
		dateBox.setBounds(430, 100, 81, 36);
		String[] days = new String[32];
		days[0] = "dd";
		for (int i = 1; i < 32; i++) {
			days[i] = String.format("%02d", i);
		}
		dateBox.setModel(new DefaultComboBoxModel(days));
		dateBox.setMaximumRowCount(32);
		panel.add(dateBox);

		// drop down box for year
		yearBox = new JComboBox();
		yearBox.setBounds(517, 100, 98, 36);
		String[] years = new String[52];
		years[0] = "yyyy";
		for (int i = 1; i < 52; i++) {
			years[i] = String.valueOf(i + 1974);
		}
		yearBox.setModel(new DefaultComboBoxModel(years));
		yearBox.setMaximumRowCount(50);
		panel.add(yearBox);

		// button to submit information
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(252, 460, 228, 56);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Sylfaen", Font.PLAIN, 25));
		btnNewButton.setForeground(new Color(255, 0, 0));

		panel.add(btnNewButton);

		textType = new JTextField();
		textType.setColumns(10);
		textType.setBounds(327, 314, 364, 36);
		panel.add(textType);

		// submit information text
		collectMainText = new JLabel("Submit Information");
		collectMainText.setBounds(67, 22, 1148, 149);
		collectMainText.setHorizontalAlignment(SwingConstants.CENTER);
		collectMainText.setForeground(Color.RED);
		collectMainText.setFont(new Font("Sylfaen", Font.BOLD, 70));
		collectMainText.setBackground(Color.RED);
		contentPane.add(collectMainText);

		this.setModal(true);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] newPartner = new Object[partnerModel.getColumnCount()];
				newPartner[0] = nameTextField.getText().trim();
				newPartner[2] = Float.valueOf(donatedTextField.getText());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
				newPartner[1] = LocalDate.parse(yearBox.getSelectedItem().toString() + "-"
						+ monthBox.getSelectedItem().toString() + "-" + dateBox.getSelectedItem().toString(),
						formatter);
				newPartner[3] = contactTextField.getText();
				newPartner[4] = textType.getText();
				newPartner[5] = resourceTextField.getText();
				partnerModel.addPartner(newPartner);

				// reset all text field
				nameTextField.setText("");
				contactTextField.setText("");
				resourceTextField.setText("");
				donatedTextField.setText("");
				yearBox.setSelectedIndex(0);
				monthBox.setSelectedIndex(0);
				dateBox.setSelectedIndex(0);
				textType.setText("");
			}
		});
	}
}
