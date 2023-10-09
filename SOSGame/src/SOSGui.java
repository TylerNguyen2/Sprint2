import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SOSGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton[][] boardButtons;
	private JTextField brdSizeTxtField;
	private SOSBoard board;
	private JLabel playerTurnLabel;
	private JPanel boardPanel;
	private int boardSize = 3;
	private boolean blueChoosesS = true;
	private boolean redChoosesS = true;
	private String blueLetter = "S";
	private String redLetter = "O";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SOSGui frame = new SOSGui();
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
	public SOSGui() {
		
		board = new SOSBoard(boardSize);
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		boardPanel = new JPanel(new GridLayout(boardSize, boardSize));
		boardPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		boardPanel.setBackground(new Color(240, 240, 240));
		boardPanel.setBounds(192, 79, 454, 411);
		getContentPane().add(boardPanel);
		
		boardButtons = new JButton[boardSize][boardSize];
		initBoardButtons();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 11, 797, 517);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnSimple = new JRadioButton("Simple Game");
		rdbtnSimple.setBounds(84, 10, 109, 23);
		panel.add(rdbtnSimple);
		
		JRadioButton rdbtnGeneral = new JRadioButton("General Game");
		rdbtnGeneral.setBounds(210, 10, 109, 23);
		panel.add(rdbtnGeneral);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Record Game");
		chckbxNewCheckBox.setBounds(10, 341, 116, 36);
		panel.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("SOS GAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 10, 68, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Blue Player");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 118, 92, 36);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Red Player");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(685, 118, 92, 36);
		panel.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Replay");
		btnNewButton.setBounds(688, 354, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New Game");
		btnNewButton_1.setBounds(688, 386, 89, 23);
		panel.add(btnNewButton_1);
		
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Human");
		rdbtnNewRadioButton.setBounds(17, 197, 109, 23);
		panel.add(rdbtnNewRadioButton);
		
		JRadioButton sBRdBtn = new JRadioButton("S");
		sBRdBtn.setSelected(true);
		sBRdBtn.setBounds(69, 223, 57, 23);
		panel.add(sBRdBtn);
		sBRdBtn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        blueChoosesS = true;
		    }
		});
		
		JRadioButton oBRdBtn = new JRadioButton("O");
		oBRdBtn.setBounds(69, 249, 57, 23);
		panel.add(oBRdBtn);
		oBRdBtn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        blueChoosesS = false;
		    }
		});
		
		ButtonGroup blueSOGroup = new ButtonGroup();
		blueSOGroup.add(sBRdBtn);
		blueSOGroup.add(oBRdBtn);
		
		
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Computer");
		rdbtnNewRadioButton_2.setBounds(17, 275, 109, 23);
		panel.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("Human");
		rdbtnNewRadioButton_3.setBounds(671, 197, 109, 23);
		panel.add(rdbtnNewRadioButton_3);
		
		JRadioButton sRRdBtn = new JRadioButton("S");
		sRRdBtn.setSelected(true);
		sRRdBtn.setBounds(723, 223, 57, 23);
		panel.add(sRRdBtn);
		
		sRRdBtn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        redChoosesS = true;
		    }
		});
		
		JRadioButton oRRdBtn = new JRadioButton("O");
		oRRdBtn.setBounds(723, 249, 57, 23);
		panel.add(oRRdBtn);
		oRRdBtn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        redChoosesS = false;
		    }
		});
		
		ButtonGroup redSOGroup = new ButtonGroup();
		redSOGroup.add(sRRdBtn);
		redSOGroup.add(oRRdBtn);
		
		
		JRadioButton rdbtnNewRadioButton_2_1 = new JRadioButton("Computer");
		rdbtnNewRadioButton_2_1.setBounds(671, 275, 109, 23);
		panel.add(rdbtnNewRadioButton_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("Board size");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(463, 1, 103, 42);
		panel.add(lblNewLabel_2);
		
		
		JButton applySizeBtn = new JButton("Apply Size\r\n");
		applySizeBtn.setBounds(646, 7, 131, 36);
		panel.add(applySizeBtn);
		applySizeBtn.setForeground(new Color(0, 0, 0));
		applySizeBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		brdSizeTxtField = new JTextField();
		brdSizeTxtField.setBounds(576, 7, 60, 36);
		panel.add(brdSizeTxtField);
		brdSizeTxtField.setHorizontalAlignment(SwingConstants.CENTER);
		brdSizeTxtField.setText("8");
		brdSizeTxtField.setBackground(new Color(255, 255, 255));
		brdSizeTxtField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		brdSizeTxtField.setColumns(10);
		lblNewLabel_2.setLabelFor(brdSizeTxtField);
		
		JLabel currentTurnLabel = new JLabel("Current turn:");
		currentTurnLabel.setBounds(210, 488, 115, 29);
		panel.add(currentTurnLabel);
		currentTurnLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		playerTurnLabel = new JLabel("blue");
		playerTurnLabel.setBounds(338, 488, 81, 29);
		panel.add(playerTurnLabel);
		playerTurnLabel.setForeground(Color.BLUE);
		playerTurnLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		playerTurnLabel.setText("blue"); // Update the playerTurnLabel
		playerTurnLabel.setForeground(Color.BLUE);
		applySizeBtn.addActionListener(e -> reconstructBoardUI());

		board.setTurn('R'); // Set the initial turn to blue
	
		
	}
	private void reconstructBoardUI() {
	    int newSize;
	    try {
	        newSize = Integer.parseInt(brdSizeTxtField.getText().trim());
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "Invalid entry please try again.");
	        return;
	    }

	    if (newSize < 3) {
	        JOptionPane.showMessageDialog(this, "Please enter a size that's at least 3.");
	        return;
	    }

	    boardPanel.removeAll();

	    boardSize = newSize;
	    board = new SOSBoard(boardSize);
	    board.setTurn('R');
	    playerTurnLabel.setText("blue");
        playerTurnLabel.setForeground(Color.BLUE);

	    boardPanel = new JPanel(new GridLayout(boardSize, boardSize));
	    boardPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	    boardPanel.setBackground(new Color(240, 240, 240));
	    boardPanel.setBounds(192, 79, 458, 411);

	    boardButtons = new JButton[boardSize][boardSize];
	    initBoardButtons();

	    getContentPane().add(boardPanel);

	    boardPanel.revalidate();
	    boardPanel.repaint();
	}
	
    private void initBoardButtons() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                JButton btn = new JButton("");
                btn.addActionListener(new ButtonListener(i, j));
                boardPanel.add(btn);
                boardButtons[i][j] = btn;
            }
        }
    }
    private class ButtonListener implements ActionListener {
        private int row;
        private int column;

        public ButtonListener(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            board.makeMove(row, column);
            
            if (board.getTurn() == 'B') {
                boardButtons[row][column].setText(blueChoosesS ? "S" : "O");
            } else {
                boardButtons[row][column].setText(redChoosesS ? "S" : "O");
            }
            toggleTurn();
            boardButtons[row][column].setEnabled(false);
        }
    }
    
    private void toggleTurn() {
        if (board.getTurn() == 'R') {
        	playerTurnLabel.setText("blue");
            playerTurnLabel.setForeground(Color.BLUE);
        } else {
        	playerTurnLabel.setText("red");
            playerTurnLabel.setForeground(Color.RED);
        }
    }
}

