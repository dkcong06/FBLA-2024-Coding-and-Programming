
import java.awt.event.*;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;

import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class Help extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private HashMap<String, String> hashQA;

	private void setupHash() {

		hashQA = new HashMap<String, String>();

		hashQA.put("Welcome to QA",
				"Welcome to the Williamsville East partner database. In order to find information about a specific partner, please click Search. Enter the \r\npartner’s name and click Enter. A new page with all the information\r\nwill pop up. In order to filter partners by their information (listed \r\nnumerically or alphabetically), click the filter type and press Enter. If you would like to add another partner to the database, press Submit. \r\nAdd all necessary information and press submit. Your information will be added to the database. If you have additional information, add your question into the text box and press Enter. The question will be sent to our email and you will receive a response as soon as possible. ");

		hashQA.put("How do I filter the business partners?",
				"Just type any part of the partner name or related stuff, then click submit to get partners with the word showed");

		hashQA.put("How do I submit partner data?",
				"On the home page, click the “Submit” button. It will open up a new page and there will be a form in which you can submit the information. That information will automatically get added to our partner database.");

		hashQA.put("How do I search for partners?",
				"On the home page, click the “Search” button. It will open up a new page and there will be a search box. In that box, you can search for partners. After you type in the name, be sure to click the “SUBMIT” button. ");

		hashQA.put("What types of partners are there?",
				"There are business and community partners and different types");

		hashQA.put("How do I become a partner? ",
				"There are a variety of ways. You can directly contact the school and offer ideas, supplies, or donate money.");

		hashQA.put("How will the school use the resources from the partners?",
				"We aim to better the school environment for the students by improving the schools resources. We also aim to better the curriculum for the students, and with these donated resources we can achieve that goal.");

	}

	/**
	 * Create the frame.
	 */
	public Help() {

		setupHash();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// help and q&a main text
		JLabel helpLabel = new JLabel("Help / Q&A");
		helpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		helpLabel.setForeground(Color.RED);
		helpLabel.setFont(new Font("Sylfaen", Font.BOLD, 70));
		helpLabel.setBackground(Color.RED);
		helpLabel.setBounds(89, 11, 1148, 149);
		contentPane.add(helpLabel);

		// panel for the help text
		JPanel helpInformation = new JPanel();
		helpInformation.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		helpInformation.setBackground(new Color(255, 255, 224));
		helpInformation.setBounds(67, 205, 740, 434);
		contentPane.add(helpInformation);
		helpInformation.setLayout(null);

		JTextArea textAnswer = new JTextArea();
		textAnswer.setLineWrap(true);
		textAnswer.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAnswer.setBounds(10, 11, 720, 412);
		helpInformation.add(textAnswer);

		// background for text
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 224));
		panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
		panel_1.setBounds(846, 205, 369, 434);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		// label for question box
		JLabel questionLabel = new JLabel("Submit Your Questions!");
		questionLabel.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		questionLabel.setBounds(0, 0, 369, 87);
		panel_1.add(questionLabel);

		// enter button to submit questions
		JButton enterButton = new JButton("Enter");
		enterButton.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		enterButton.setBounds(96, 373, 176, 38);
		panel_1.add(enterButton);

		// area to write questions
		JTextArea questionBox = new JTextArea();
		questionBox.setBounds(31, 98, 309, 252);
		questionBox.setBorder(new LineBorder(new Color(255, 0, 0), 1, true));

		panel_1.add(questionBox);

		JComboBox comboHelp = new JComboBox();
		comboHelp.setBounds(67, 153, 740, 46);
		String[] questions = new String[hashQA.size()];

		int i = 0;
		for (String x : hashQA.keySet()) {
			questions[i] = x;
			i = i + 1;
		}
		comboHelp.setModel(new DefaultComboBoxModel(questions));
		comboHelp.setSelectedItem("Welcome to QA");

		enterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				questionBox.setText("");
			}
		});

		comboHelp.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				textAnswer.setText(hashQA.get(comboHelp.getSelectedItem().toString()));
			}
		});

		textAnswer.setText(hashQA.get(comboHelp.getSelectedItem().toString()));
		contentPane.add(comboHelp);
		this.setModal(true);

	}
}
